package ar.com.pattern.creacional.factory.abstrac.Xwindows;

class TestClient {
	public static void main(String[] args) {
		FabricaAbstracta factory = FabricaAbstracta.getFactory(FabricaAbstracta.WINDOWS);
		
		Ventana ventana = factory.crearVentana();
		ventana.paint();
		
		Boton boton = factory.crearBoton();
		boton.paint();
	}
}

