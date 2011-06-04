package ar.com.pattern.creacional.factory.abstrac.jpanel;

//concrete factory 3
class PanelAzulFactory extends CUIFactory{
    public JCUIPanel createPanel(){
        return new JNullPanel();
    }
}