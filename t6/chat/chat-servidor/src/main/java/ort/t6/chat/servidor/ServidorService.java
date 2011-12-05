package ort.t6.chat.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import ort.t6.chat.exception.UsuarioExistenteException;
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
	private Map<Contacto, ObjectOutputStream> usuariosConectados;
	
	public ServidorService(){
		usuariosConectados = new HashMap<Contacto, ObjectOutputStream>();
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
			catch (Exception e) {
				break; 
			}
		}
		log.info("Servidor finalizado");
	}
	
	//******************************************************************
	
	//InnerClass para el manejo de conexiones
	class AtencionCliente implements Runnable {
		
		private Contacto key;
		private Socket conexion;
		private ObjectInputStream entrada;
		private ObjectOutputStream salida;
		
		public AtencionCliente(Socket cnx) {
			try {
				conexion = cnx;
				entrada = new ObjectInputStream(conexion.getInputStream());
				salida = new ObjectOutputStream(conexion.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void run() {
			log.info("Atendiendo la conexion...");
			try {
	            while (true){
					Object mensaje = entrada.readObject();
					procesar((IMensaje) mensaje);
					log.info("despues de procesar la entrada...");
	            }
			} catch (Exception e) {
				log.info("Error: desconectando usuario ");
				
				usuariosConectados.remove(key);
				closeAll();
				
				log.info("Avisamos a todos el usuario que se desconecto");
				List<Contacto> destinos = usuariosConectados();
				Lista listaConectados = new Lista(destinos);
				sendAll(destinos, listaConectados);
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
		private void procesar(Login mensaje) throws IOException{
			log.info("Login:" + mensaje.toString());
			if(usuariosConectados.containsKey(mensaje.getContacto())){
				Error error = new Error();
				error.setExcepcion(new UsuarioExistenteException());
				salida.writeObject(error);
				log.info("Login error: usuario " + mensaje.toString() + " ya existe");
			}else{
				log.info("Login: Guardamos el usuario: " + mensaje.getContacto().getNick() + " en la lista de usuarios conectados");
				key = mensaje.getContacto();
				usuariosConectados.put(key, salida);
				
				log.info("Login: Avisamos a todos que el usuario: " + mensaje.getContacto().getNick() + " se conecto");
				List<Contacto> destinos = usuariosConectados();
				Lista listaConectados = new Lista(destinos);
				sendAll(destinos, listaConectados);
			}
		}
		
		/**
		 * Quito contacto de la lista
		 */
		private void procesar(Logout mensaje) throws IOException{
			log.info("Logout:" + mensaje.toString());
			if(usuariosConectados.containsKey(mensaje.getContacto())){
				log.info("Logout: Quitamos el usuario: " + mensaje.getContacto().getNick() + " en la lista de usuarios conectados");
				usuariosConectados.remove(mensaje.getContacto());
				closeAll();
				
				log.info("Logout: Avisamos a todos que el usuario: " + mensaje.getContacto().getNick() + " se desconecto");
				List<Contacto> destinos = usuariosConectados();
				Lista listaConectados = new Lista(destinos);
				sendAll(destinos, listaConectados);

				log.info("Logout: Usuarios conectados:" + usuariosConectados.size());
			}else{
				log.info("Logout error: usuario " + mensaje.toString() + " no existe");
			}
		}

		private void procesar(Mensaje mensaje){
			log.info("Mensaje:" + mensaje.toString());
			
			List<Contacto> destinos = null;
			
			if(mensaje.getDestinos() != null && !mensaje.getDestinos().isEmpty()){
				destinos = mensaje.getDestinos();
			} else{
				destinos = usuariosConectados();
			}
			
			sendAll(destinos, mensaje);
		}
		
		private void sendAll(List<Contacto> destinos, IMensaje mensaje){
			log.info("sendAll: antes de enviar los mensajes");
			for (Contacto destino : destinos) {
				log.info("sendAll: Enviando mensajes a " + destino.getNick());
				ObjectOutputStream salidaDestino = usuariosConectados.get(destino);
				try {
					salidaDestino.writeObject(mensaje);
				} catch (Exception e) {
					log.info("sendAll: Error al enviar el mensaje");
				}
			}
		}
		
		private List<Contacto> usuariosConectados(){
			List<Contacto> resultado = new ArrayList<Contacto>();
			for (Contacto contacto : usuariosConectados.keySet()) {
				resultado.add(contacto);
			}
			return resultado;
		}
		
		private void closeAll(){
			log.info("closeAll: Cerrando todas las conexiones del usuario");
			try {
				conexion.close();
				entrada.close();
				salida.close();
			} catch (IOException e) {
				log.info("closeAll: Error cerrando las conexiones del usuario");
			}
		}
	}
	
	public static void main(String[] args) {
		ServidorService servidor = new ServidorService();
		try {
			servidor.execute(4000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}