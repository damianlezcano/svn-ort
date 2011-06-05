package ar.com.pattern.creacional.factory.abstrac.boton;

class TestClient {

	public static void main(String[] args) {
		GUIFactory factory = createOsSpecificFactory();
		Button boton = factory.createButton();
		boton.paint();
	}

	public static GUIFactory createOsSpecificFactory() {
		int sys = 1;
		if (sys == 0) {
			return new WinFactory();
		} else {
			return new OSXFactory();
		}
	}
}