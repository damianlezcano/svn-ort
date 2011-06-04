package ar.com.pattern.creacional.factory.abstrac;

//Y la respectiva para Estados Unidos:
class LocaleEstadosUnidosFactory extends AbstractLocaleFactory{
 
    public LocaleEstadosUnidosFactory(){
        this.pais=AbstractLocaleFactory.US;
    }
 
    public Traductor createTraductor() {
        return TraductorFactory.createTraductor("ingles");
    }
 
    public Reloj createReloj() {
        return RelojFactory.createReloj(RelojFactory.RELOJ_AM_PM);
    }
 
}