package ort.t6.calculadora.view;

import java.awt.GridLayout;

import javax.swing.JTextField;

import ort.t6.calculadora.core.modelo.Calculadora;

public class PanelNorte extends Panel {
	
	private JTextField resultado;
//	private Calculadora calculadora;
	
	public PanelNorte(){
		super();
		GridLayout layout = new GridLayout();
		setLayout(layout);
		
		resultado = new JTextField();
		resultado.setHorizontalAlignment(JTextField.RIGHT);
		add(resultado);
	}
	
	public PanelNorte(Calculadora calculadora){
		this();
		this.calculadora = calculadora;
	}

	//**************************************************

	public void setResultado(String valor){
		this.resultado.setText(valor);		
	}
	
	public JTextField getResultado() {
		return resultado;
	}

	public void setResultado(JTextField resultado) {
		this.resultado = resultado;
	}

}