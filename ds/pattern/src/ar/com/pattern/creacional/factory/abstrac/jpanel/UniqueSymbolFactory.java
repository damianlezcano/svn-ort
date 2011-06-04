package ar.com.pattern.creacional.factory.abstrac.jpanel;

//concrete factory 1
class UniqueSymbolFactory extends CUIFactory{
    public JCUIPanel createPanel(){
        return new JUniqueSymbolPanel();
    }
}