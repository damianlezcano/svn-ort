package ar.com.pattern.creacional.factory.abstrac;

//Ahora vamos a crear una Abstract Factory, que le pondremos Locale.
abstract class AbstractLocaleFactory {
    public static final String US="ESTADOS_UNIDOS";
    public static final String GT="GUATEMALA";
 
    String pais;
 
    public abstract Traductor createTraductor();
    public abstract Reloj createReloj();
 
    public String getPais(){
        return this.pais;
    }
 
    public void setPais(String pais){
        this.pais = pais;
    }
 
}