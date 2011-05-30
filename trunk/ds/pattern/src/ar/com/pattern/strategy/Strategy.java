package ar.com.pattern.strategy;

//The context class uses this to call the concrete strategy
interface Strategy {
    int execute(int a, int b); 
}
