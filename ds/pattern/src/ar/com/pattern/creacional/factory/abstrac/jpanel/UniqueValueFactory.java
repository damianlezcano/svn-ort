package ar.com.pattern.creacional.factory.abstrac.jpanel;

//concrete factory 2
class UniqueValueFactory extends CUIFactory{
    public JCUIPanel createPanel(){
        return new JUniqueValuePanel();
    }
}