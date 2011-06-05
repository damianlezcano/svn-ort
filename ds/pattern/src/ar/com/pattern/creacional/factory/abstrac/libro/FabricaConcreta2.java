package ar.com.pattern.creacional.factory.abstrac.libro;

/// <summary>
/// A 'ConcreteCreator' class
/// </summary>
class FabricaConcreta2 extends FabricaAbstracta {
	public Product crearProductoA() {
		return new ProductoA2();
	}

	public Product crearProductoB() {
		return new ProductoB2();
	}
}