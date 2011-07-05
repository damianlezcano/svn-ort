package ar.com.pattern.estructural.composite.mcdonal;

/*
 * PROPOSITO: Combina objetos en estructuras de arbol ara representar jerarquias de parte-todo.
 * Permite que los clientes traten de manera uniforme a los objetos individuales y a los compuestos.
 */
class TestClient {
	public static void main(String[] args) {

		//Creo el combo1 y agrego Productos
		Item combo1 = new Combo("Combo1");
		combo1.anadir(new Producto("Hamburguesa con queso"));
		combo1.anadir(new Producto("Hamburguesa straker"));
		
		//Creo el combo2 y lo agrego al combo1
		Item combo2 = new Combo("Combo2");
		combo2.anadir(new Producto("Coca Cola Mediana"));
		combo2.anadir(new Producto("Papas Fritas Medianas"));
		
		//Creo un producto e inteto ejecutar las mismas operaciones que un combo
		Item producto = new Producto("Ensalada de repollo");
		producto.anadir(combo2);
		
		// agrego el combo2 al combo1
		combo1.anadir(combo2);
		
		//calculamos el valor de la factura
		System.out.println("El valor del Combo1 es:" + combo1.calcularPrecio());
	}
}