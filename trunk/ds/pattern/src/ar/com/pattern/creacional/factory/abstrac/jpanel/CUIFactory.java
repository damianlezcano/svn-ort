package ar.com.pattern.creacional.factory.abstrac.jpanel;

//abstract factory
abstract class CUIFactory{
    public static CUIFactory getFactory(int clasif){
        switch (clasif){
            case 0:
                return new UniqueSymbolFactory();
            case 1:
                return new UniqueValueFactory();
            default:
                return new NullFactory();
        }
    }
    public abstract JCUIPanel createPanel();
}