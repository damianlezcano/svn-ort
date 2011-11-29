package ort.t6.chat.servidor;

import java.io.IOException;

import org.junit.Test;

public class ConexionServidorServiceTest {

	@Test
	public void init() throws IOException{
		ServidorService servidor = new ServidorService();
		servidor.execute(4000);
	}
}