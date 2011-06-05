package ar.com.pattern.creacional.factory.abstrac.jpanel;

import javax.swing.JFrame;

//example using the abstract factory
public class TestFactory{
    public static void main(String [] args){
    	//args has the type of the geometry that we want to create
        CUIFactory factory = CUIFactory.getFactory(CUIFactory.PANEL_VERDE);
        JCUIPanel panel = factory.createPanel();
//        panel.initComponents();
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(panel);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}