package ar.com.pattern.creacional.factory.abstrac.Xwindows;

/// <summary>
/// A 'ConcreteCreator' class
/// </summary>
class FabricaLinux extends FabricaAbstracta {
	public Ventana crearVentana() {
		return new VentanaLinux();
	}

	public Boton crearBoton() {
		return new BotonLinux();
	}
}