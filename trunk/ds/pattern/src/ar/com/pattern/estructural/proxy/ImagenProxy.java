package ar.com.pattern.estructural.proxy;

//the Proxy
public class ImagenProxy implements ImagenInterface {
	Imagen imagen;

	public ImagenProxy() {
		System.out.println("Creo el proxy");
	}

	public void getFile() {
		if(imagen == null)
			imagen = new Imagen();
		
		imagen.getFile();
	}

	public void getPath() {
		if(imagen == null)
			imagen = new Imagen();
		
		imagen.getPath();
	}
}