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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ort.t6.chat.exception.UsuarioExistenteException;
import ort.t6.chat.exception.UsuarioInexistenteException;
import ort.t6.chat.model.Contacto;
import ort.t6.chat.model.mensaje.Error;
import ort.t6.chat.model.mensaje.Lista;
import ort.t6.chat.model.mensaje.Login;
import ort.t6.chat.model.mensaje.Logout;
import ort.t6.chat.model.mensaje.Mensaje;

public class ServidorServiceTest {

	private final static Logger log = Logger.getLogger(ServidorServiceTest.class);
	
	private ObjectOutputStream salida;
	private ObjectInputStream entrada;
	private Socket conexion;
	
	@Before
	public void before() throws UnknownHostException, IOException {
		log.info("** inicio **");
		String host = "localhost";
		int port = 4000;
		conexion = new Socket(host, port);
		salida = new ObjectOutputStream(conexion.getOutputStream());
		entrada = new ObjectInputStream(conexion.getInputStream());
	}

	@After
	public void after() throws IOException{
		log.info("** salida **");
		salida.close();
		entrada.close();
		conexion.close();//se cierra la conexion
	}
	
	//**********************************
	
	@Test
	public void firstLogin() throws IOException, ClassNotFoundException {
		Login mensaje = new Login();
		Contacto contacto = new Contacto(false, "Pepe","10.0.0.1");
		mensaje.setContacto(contacto);
		salida.writeObject(mensaje);
		Assert.assertNotNull(((Lista)entrada.readObject()));
	}

	@Test
	public void secondLogin() throws IOException, ClassNotFoundException {
		Login mensaje = new Login();
		Contacto contacto = new Contacto(false, "Rosa","10.0.0.2");
		mensaje.setContacto(contacto);
		salida.writeObject(mensaje);
		Assert.assertTrue("Lista de usuarios vacia",((Lista)entrada.readObject()).getUsuarios().size() > 0);
	}
	
	@Test
	public void errorDuplicatedLogin() throws IOException, ClassNotFoundException {
		Login mensaje = new Login();
		Contacto contacto = new Contacto(false, "Pepe","10.0.0.1");
		mensaje.setContacto(contacto);
		salida.writeObject(mensaje);
		Assert.assertTrue(((Error)entrada.readObject()).getExcepcion() instanceof UsuarioExistenteException);
	}

	@Test
	public void sendMessage() throws IOException, ClassNotFoundException {
		Mensaje mensaje = new Mensaje();
		Contacto contacto = new Contacto(false, "Pepe","10.0.0.1");
		mensaje.setContacto(contacto);
		
		Contacto destinatario = new Contacto(false, "Rosa","10.0.0.2");
		List<Contacto> destinatarios = new ArrayList<Contacto>();
		destinatarios.add(destinatario);
		mensaje.setDestinos(destinatarios);
		
		mensaje.setTexto("Es una prueba");
		salida.writeObject(mensaje);
	}

	@Test
	public void sendAllMessage() throws IOException, ClassNotFoundException {
		Mensaje mensaje = new Mensaje();
		Contacto contacto = new Contacto(false, "Pepe","10.0.0.1");
		mensaje.setContacto(contacto);
		
		mensaje.setTexto("Es una prueba");
		salida.writeObject(mensaje);
	}
	
	@Test
	public void firstlogout() throws IOException {
		Logout mensaje = new Logout();
		Contacto contacto = new Contacto(false, "Pepa","10.0.0.1");
		mensaje.setContacto(contacto);
		salida.writeObject(mensaje);
	}

	@Test
	public void secondlogout() throws IOException {
		Logout mensaje = new Logout();
		Contacto contacto = new Contacto(false, "Rosa","10.0.0.1");
		mensaje.setContacto(contacto);
		salida.writeObject(mensaje);
	}
	
	@Test
	public void errorNonExistentUserLogout() throws IOException, ClassNotFoundException {
		Logout mensaje = new Logout();
		Contacto contacto = new Contacto(false, "Mario","10.0.0.1");
		mensaje.setContacto(contacto);
		salida.writeObject(mensaje);
		Assert.assertTrue(((Error)entrada.readObject()).getExcepcion() instanceof UsuarioInexistenteException);
	}
	
}