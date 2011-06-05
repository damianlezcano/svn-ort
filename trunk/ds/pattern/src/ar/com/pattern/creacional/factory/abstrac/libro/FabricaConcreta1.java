package ar.com.pattern.creacional.factory.abstrac.libro;

/// <summary>
/// A 'ConcreteCreator' class
/// </summary>
class FabricaConcreta1 extends FabricaAbstracta {
	
	public Product crearProductoA() {
		return new ProductoA1();
	}

	public Product crearProductoB() {
		return new ProductoB1();
	}
}