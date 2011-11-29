package ort.t6.editor.core.factory;

import junit.framework.Assert;

import org.junit.Test;

import ort.t6.editor.core.operations.ArchivoEditable;
import ort.t6.editor.core.operations.ArchivoImagen;
import ort.t6.editor.core.operations.ArchivoTexto;


public class FabricaArchivosTest {

	@Test
	public void texto() {
		FabricaArchivos fabrica = FabricaArchivos.getInstance();
		ArchivoEditable archivo = fabrica.crearVista("txt");
		Assert.assertTrue("Tipo invalido",archivo instanceof ArchivoTexto);
	}
	
	@Test
	public void imagen() {
		FabricaArchivos fabrica = FabricaArchivos.getInstance();
		ArchivoEditable archivo = fabrica.crearVista("jpg");
		Assert.assertTrue("Tipo invalido",archivo instanceof ArchivoImagen);
	}
}