package ar.com.pattern.creacional.factory.method.reloj;

public class TestClient {

	public static void main(String[] args) {
		//Reloj es una interfaz que se le asigna un reloj concreto
		Reloj r = RelojFactory.createReloj(RelojFactory.RELOJ_24_HRS);
		System.out.println(r.dameLaHora());
	}
}