package ar.com.pattern.comportamiento.strategy;

//The context class uses this to call the concrete strategy
interface Strategy {
    int execute(int a, int b); 
}
