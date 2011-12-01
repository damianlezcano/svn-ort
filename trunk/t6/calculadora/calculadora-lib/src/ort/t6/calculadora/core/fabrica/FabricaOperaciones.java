package ort.t6.calculadora.core.fabrica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import ort.t6.calculadora.core.modelo.Operacion;

//Definimos la clase abstracta constructora
public class FabricaOperaciones {

	private Properties props;
	private static FabricaOperaciones singleton;
	private static String PATH_PROPERTIES_FABRICA_CLASES = "FabricaOperaciones.properties";
	
	private FabricaOperaciones() {
		props = new Properties();
		try {
			props.load(getClass().getResourceAsStream(PATH_PROPERTIES_FABRICA_CLASES));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static FabricaOperaciones getInstance() {
		if (singleton == null) {
			singleton = new FabricaOperaciones();
		}
		return singleton;
	}

	@SuppressWarnings("rawtypes")
	public Operacion crearOperacion(String operador) {
		String nombre = props.getProperty(operador);
		try {
			Class clase = Class.forName(nombre);
			return (Operacion) clase.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Operacion> traerOperaciones(){
		List<Operacion> operaciones = new ArrayList<Operacion>();
		
		for (Entry<Object, Object> entry : props.entrySet()) {
			Operacion operacion = crearOperacion(entry.getKey().toString());
			operaciones.add(operacion);
		}
		return operaciones;
	}
}