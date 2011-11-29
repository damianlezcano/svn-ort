package ort.t6.chat.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

import org.apache.log4j.Logger;

import ort.t6.chat.model.Contacto;
import ort.t6.chat.model.IMensaje;

/**
 * Servidor con hilos 
 * El servidor es un hilo y los clientes otros..
 */
public class ServidorService {
	
	private final static Logger log = Logger.getLogger(ServidorService.class);
	private ServerSocket ss;
	private Map<String, Contacto> usuariosConectados;
	
	class AtencionCliente implements Runnable {
		
		private Socket cnx;
		
		public AtencionCliente(Socket cnx) {
			this.cnx = cnx;
		}
		
		public void run() {
			ObjectInputStream is;
			try {
				is = new ObjectInputStream(cnx.getInputStream());
				ObjectOutputStream os = new ObjectOutputStream(cnx.getOutputStream());
				log.info("Atendiendo la conexión...");

				IMensaje mensaje = (IMensaje) is.readObject();
				log.info(mensaje.toString());
				log.info("Atendiendo la conexión...");

				is.close();
				cnx.close();
			} catch (Exception e) {}
		}
	}
	
	public void execute(int port) throws IOException {
		log.info("Abriendo servidor en puerto " + port);
		ss = new ServerSocket(port);
		while (true) {
			log.info("Esperando una conexión");
			try {
				Socket cnx = ss.accept();
				log.info("Conexión recibida");
				AtencionCliente atcli = new AtencionCliente(cnx);
				Thread hilo = new Thread(atcli);
				hilo.start();//inicial el nuevo hilo en forma asincronica
			}
			catch (Exception ex) { break; }
		}
		log.info("Proceso finalizado");
	}
}