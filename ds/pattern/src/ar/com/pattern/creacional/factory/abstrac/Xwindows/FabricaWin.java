package ar.com.pattern.creacional.factory.abstrac.Xwindows;

/// <summary>
/// A 'ConcreteCreator' class
/// </summary>
class FabricaWin extends FabricaAbstracta {
	
	public Ventana crearVentana() {
		return new VentanaWin();
	}

	public Boton crearBoton() {
		return new BotonWin();
	}
}