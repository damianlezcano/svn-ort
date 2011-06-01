package ar.com.pattern.command;

/* The Receiver class */
public class Receiver {
	
	private Integer result = 0;
	
	public Receiver() {
	}

	public void sumar() {
		result++;
		System.out.println("El resultado es: " + result);
	}

	public void restar() {
		result--;
		System.out.println("El resultado es: " + result);
	}
}
