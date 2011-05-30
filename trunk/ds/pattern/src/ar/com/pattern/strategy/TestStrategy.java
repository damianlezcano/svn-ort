package ar.com.pattern.strategy;


class TestStrategy {
	 
    public static void main(String[] args) {
 
        Context context;
 
        // Three contexts following different strategies
        context = new Context(new ConcreteStrategyAdd());
        int resultA = context.executeStrategy(3,4);
        System.out.println("El resultado de la operacion es: " + resultA);
 
        context = new Context(new ConcreteStrategySubtract());
        int resultB = context.executeStrategy(3,4);
        System.out.println("El resultado de la operacion es: " + resultB);
 
        context = new Context(new ConcreteStrategyMultiply());
        int resultC = context.executeStrategy(3,4);
        System.out.println("El resultado de la operacion es: " + resultC);
        
        context = new Context(new ConcreteStrategyDividir());
        int resultD = context.executeStrategy(3,4);
        System.out.println("El resultado de la operacion es: " + resultD);

//        List<Strategy> estrategias = new ArrayList<Strategy>();
//        estrategias.add(new ConcreteStrategyAdd());
//        estrategias.add(new ConcreteStrategySubtract());
//        estrategias.add(new ConcreteStrategyMultiply());
//        estrategias.add(new ConcreteStrategyDividir());
//        
//        for (Strategy estrategia : estrategias) {
//			int resultado = estrategia.execute(3,4);
//			System.out.println("El resultado de la operacion es: " + resultado);
//		}
        
    }
}
