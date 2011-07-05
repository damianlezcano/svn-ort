package ar.com.pattern.estructural.composite.mcdonal;

class Producto extends Item{

	public Producto(String nombre) {
		super(nombre);
	}

	@Override
	public void anadir(Item c) {
		System.out.println(nombre  + " - No añado por que es una hoja.");
	}

	@Override
	public void eliminar(Item c) {
		System.out.println(nombre  + " - No elimino por que es una hoja.");
	}

	@Override
	public void obtenerHijo(int hijo) {
		System.out.println(nombre  + " - No obtengo hijos por que es una hoja.");
	}

	@Override
	public void operacion() {
		System.out.println(nombre  + " - Operacion del hijo");
	}

	@Override
	public int calcularPrecio() {
		return 1;
	}
}