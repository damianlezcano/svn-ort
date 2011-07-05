package ar.com.pattern.estructural.proxy;

/*
 * Proporcionar un sustituto o marcador de posición de otro objeto para controlar el acceso a éste.
 */
class TestProxy {
	public static void main(String[] args) {
		ImagenInterface imagen = new ImagenProxy();
		imagen.getFile();
		imagen.getPath();
	}
}