package ar.com.pattern.creacional.factory.abstrac.jpanel;

//concrete factory 3
class NullFactory extends CUIFactory{
    public JCUIPanel createPanel(){
        return new JNullPanel();
    }
}