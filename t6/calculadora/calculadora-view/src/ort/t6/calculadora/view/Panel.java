package ort.t6.calculadora.view;

import javax.swing.JPanel;

import ort.t6.calculadora.core.modelo.Calculadora;

public abstract class Panel extends JPanel {

	protected Calculadora calculadora;
	
	protected Panel(){
		super();
	}
}