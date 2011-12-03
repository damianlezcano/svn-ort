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
	
	private static final String CONNECTION_FILE = "/connection.properties";
	private static final String USERS_FILE = "/users.properties";
	private Properties connectionConfiguration;
	private Properties usersConfiguration;
	
	private Socket conexion;
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	
	private Contacto userLogin;
	private String serverHost;
	private Integer serverPort;
	
	private Map<Contacto,List<String>> allContacts;
	
	public Cliente() {
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
		connectionConfiguration = new Properties();
		usersConfiguration = new Properties();
		allContacts = new HashMap<Contacto,List<String>>();
		try {
			connectionConfiguration.load(getClass().getResourceAsStream(CONNECTION_FILE));
			usersConfiguration.load(getClass().getResourceAsStream(USERS_FILE));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void login() throws UnknownHostException, IOException, ClassNotFoundException {
		serverHost = connectionConfiguration.getProperty("serverip");
		serverPort = Integer.valueOf(connectionConfiguration.getProperty("serverport"));
		conexion = new Socket(serverHost, serverPort);
		salida = new ObjectOutputStream(conexion.getOutputStream());
		entrada = new ObjectInputStream(conexion.getInputStream());
		
		InetAddress thisIp =InetAddress.getLocalHost();
		String ip = thisIp.getHostAddress();
		String username = connectionConfiguration.getProperty("userlogin");
		userLogin = new Contacto(false, username,ip);

		Login mensaje = new Login();
		mensaje.setContacto(userLogin);
		salida.writeObject(mensaje);
		
		procesar((IMensaje) entrada.readObject());
	}
	
	public void logout() throws IOException{
		log.info("logout");
		Logout mensaje = new Logout();
		salida.writeObject(mensaje);
		entrada.close();
		salida.close();
		conexion.close();
	}
	
	private void procesar(IMensaje mensaje) throws IOException{
		if(mensaje instanceof Mensaje){
			procesar((Mensaje) mensaje);
		} else if(mensaje instanceof Lista){
			procesar((Lista) mensaje);
		} else if(mensaje instanceof Error){
			procesar((Error) mensaje);
		}	
	}
	
	private void procesar(Mensaje mensaje){
		log.info("Mensaje:" + mensaje.toString());
	}

	private void procesar(Lista mensaje){
		log.info("Lista:" + mensaje.toString());
		Map<Contacto,List<String>> nuevaLista = new HashMap<Contacto,List<String>>();
		List<Contacto> conectados = mensaje.getUsuarios();

		for (Contacto contacto : conectados) {
			if (allContacts.containsKey(contacto)){
				log.info("Lista: " + contacto.getNick() + " existe, se converva los mensajes");
				nuevaLista.put(contacto,nuevaLista.get(contacto));
			}else{
				log.info("Lista: " + contacto.getNick() + " no existe, se agrega a la lista");
				nuevaLista.put(contacto,new ArrayList<String>());
			}
		}
		
//		notificar();
	}
	
	private void procesar(Error mensaje){
		log.info("Error:" + mensaje.toString());
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	public List<Contacto> contactosConectados(){
		return (List<Contacto>) allContacts.keySet();
	}
	
	private void notificar(){
		this.setChanged();
		this.notifyObservers();
	}
	
	
	//**********************************************************

	public Contacto getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(Contacto userLogin) {
		this.userLogin = userLogin;
	}

	public String getServerHost() {
		return serverHost;
	}

	public void setServerHost(String serverHost) {
		this.serverHost = serverHost;
	}

	public Integer getServerPort() {
		return serverPort;
	}

	public void setServerPort(Integer serverPort) {
		this.serverPort = serverPort;
	}

	public Map<Contacto,List<String>> getAllContacts() {
		return allContacts;
	}

	public void setAllContacts(Map<Contacto,List<String>> allContacts) {
		this.allContacts = allContacts;
	}
}
