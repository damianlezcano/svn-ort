package ar.com.pattern.estructural.proxy;

//the Real Subject
public class Imagen implements ImagenInterface {
	public void getFile() {
		System.out.println("Archivo binario de la imagen");
	}

	public void getPath() {
		System.out.println("path de la imagen");
	}
}
