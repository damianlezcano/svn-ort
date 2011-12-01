package ort.t6.calculadora.core.modelo;

public class Cuadrado extends Operacion {

	@Override
	protected double calcular(double valor1, double valor2) {
		return (valor1 * valor1);
	}
	
	@Override
	public String getOperacion() {
		return Operacion.CUADRADO;
	}

}