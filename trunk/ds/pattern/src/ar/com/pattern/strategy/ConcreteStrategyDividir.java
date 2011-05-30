package ar.com.pattern.strategy;

class ConcreteStrategyDividir implements Strategy {
	 
    public int execute(int a, int b) {
        System.out.println("Called ConcreteStrategySubtract's execute()");
        return resolver(a,b);  // Do a subtraction with a and b
    }
    
    private int resolver(int a, int b){
    	return (a / b);
    }
}
