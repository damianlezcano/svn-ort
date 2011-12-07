package ort.t6.chat.cliente.lib;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import ort.t6.chat.model.Contacto;
import ort.t6.chat.model.mensaje.Error;
import ort.t6.chat.model.mensaje.IMensaje;
import ort.t6.chat.model.mensaje.Lista;
import ort.t6.chat.model.mensaje.Login;
import ort.t6.chat.model.mensaje.Logout;
import ort.t6.chat.model.mensaje.Mensaje;

public class Cliente extends Observable {
	
	private final static Logger log = Logger.getLogger(Cliente.class);
	
	private static final String USERS_FILE = "/users.properties";
	private Properties usersConfiguration;
	
	private Socket conexion;
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	
	private Contacto userLogin;
	private Map<Contacto,List<Mensaje>> usuariosConectados;
	
	public Cliente() {
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
		usersConfiguration = new Properties();
		usuariosConectados = new HashMap<Contacto,List<Mensaje>>();
		try {
			usersConfiguration.load(getClass().getResourceAsStream(USERS_FILE));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void login(String userName, String serverIp, Integer serverPort) throws UnknownHostException, ClassNotFoundException, Exception {
		conexion = new Socket(serverIp, serverPort);
		
		String userIp = InetAddress.getLocalHost().getHostAddress();
		userLogin = new Contacto(false, userName,userIp);

		AtencionServidor atsrv = new AtencionServidor(conexion);
		Thread hilo = new Thread(atsrv);
		
		Login mensaje = new Login();
		mensaje.setContacto(userLogin);
		salida.writeObject(mensaje);
		procesar((IMensaje) entrada.readObject());

		hilo.start();//inicial el nuevo hilo en forma asincronica		
	}
	
	public void logout() throws IOException{
		log.info("logout");
		Logout mensaje = new Logout();
		salida.writeObject(mensaje);
		salida.close();
		entrada.close();
		conexion.close();
		usuariosConectados.clear();
		notificar();
	}
	
	public void send(List<Contacto> destinatarios, Mensaje mensaje) throws IOException, ClassNotFoundException{
		mensaje.setDestinos(destinatarios);
		salida.writeObject(mensaje);
	}
	
	public void send(Contacto destinatario, Mensaje mensaje) throws IOException, ClassNotFoundException{
		mensaje.setContacto(userLogin);
		List<Contacto> destinatarios = new ArrayList<Contacto>();
		destinatarios.add(destinatario);
		mensaje.setDestinos(destinatarios);
		salida.writeObject(mensaje);
		mensaje.setTexto("Yo: " + mensaje.getTexto());
		guardarHistorialMensaje(destinatario, mensaje);
	}
	
	public List<Contacto> contactosConectados(){
		List<Contacto> resultado = new ArrayList<Contacto>();
		for (Contacto contacto : usuariosConectados.keySet()) {
			resultado.add(contacto);
		}
		return resultado;
	}

	public List<Mensaje> mensajesDelContacto(Contacto contacto){
		return usuariosConectados.get(contacto);
	}
	
	private void guardarHistorialMensaje(Contacto contacto, Mensaje mensaje){
		List<Mensaje> historico = mensajesDelContacto(contacto);
		historico.add(mensaje);
	}
	
	private void notificar(){
		this.setChanged();
		this.notifyObservers();
	}
	
	//*********************************************
	// Procesar mensajes
	//*********************************************
	
	private void procesar(IMensaje mensaje) throws Exception{
		if(mensaje instanceof Mensaje){
			procesar((Mensaje) mensaje);
		} else if(mensaje instanceof Lista){
			procesar((Lista) mensaje);
		} else if(mensaje instanceof Error){
			procesar((Error) mensaje);
		}	
	}
	
	private void procesar(Mensaje mensaje){
		log.info("Mensaje:" + mensaje.getTexto());
		mensaje.setTexto(mensaje.getContacto().getNick() + ": " + mensaje.getTexto());
		guardarHistorialMensaje(mensaje.getContacto(),mensaje);
		notificar();
	}

	private void procesar(Lista mensaje){
		log.info("Lista:" + mensaje.toString());
		Map<Contacto,List<Mensaje>> nuevaLista = new HashMap<Contacto,List<Mensaje>>();
		for (Contacto contacto : mensaje.getUsuarios()) {
			if(!userLogin.getNick().equalsIgnoreCase(contacto.getNick())){
				if (usuariosConectados.containsKey(contacto)){
					log.info("Lista: " + contacto.getNick() + " existe, se conserva los mensajes");
					nuevaLista.put(contacto,mensajesDelContacto(contacto));
				}else{
					log.info("Lista: " + contacto.getNick() + " no existe, se agrega a la lista");
					nuevaLista.put(contacto,new ArrayList<Mensaje>());
				}
			}
		}
		usuariosConectados = nuevaLista;
		notificar();
	}
	
	private void procesar(Error mensaje) throws Exception{
		log.info("******Error:" + mensaje.toString());
		throw mensaje.getExcepcion();
	}
	
	//******************************************************************
	
	//InnerClass para el manejo de conexiones
	class AtencionServidor implements Runnable {
		
		public AtencionServidor(Socket cnx) {
			try {
				conexion = cnx;
				salida = new ObjectOutputStream(conexion.getOutputStream());
				entrada = new ObjectInputStream(conexion.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void run() {
			log.info("Atendiendo la conexion del servidor...");
			try {
	            while (true){
					Object mensaje = entrada.readObject();
					procesar((IMensaje) mensaje);
	            }
			} catch (Exception e) {
				log.info("Error: desconectando del servidor ");
				try {
					logout();
				} catch (IOException e1) {}
			}
		}

	}
}