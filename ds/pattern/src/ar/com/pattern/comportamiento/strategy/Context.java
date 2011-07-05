package ar.com.pattern.comportamiento.strategy;

//Configured with a ConcreteStrategy object and maintains a reference to a Strategy object
class Context {

	private Strategy strategy;

	public void establecerEstrategiaSumar() {
		strategy = new ConcreteStrategySumar();
	}

	public void establecerEstrategiaRestar() {
		strategy = new ConcreteStrategyRestar();
	}

	public void establecerEstrategiaMultiplicar() {
		strategy = new ConcreteStrategyMultiplicar();
	}

	public void establecerEstrategiaDividir() {
		strategy = new ConcreteStrategyDividir();
	}

	public void ejecutar(int a, int b) {
		System.out.println("El resultado es: " + strategy.calcular(a, b));
	}
}
