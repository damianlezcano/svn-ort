package ar.com.pattern.comportamiento.strategy;

class ConcreteStrategyMultiplicar implements Strategy {
	 
    public int calcular(int a, int b) {
        return a * b;   // Do a multiplication with a and b
    }    
}
