package ar.com.pattern.creacional.factory.abstrac.Xwindows;


/// <summary>
/// The 'Creator' abstract class
/// </summary>
abstract class FabricaAbstracta {
	
	static int WINDOWS = 0;
	static int LINUX = 1;
	
	public static FabricaAbstracta getFactory(int clasif) {

		if (clasif == FabricaAbstracta.WINDOWS) {
			return new FabricaWin();
		}else if(clasif == FabricaAbstracta.LINUX){
			return new FabricaLinux();
		}
		return null;
	}
	
	public abstract Ventana crearVentana();
	public abstract Boton crearBoton();
}
