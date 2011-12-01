package ort.t6.calculadora.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ort.t6.calculadora.core.modelo.Calculadora;

public class PanelCentral extends Panel {

	private static final long serialVersionUID = 1502613751923235884L;
	
	private JButton cero;
	private JButton uno;
	private JButton dos;
	private JButton tres;
	private JButton cuatro;
	private JButton cinco;
	private JButton seis;
	private JButton siete;
	private JButton ocho;
	private JButton nueve;
	
	private JButton punto;
	
	private JButton multiplicar;
	private JButton dividir;
	private JButton restar;
	private JButton sumar;
	private JButton igual;
	
	private boolean xNumero = false;  // identifica que se haya presionado un numero
	private boolean xOperacion = false; // identifica que se haya presionado una operacion, 
	// dependiendo los valores que se hayan actualizado se procedera a enviar los valores 
	// agregar numero o ejecutar operacion.
	
	
//	private Calculadora calculadora;
	
	public PanelCentral(){
		super();
		GridLayout layout = new GridLayout(4, 4);
		setLayout(layout);
		
		siete = crearBotonNumerico("7");
		add(siete);

		ocho = crearBotonNumerico("8");
		add(ocho);
		
		nueve = crearBotonNumerico("9");
		add(nueve);
		
		multiplicar = crearBotonOperacion("*");
		add(multiplicar);


		cuatro = crearBotonNumerico("4");
		add(cuatro);
		
		cinco = crearBotonNumerico("5");
		add(cinco);
		
		seis = crearBotonNumerico("6");
		add(seis);
		
		dividir = crearBotonOperacion("/");
		add(dividir);
				
		
		uno = crearBotonNumerico("1");
		add(uno);
		
		dos = crearBotonNumerico("2");
		add(dos);
		
		tres = crearBotonNumerico("3");
		add(tres);
		
		restar = crearBotonOperacion("-");
		add(restar);
		
		
		punto = new JButton(".");
		add(punto);
		
		cero = crearBotonNumerico("0");
		add(cero);
		
		igual = new JButton("=");
		add(igual);		
		
		sumar = crearBotonOperacion("+");
		add(sumar);
	}

	public PanelCentral(Calculadora calculadora){
		this();
		this.calculadora = calculadora;
		
		// agregar la concatenacion del resultado, y luego cuando se presiona el boton
		// de operacion mandar todo el string a calculadora.agregarValor
	}
	
	private JButton crearBotonNumerico(String texto){
		JButton boton = new JButton(texto);
		boton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agregarNumero(e);
			}
		});
		return boton;
	}
	
	private JButton crearBotonOperacion(String texto){
		JButton boton = new JButton(texto);
		boton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ejecutarOperacion(e);
			}
		});
		return boton;
	}
	
	private void agregarNumero(ActionEvent e){
		JButton boton = (JButton) e.getSource();
		//System.out.println(boton.getText());
		
		// se deberian concatenar los valores ingresados hasta 
		// que se presione un valor. Luego de presionarlo deberiamos agregar los valores 
		// transformados a valores para poder realizar el calculo.
		Double valor = new Double(boton.getText());
		// se debe concatenar los valores en el panel norte.
		if(xOperacion==true)
			calculadora.agregarNumero(valor);
		//else
			// sigo concatenado valores en el panel norte.
		
	}
	
	private void ejecutarOperacion(ActionEvent e){
		JButton boton = (JButton) e.getSource();
		//System.out.println(boton.getText());
		if(xNumero==true)
			calculadora.agregarOperador(boton.getText());
		
	}
	
	//**************************************************
	
	public JButton getCero() {
		return cero;
	}

	public void setCero(JButton cero) {
		this.cero = cero;
	}

	public JButton getUno() {
		return uno;
	}

	public void setUno(JButton uno) {
		this.uno = uno;
	}

	public JButton getDos() {
		return dos;
	}

	public void setDos(JButton dos) {
		this.dos = dos;
	}

	public JButton getTres() {
		return tres;
	}

	public void setTres(JButton tres) {
		this.tres = tres;
	}

	public JButton getCuatro() {
		return cuatro;
	}

	public void setCuatro(JButton cuatro) {
		this.cuatro = cuatro;
	}

	public JButton getCinco() {
		return cinco;
	}

	public void setCinco(JButton cinco) {
		this.cinco = cinco;
	}

	public JButton getSeis() {
		return seis;
	}

	public void setSeis(JButton seis) {
		this.seis = seis;
	}

	public JButton getSiete() {
		return siete;
	}

	public void setSiete(JButton siete) {
		this.siete = siete;
	}

	public JButton getOcho() {
		return ocho;
	}

	public void setOcho(JButton ocho) {
		this.ocho = ocho;
	}

	public JButton getNueve() {
		return nueve;
	}

	public void setNueve(JButton nueve) {
		this.nueve = nueve;
	}

	public JButton getPunto() {
		return punto;
	}

	public void setPunto(JButton punto) {
		this.punto = punto;
	}

	public JButton getMultiplicar() {
		return multiplicar;
	}

	public void setMultiplicar(JButton multiplicar) {
		this.multiplicar = multiplicar;
	}

	public JButton getDividir() {
		return dividir;
	}

	public void setDividir(JButton dividir) {
		this.dividir = dividir;
	}

	public JButton getRestar() {
		return restar;
	}

	public void setRestar(JButton restar) {
		this.restar = restar;
	}

	public JButton getSumar() {
		return sumar;
	}

	public void setSumar(JButton sumar) {
		this.sumar = sumar;
	}

	public JButton getIgual() {
		return igual;
	}

	public void setIgual(JButton igual) {
		this.igual = igual;
	}

	public Calculadora getCalculadora() {
		return calculadora;
	}

	public void setCalculadora(Calculadora calculadora) {
		this.calculadora = calculadora;
	}
	
}