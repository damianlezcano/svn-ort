package ort.t6.chat.cliente.lib;

import java.net.UnknownHostException;

import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

	private Cliente cliente;
	
	@Before
	public void beforeClass(){
		try {
			cliente = new Cliente();
			cliente.login("desktop5","localhost",4000);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//************************************************
	
	@Test
	public void send(){
//		try {
//			Contacto destino = new Contacto(false,"desktop2","154.21.56.5");
//			List<Contacto> destinatarios = new ArrayList<Contacto>();
//			destinatarios.add(destino);
//			String texto = "probandooo";
//			cliente.send(destinatarios, texto);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}
}