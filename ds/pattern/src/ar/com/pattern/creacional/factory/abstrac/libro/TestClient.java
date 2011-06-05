package ar.com.pattern.creacional.factory.abstrac.libro;

class TestClient {
	public static void main(String[] args) {
		FabricaAbstracta factory = FabricaAbstracta.getFactory(FabricaAbstracta.PRODUCTO_B);
		Product p = factory.crearProductoA();
		p.paint();
		p = factory.crearProductoB();
		p.paint();
	}
}

