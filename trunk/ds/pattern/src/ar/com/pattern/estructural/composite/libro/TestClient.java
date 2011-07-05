package ar.com.pattern.estructural.composite.libro;

/*
 * PROPOSITO: Combina objetos en estructuras de arbol ara representar jerarquias de parte-todo.
 * Permite que los clientes traten de manera uniforme a los objetos individuales y a los compuestos.
 */
class TestClient {
	public static void main(String[] args) {

		Componente nivel1 = new Compuesto("root nivel1");
		nivel1.Anadir(new Hoja("hoja1 en nivel1"));

		Componente nivel2 = new Compuesto("root nivel2");
		nivel1.Anadir(nivel2);
		
		nivel2.Anadir(new Hoja("hoja1 nivel2"));
		nivel2.Anadir(new Hoja("hoja2 nivel2"));
		
		nivel1.Anadir(new Hoja("hoja2 nivel1"));
		
	}
}