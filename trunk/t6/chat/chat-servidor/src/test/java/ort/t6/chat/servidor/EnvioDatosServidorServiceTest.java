package ort.t6.chat.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.junit.Test;

import ort.t6.chat.model.Contacto;
import ort.t6.chat.model.Login;

public class EnvioDatosServidorServiceTest {

	@Test
	public void conexion() throws IOException, ClassNotFoundException{
		String host = "localhost";
		int port = 4000;
		
		Login mensaje = new Login();
		Contacto contacto = new Contacto(false, "Pablo","10.0.0.1");
		mensaje.setContacto(contacto);
		
		Socket skt = new Socket(host, port);
		
		try{
			ObjectOutputStream os = new ObjectOutputStream(skt.getOutputStream());
			ObjectInputStream is = new ObjectInputStream(skt.getInputStream());
			
			try{
//				String req = "GET " + path + " HTTP/1.1\r\n" + "host: " + host + "\r\n" + "\r\n";
				//os.write(req.getBytes());//envia el request al servidor
				os.writeObject(mensaje);
				
				byte[] buffer = new byte[32768];
				Object leidos = is.readObject();
			}finally{
				os.close();
				is.close();
			}
		}finally {
			skt.close();//se cierra la conexion
		}
	}
}