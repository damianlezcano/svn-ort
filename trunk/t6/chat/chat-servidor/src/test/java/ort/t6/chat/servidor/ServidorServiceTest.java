package ort.t6.chat.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ort.t6.chat.model.Contacto;
import ort.t6.chat.model.Lista;
import ort.t6.chat.model.Login;
import ort.t6.chat.model.Logout;
import ort.t6.chat.model.Error;

public class ServidorServiceTest {

	private ObjectOutputStream salida;
	private ObjectInputStream entrada;
	private static Socket skt;
	
	@Before
	public void before() throws UnknownHostException, IOException{
		String host = "localhost";
		int port = 4000;
		skt = new Socket(host, port);
		salida = new ObjectOutputStream(skt.getOutputStream());
		entrada = new ObjectInputStream(skt.getInputStream());
	}

	@After
	public void after() throws IOException{
		salida.close();
		entrada.close();
		skt.close();//se cierra la conexion
	}
	
	@Test
	public void login() throws IOException {
		Login mensaje = new Login();
		Contacto contacto = new Contacto(false, "Pablo","10.0.0.1");
		mensaje.setContacto(contacto);
		salida.writeObject(mensaje);
	}

	@Test
	public void logout() throws IOException {
		Logout mensaje = new Logout();
		Contacto contacto = new Contacto(false, "Pablo","10.0.0.1");
		mensaje.setContacto(contacto);
		salida.writeObject(mensaje);
	}

	@Test
	public void lista() throws IOException {
		Lista mensaje = new Lista();
		salida.writeObject(mensaje);
	}

	@Test
	public void error() throws IOException {
		Error mensaje = new Error();
		salida.writeObject(mensaje);
	}
	
}