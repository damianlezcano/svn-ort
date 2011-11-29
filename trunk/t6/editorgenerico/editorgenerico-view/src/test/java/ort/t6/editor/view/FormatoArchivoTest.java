package ort.t6.editor.view;

import junit.framework.Assert;

import org.junit.Test;

public class FormatoArchivoTest {

	@Test
	public void reconocerFormato(){
		String name = "file.txt";
		String[] archivo = name.split("\\.");
		
		Assert.assertTrue("No se pude reconocer el formato de archivo",archivo.length > 1);
		Assert.assertEquals("txt", archivo[1]);
	}
	
}
