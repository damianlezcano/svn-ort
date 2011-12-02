package ort.t6.chat.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import ort.t6.chat.exception.UsuarioExistenteException;
import ort.t6.chat.exception.UsuarioInexistenteException;
import ort.t6.chat.model.Contacto;
import ort.t6.chat.model.mensaje.Error;
import ort.t6.chat.model.mensaje.IMensaje;
import ort.t6.chat.model.mensaje.Lista;
import ort.t6.chat.model.mensaje.Login;
import ort.t6.chat.model.mensaje.Logout;
import ort.t6.chat.model.mensaje.Mensaje;

/**
 * Servidor con hilos 
 * El servidor es un hilo y los clientes otros..
 */
public class ServidorService {
	
	private final static Logger log = Logger.getLogger(ServidorService.class);
	private ServerSocket socket;
	private Map<String, Contacto> usuariosConectados;
	
	public ServidorService(){
		usuariosConectados = new HashMap<String, Contacto>();
	}
	
	public void execute(int port) throws IOException {
		log.info("Abriendo servidor en puerto " + port);
		socket = new ServerSocket(port);
		while (true) {
			log.info("Esperando una conexion");
			try {
				Socket cnx = socket.accept();
				log.info("Conexion recibida");
				AtencionCliente atcli = new AtencionCliente(cnx);
				Thread hilo = new Thread(atcli);
				hilo.start();//inicial el nuevo hilo en forma asincronica
			}
			catch (Exception ex) {
				ex.printStackTrace();
				break; 
			}
		}
		log.info("Proceso finalizado");
	}
	
	//******************************************************************
	
	//InnerClass para el manejo de conexiones
	class AtencionCliente implements Runnable {
		
		private Socket conexion;
		private ObjectInputStream entrada;
		private ObjectOutputStream salida;
		
		public AtencionCliente(Socket cnx) {
			this.conexion = cnx;
		}
		
		public void run() {
			log.info("Atendiendo la conexion...");
			try {
				entrada = new ObjectInputStream(conexion.getInputStream());
				salida = new ObjectOutputStream(conexion.getOutputStream());
				procesar((IMensaje) entrada.readObject());
				log.info("Interpretando entrada...");
			} catch (Exception e) {
				try {
					log.info("Cerrando conexion...");
					entrada.close();
					salida.close();
					conexion.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		private void procesar(IMensaje mensaje) throws IOException{
			if(mensaje instanceof Login){
				procesar((Login) mensaje);
			}else if(mensaje instanceof Logout){
				procesar((Logout) mensaje);
			}else if(mensaje instanceof Mensaje){
				procesar((Mensaje) mensaje);
			}
		}
		
		/**
		 * Agrego contacto a la lista
		 */
		@SuppressWarnings({ "rawtypes", "unchecked" })
		private void procesar(Login mensaje) throws IOException{
			log.info("Login:" + mensaje.toString());
			Contacto contacto = mensaje.getContacto();
			if(usuariosConectados.containsKey(contacto.getNick())){
				Error error = new Error();
				error.setExcepcion(new UsuarioExistenteException());
				salida.writeObject(error);
				log.info("Login error: usuario " + mensaje.toString() + " ya existe");
			}else{
				Lista conectados = new Lista();
				conectados.setUsuarios(new ArrayList(usuariosConectados.values()));
				salida.writeObject(conectados);
				usuariosConectados.put(contacto.getNick(), contacto);
				log.info("usuarios conectados:" + usuariosConectados.size());
			}
		}
		
		/**
		 * Quito contacto de la lista
		 */
		private void procesar(Logout mensaje) throws IOException{
			log.info("Logout:" + mensaje.toString());
			Contacto contacto = mensaje.getContacto();
			if(usuariosConectados.containsKey(contacto.getNick())){
				usuariosConectados.remove(contacto.getNick());
				log.info("usuarios conectados:" + usuariosConectados.size());
			}else{
				Error error = new Error();
				error.setExcepcion(new UsuarioInexistenteException());
				salida.writeObject(error);
				log.info("Login error: usuario " + mensaje.toString() + " no existe");
			}
		}

		private void procesar(Mensaje mensaje){
			log.info("Mensaje:" + mensaje.toString());
			if(mensaje.getDestinos() != null && !mensaje.getDestinos().isEmpty()){
				for (Contacto destino : mensaje.getDestinos()) {
					log.info("Enviar mensaje: " + mensaje.getTexto() + " - a usuario: " + destino.getNick());
				}
			}else{
				log.info("Enviar mensaje a toda la lista de contactos conectados");
			}
		}
	}
}