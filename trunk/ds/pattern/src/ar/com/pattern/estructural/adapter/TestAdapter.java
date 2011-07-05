package ar.com.pattern.estructural.adapter;

public class TestAdapter {
	public static void main(String args[]) {
		Regla regla = new Regla();
		regla.medir();

		regla = new AdapterBalanza();
		regla.medir();
	}
}
