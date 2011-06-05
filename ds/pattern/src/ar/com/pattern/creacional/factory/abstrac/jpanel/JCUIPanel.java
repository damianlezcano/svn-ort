package ar.com.pattern.creacional.factory.abstrac.jpanel;

import javax.swing.JPanel;

//abstract panel
abstract class JCUIPanel extends JPanel{
	
	JCUIPanel(){
		this.initComponents();
	}
	
    public abstract void initComponents();
}