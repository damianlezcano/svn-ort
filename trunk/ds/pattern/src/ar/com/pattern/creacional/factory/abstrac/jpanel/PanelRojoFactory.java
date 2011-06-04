package ar.com.pattern.creacional.factory.abstrac.jpanel;

//concrete factory 1
class PanelRojoFactory extends CUIFactory{
    public JCUIPanel createPanel(){
        return new JUniqueSymbolPanel();
    }
}