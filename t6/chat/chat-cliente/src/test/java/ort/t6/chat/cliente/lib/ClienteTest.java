package ort.t6.chat.cliente.lib;

import java.io.IOException;
import java.net.UnknownHostException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

	private Cliente cliente;
	
	@Before
	public void beforeClass(){
		cliente = new Cliente();
	}
	
	//************************************************
	
	@Test
	public void login(){
		try {
			cliente.login();
			Assert.assertTrue(cliente.contactosConectados().size() > 0);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
