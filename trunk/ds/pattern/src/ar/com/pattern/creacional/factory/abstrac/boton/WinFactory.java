package ar.com.pattern.creacional.factory.abstrac.boton;

class WinFactory implements GUIFactory {
    public Button createButton() {
        return new WinButton();
    }
}