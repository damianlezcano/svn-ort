package ar.com.pattern.creacional.factory.abstrac.boton;

class OSXFactory implements GUIFactory {
    public Button createButton() {
        return new OSXButton();
    }
}