package ar.com.pattern.estructural.proxy;

/*
 * Proporcionar un sustituto o marcador de posici�n de otro objeto para controlar el acceso a �ste.
 */
class TestProxy {
	public static void main(String[] args) {
		ImagenInterface imagen = new ImagenProxy();
		imagen.getFile();
		imagen.getPath();
	}
}