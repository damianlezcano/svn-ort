package ar.com.pattern.creacional.factory.abstrac;

public class TraductorIngles extends Traductor {
 
    public TraductorIngles(){
       super();
    }
 
    public String traducirNumero(int numero){
       switch(numero){
       	   case 1: return "one";
       	   case 2: return "two";
       }
	return null;
    }	
 
}