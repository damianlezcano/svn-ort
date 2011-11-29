package ort.t6.editor.core.factory;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import ort.t6.editor.core.operations.ArchivoEditable;

public class FabricaArchivos {

	private Properties props;
	private static FabricaArchivos singleton;
	private final String FABRICA_PROPERTIES = "/FabricaArchivos.properties";
	private final static Logger log = Logger.getLogger(FabricaArchivos.class);
	
	private FabricaArchivos() {
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
		props = new Properties();
		try {
			props.load(getClass().getResourceAsStream(FABRICA_PROPERTIES));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static FabricaArchivos getInstance() {
		if (singleton == null) {
			singleton = new FabricaArchivos();
		}
		return singleton;
	}

	@SuppressWarnings("rawtypes")
	public ArchivoEditable crearVista(String formato) {
		String nombre = props.getProperty(formato);
		Class clase = null;
		try {
			clase = Class.forName(nombre);
			return (ArchivoEditable) clase.newInstance();
		} catch (ClassNotFoundException e) {
			log.error("No existe la clase definida en el archivo de properties");
			return null;
		} catch (InstantiationException e) {
			log.error("InstantitionException");
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			log.error("IllegalAccessException");
			e.printStackTrace();
			return null;
		} catch (NullPointerException e){
			log.error("No existe la clase definida para el formato de archivo");
			return null;
		}
	}
}