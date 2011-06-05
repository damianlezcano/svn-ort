package ar.com.pattern.estructural.proxy;

//testing the Proxy
class TestProxy {
	public static void main(String[] args) {
		ImagenInterface imagen = new ImagenProxy();
		imagen.getFile();
		imagen.getPath();
	}
}