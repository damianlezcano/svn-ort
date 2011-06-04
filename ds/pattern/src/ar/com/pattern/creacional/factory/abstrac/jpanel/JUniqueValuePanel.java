package ar.com.pattern.creacional.factory.abstrac.jpanel;

import java.awt.Color;

import javax.swing.JLabel;

//concrete panel 2
class JUniqueValuePanel extends JCUIPanel{
    public void initComponents(){ //initialize unique value components };
    	JLabel label = new JLabel("Verde");
    	this.add(label);
    	this.setBackground(Color.GREEN);
    }
}