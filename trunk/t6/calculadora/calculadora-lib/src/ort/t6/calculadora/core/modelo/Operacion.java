package ort.t6.calculadora.core.modelo;

public abstract class Operacion {

	public static String SUMA = "+";
	public static String RESTA = "-";
	public static String MULTIPLICACION = "*";
	public static String DIVISION = "/";
	public static String CUADRADO = "^2";
	
	protected abstract double calcular(double valor1, double valor2);
	
	public abstract String getOperacion();
}
