package ar.com.pattern.creacional.factory.abstrac.jpanel;

import java.awt.Color;

import javax.swing.JLabel;

//concrete panel 3
class JNullPanel extends JCUIPanel{
    public void initComponents(){ //initialize null components };
    	JLabel label = new JLabel("Azul");
    	this.add(label);
    	this.setBackground(Color.BLUE);
    }
}