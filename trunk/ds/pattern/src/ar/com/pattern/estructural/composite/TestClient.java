package ar.com.pattern.estructural.composite;

public class TestClient {
	public static void main(String[] args) {

		Componente raiz = new Compuesto("root");
		raiz.Anadir(new Hoja("hoja A1"));
		Componente comp = new Compuesto("hoja A2");
		raiz.Anadir(comp);
		
		comp.Anadir(new Hoja("hoja A-B1"));
		comp.Anadir(new Hoja("hoja A-B2"));
		
		raiz.Anadir(new Hoja("hoja C1"));
		
//		raiz.Anadir(l);
//		raiz.Eliminar(l);
//		raiz.ObtenerHijo(1);
	}
}
