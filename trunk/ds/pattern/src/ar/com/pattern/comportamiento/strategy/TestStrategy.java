package ar.com.pattern.comportamiento.strategy;

/*
 * PROPOSITO: Define una familia de algoritmos, encapsula cada uno de ellos y los hace intercambiables.
 * Permite que un algoritmo varie independientemente de los clientes que lo usan.
 */
class TestStrategy {
	 
    public static void main(String[] args) {
 
        Context context = new Context();
 
        context.establecerEstrategiaSumar();
        context.ejecutar(3,4);
        
        context.establecerEstrategiaRestar();
        context.ejecutar(3,4);
        
        context.establecerEstrategiaMultiplicar();
        context.ejecutar(3,4);
        
        context.establecerEstrategiaDividir();
        context.ejecutar(3,4);

    }
}
