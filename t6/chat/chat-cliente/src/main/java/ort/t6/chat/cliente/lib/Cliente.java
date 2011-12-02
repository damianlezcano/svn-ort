package ort.t6.chat.cliente.lib;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import ort.t6.chat.model.Contacto;
import ort.t6.chat.model.mensaje.Lista;
import ort.t6.chat.model.mensaje.Login;

public class Cliente extends Observable {

	
	private final static Logger log = Logger.getLogger(Cliente.class);
	
	private static final String CONNECTION_FILE = "/connection.properties";
	private static final String USERS_FILE = "/users.properties";
	
	private ObjectOutputStream salida;
	private ObjectInputStream entrada;
	private Socket conexion;
	
	private List<Contacto> contactos;
	
	private Properties connectionConfiguration;
	private Properties usersConfiguration;
	
	public Cliente() {
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
		connectionConfiguration = new Properties();
		usersConfiguration = new Properties();
		contactos = new ArrayList<Contacto>();
		try {
			connectionConfiguration.load(getClass().getResourceAsStream(CONNECTION_FILE));
			usersConfiguration.load(getClass().getResourceAsStream(USERS_FILE));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void login() throws IOException, ClassNotFoundException{
		String host = connectionConfiguration.getProperty("serverip");
		String port = connectionConfiguration.getProperty("serverport");
		conexion = new Socket(host, Integer.valueOf(port));
		salida = new ObjectOutputStream(conexion.getOutputStream());
		entrada = new ObjectInputStream(conexion.getInputStream());
		
		String userlogin = usersConfiguration.getProperty("userlogin");
		Login mensaje = new Login();
		Contacto contacto = new Contacto(false, userlogin,"0.0.0.0");
		mensaje.setContacto(contacto);
		salida.writeObject(mensaje);
		
		//Cargamos la lista de usuarios
		List<Contacto> userslist = new ArrayList<Contacto>(); 
		for (Entry<Object, Object> entry : usersConfiguration.entrySet()) {
			userslist.add(new Contacto(false,(String)entry.getKey(),(String)entry.getValue()));
		}
		contactos.addAll(userslist);
		
		List<Contacto> conectados =  ((Lista)entrada.readObject()).getUsuarios();
		for (Contacto conectado : conectados) {
			if(userslist.contains(conectado)){
				contactos.get(contactos.indexOf(conectado)).setEstado(true);
			}else{
				contactos.add(conectado);
			}
		}
		
		notificar();
	}
	
	private void notificar(){
		this.setChanged();
		this.notifyObservers();
	}
	
	//**********************************************************

	public List<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}
}
