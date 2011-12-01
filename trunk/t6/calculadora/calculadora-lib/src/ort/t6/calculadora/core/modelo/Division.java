package ort.t6.calculadora.core.modelo;

public class Division extends Operacion {

	@Override
	protected double calcular(double valor1, double valor2) {
		return (valor1 / valor2);
	}
	
	@Override
	public String getOperacion() {
		return Operacion.DIVISION;
	}

}