package ar.com.pattern.composite;

public class Hoja extends Componente{

	public Hoja(String nombre) {
		super(nombre);
		System.out.println("Se crea hoja " + nombre.toUpperCase());		
	}

	@Override
	public void Anadir(Componente c) {
		System.out.println(nombre  + " - No añado por que es una hoja.");
	}

	@Override
	public void Eliminar(Componente c) {
		System.out.println(nombre  + " - No elimino por que es una hoja.");
	}

	@Override
	public void ObtenerHijo(int hijo) {
		System.out.println(nombre  + " - No obtengo hijos por que es una hoja.");
	}

	@Override
	public void Operacion() {
		System.out.println(nombre  + " - Operacion del hijo");
	}
}