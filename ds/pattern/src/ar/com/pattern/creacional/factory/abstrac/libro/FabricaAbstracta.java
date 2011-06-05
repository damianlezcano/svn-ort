package ar.com.pattern.creacional.factory.abstrac.libro;


/// <summary>
/// The 'Creator' abstract class
/// </summary>
abstract class FabricaAbstracta {
	
	static int PRODUCTO_A = 0;
	static int PRODUCTO_B = 1;
	
	public static FabricaAbstracta getFactory(int clasif) {

		if (clasif == FabricaAbstracta.PRODUCTO_A) {
			return new FabricaConcreta1();
		}else if(clasif == FabricaAbstracta.PRODUCTO_B){
			return new FabricaConcreta2();
		}
		return null;
	}
	
	public abstract Product crearProductoA();
	public abstract Product crearProductoB();
}
