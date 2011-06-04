package ar.com.pattern.creacional.factory.abstrac;

class TestClient {

    public static void main(String[] args) {
 
        Reloj reloj = null;
        Traductor traductor = null;
 
        AbstractLocaleFactory localeFactory = new LocaleGuatemalaFactory();
        reloj = localeFactory.createReloj();
        traductor = localeFactory.createTraductor();
 
        System.out.println("--------");
        System.out.println("1="+traductor.traducirNumero(1));
        System.out.println(reloj.dameLaHora());
 
    }
}