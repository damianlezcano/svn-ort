package ar.com.pattern.comportamiento.strategy;

class ConcreteStrategyRestar implements Strategy {
	 
    public int calcular(int a, int b) {
        return a - b;  // Do a subtraction with a and b
    }
}
