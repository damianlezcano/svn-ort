package ort.t6.calculadora.core.test;

import ort.t6.calculadora.core.modelo.Calculadora;
import ort.t6.calculadora.core.modelo.Operacion;

public class CalculadoraTest {

	public static void main(String[] args) {
		Calculadora calc = new Calculadora();
		
		calc.addObserver(new VistaTest("vista uno"));
		calc.addObserver(new VistaTest("vista dos"));
		
		calc.agregarNumero(20d);
		
		calc.agregarOperador(Operacion.SUMA);
		calc.agregarNumero(10d);
		
		calc.agregarOperador(Operacion.RESTA);
		calc.agregarNumero(5d);
		
		//System.out.println("El resultado es :" + calc.getTotal());
		
	}
	
}