package ar.com.pattern.creacional.factory.abstrac.jpanel;

import java.awt.Color;

import javax.swing.JLabel;

//concrete panel 1
class JUniqueSymbolPanel extends JCUIPanel {
    public void initComponents(){ //initialize unique symbol components };
    	JLabel label = new JLabel("Rojo");
    	this.add(label);
    	this.setBackground(Color.RED);
    }
}