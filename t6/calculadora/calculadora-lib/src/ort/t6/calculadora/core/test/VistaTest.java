package ort.t6.calculadora.core.test;

import java.util.Observable;
import java.util.Observer;

import ort.t6.calculadora.core.modelo.Calculadora;

public class VistaTest implements Observer{

	private String nombre;
	
	public VistaTest(String nombre){
		this.nombre = nombre;
	}
	
	public void update(Observable who, Object what){
		Calculadora c = (Calculadora) who;
		System.out.println(nombre + " : total acual es " + c.getTotal());
	}

}