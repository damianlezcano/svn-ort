package ort.t6.chat.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ort.t6.chat.exception.UsuarioExistenteException;
import ort.t6.chat.exception.UsuarioInexistenteException;
import ort.t6.chat.model.Contacto;
import ort.t6.chat.model.mensaje.Error;
import ort.t6.chat.model.mensaje.Lista;
import ort.t6.chat.model.mensaje.Login;
import ort.t6.chat.model.mensaje.Logout;
import ort.t6.chat.model.mensaje.Mensaje;

public class OtherServidorServiceTest {

	private final static Logger log = Logger.getLogger(OtherServidorServiceTest.class);
	
	private static ObjectOutputStream salida;
	private static ObjectInputStream entrada;
	private static Socket conexion;
	
	@BeforeClass
	public static void before() throws UnknownHostException, IOException {
		log.info("** inicio **");
		String host = "localhost";
		int port = 4000;
		conexion = new Socket(host, port);
		salida = new ObjectOutputStream(conexion.getOutputStream());
		entrada = new ObjectInputStream(conexion.getInputStream());
	}

	@AfterClass
	public static void after() throws IOException{
		log.info("** salida **");
		salida.close();
		entrada.close();
		conexion.close();//se cierra la conexion
	}
	
	//**********************************
	
	@Test
	public void login() throws IOException, ClassNotFoundException {
		Login mensaje = new Login();
		Contacto contacto = new Contacto(false, "Pepe","10.0.0.1");
		mensaje.setContacto(contacto);
		salida.writeObject(mensaje);
		Assert.assertNotNull(((Lista)entrada.readObject()));
		
		Mensaje mensajem = new Mensaje();
//		Contacto contacto = new Contacto(false, "Pepe","10.0.0.1");
		mensajem.setContacto(contacto);
		
		Contacto destinatario = new Contacto(false, "Pepe","10.0.0.2");
		List<Contacto> destinatarios = new ArrayList<Contacto>();
		destinatarios.add(destinatario);
		mensajem.setDestinos(destinatarios);
		
		String texto = "Es una prueba";
		mensajem.setTexto(texto);
		salida.writeObject(mensajem);
		
		Mensaje msg = (Mensaje)entrada.readObject();
		Assert.assertTrue(msg.getTexto().equalsIgnoreCase(texto));
		log.info(msg.getTexto());
	}

	//@Test
	public void sendMessage() throws IOException, ClassNotFoundException {
		Mensaje mensaje = new Mensaje();
		Contacto contacto = new Contacto(false, "Pepe","10.0.0.1");
		mensaje.setContacto(contacto);
		
		Contacto destinatario = new Contacto(false, "Pepe","10.0.0.2");
		List<Contacto> destinatarios = new ArrayList<Contacto>();
		destinatarios.add(destinatario);
		mensaje.setDestinos(destinatarios);
		
		mensaje.setTexto("Es una prueba");
		salida.writeObject(mensaje);
	}

	//@Test
	public void sendAllMessage() throws IOException, ClassNotFoundException {
		Mensaje mensaje = new Mensaje();
		Contacto contacto = new Contacto(false, "Pepe","10.0.0.1");
		mensaje.setContacto(contacto);
		
		mensaje.setTexto("Es una prueba");
		salida.writeObject(mensaje);
	}
	
	@Test
	public void logout() throws IOException {
		Logout mensaje = new Logout();
		Contacto contacto = new Contacto(false, "Pepe","10.0.0.1");
		mensaje.setContacto(contacto);
		salida.writeObject(mensaje);
	}
	
}