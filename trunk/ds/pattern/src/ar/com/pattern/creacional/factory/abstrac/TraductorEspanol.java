package ar.com.pattern.creacional.factory.abstrac;

class TraductorEspanol extends Traductor {
 
    public TraductorEspanol(){
       super();
    }
 
    public String traducirNumero(int numero){
       switch(numero){
       	   case 1: return "uno";
       	   case 2: return "dos";
       }
       return null;
    }	
 
}