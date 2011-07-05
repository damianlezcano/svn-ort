package ar.com.pattern.comportamiento.strategy;

//Implements the algorithm using the strategy interface
class ConcreteStrategySumar implements Strategy {
 
    public int calcular(int a, int b) {
        return a + b;  // Do an addition with a and b
    }
}
