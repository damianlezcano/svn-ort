package ar.com.pattern.creacional.factory.abstrac.boton;

class OSXButton implements Button {
    public void paint() {
        System.out.println("I'm an OSXButton");
    }
}