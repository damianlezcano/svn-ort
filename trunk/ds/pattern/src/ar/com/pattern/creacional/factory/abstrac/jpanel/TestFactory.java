package ar.com.pattern.creacional.factory.abstrac.jpanel;

import javax.swing.JFrame;

//example using the abstract factory
public class TestFactory{
    public static void main(String [] args){
    	//args has the type of the geometry that we want to create
        CUIFactory factory = CUIFactory.getFactory(1);
        JCUIPanel panel = factory.createPanel();
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setVisible(true);
    }
}