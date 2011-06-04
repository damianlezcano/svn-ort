package ar.com.pattern.creacional.factory.method.reloj;

public class TestClient {

	public static void main(String[] args) {
		Reloj r = RelojFactory.createReloj(RelojFactory.RELOJ_AM_PM);
		System.out.println(r.dameLaHora());
	}
}