package ar.com.pattern.comportamiento.strategy;

class ConcreteStrategyDividir implements Strategy {
	 
    public int calcular(int a, int b) {
        return resolver(a,b);  // Do a subtraction with a and b
    }
    
    private int resolver(int a, int b){
    	return (a / b);
    }
}
