package ort.t6.calculadora.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import ort.t6.calculadora.core.fabrica.FabricaOperaciones;
import ort.t6.calculadora.core.modelo.Calculadora;
import ort.t6.calculadora.core.modelo.Operacion;

public class PanelEste extends Panel {
	
	private JButton borrar;
	private JButton cambiarSigno;
	
//	private Calculadora calculadora;
	
	private FabricaOperaciones fabrica;
	
	public PanelEste(){
		super();
		BoxLayout layout = new BoxLayout(this,BoxLayout.PAGE_AXIS);
		setLayout(layout);
		
		borrar = new JButton("C");
		borrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				reiniciar();
			}
		});
		add(borrar);
		
		cambiarSigno = new JButton("+/-");
		cambiarSigno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cambiarSigno();
			}
		});
		add(cambiarSigno);
		
		agregarOperacionesDinamicas();
	}
	

	public PanelEste(Calculadora calculadora){
		this();
		this.calculadora = calculadora;	
	}
	
	private void agregarOperacionesDinamicas(){
		fabrica = FabricaOperaciones.getInstance();
		
		for (Operacion operacion : fabrica.traerOperaciones()) {
			if((operacion.getOperacion() != Operacion.SUMA) && (operacion.getOperacion() != Operacion.RESTA) && 
			(operacion.getOperacion() != Operacion.MULTIPLICACION) && (operacion.getOperacion() != Operacion.DIVISION)){
				JButton boton = crearBotonOperacion(operacion.getOperacion());
				add(boton);
			}
		}
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
	
	private void ejecutarOperacion(ActionEvent e){
		JButton boton = (JButton) e.getSource();
		calculadora.agregarOperador(boton.getText());
	}
	
	public void reiniciar(){
		calculadora.reiniciar();
	}
	
	public void cambiarSigno(){
		calculadora.cambiarSigno();
	}
	
	//**************************************************

	public JButton getBorrar() {
		return borrar;
	}

	public void setBorrar(JButton borrar) {
		this.borrar = borrar;
	}

	public JButton getCambiarSigno() {
		return cambiarSigno;
	}

	public void setCambiarSigno(JButton cambiarSigno) {
		this.cambiarSigno = cambiarSigno;
	}

}