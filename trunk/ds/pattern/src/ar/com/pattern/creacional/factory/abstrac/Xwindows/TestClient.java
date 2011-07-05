package ar.com.pattern.creacional.factory.abstrac.Xwindows;

class TestClient {
	public static void main(String[] args) {
		FabricaAbstracta factory = FabricaAbstracta.getFactory(FabricaAbstracta.LINUX);
		
		Ventana ventana = factory.crearVentana();
		ventana.dibujar();
		
		Boton boton = factory.crearBoton();
		boton.dibujar();
	}
}

