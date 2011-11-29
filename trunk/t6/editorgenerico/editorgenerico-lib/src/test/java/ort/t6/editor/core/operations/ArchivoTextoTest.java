package ort.t6.editor.core.operations;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class ArchivoTextoTest {

	private ArchivoEditable archivo;
	
	@Before
	public void init(){
		archivo = new ArchivoTexto();
	}
	
	@Test
	public void open(){
		try {
			archivo.open("./src/test/resources/file.txt");
			archivo.save();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void save(){
		
	}
	
	@Test
	public void close(){
		
	}
}