package ort.t6.calculadora.core.modelo;

import java.util.Observable;

import ort.t6.calculadora.core.fabrica.FabricaOperaciones;

public class Calculadora extends Observable{

	private double total = 0;
	private Operacion operacion;
	private FabricaOperaciones fabrica;

	public Calculadora(){
		fabrica = FabricaOperaciones.getInstance();
	}
	
	public void reiniciar() {
		this.total = 0;
		this.operacion = null;
		notificar();
	}

	public void agregarNumero(double valor) {
		if (operacion == null){
			this.total = valor;
		}else{
			this.total = operacion.calcular(this.total, valor);
		}
		notificar();
	}
	
	public void agregarOperador(String operador) {
		operacion = fabrica.crearOperacion(operador);
	}

	public void cambiarSigno(){
		if(total != 0 ){
			total = total * -1;
			notificar();
		}
	}
	
	private void notificar(){
		this.setChanged();
		this.notifyObservers();
	}
	
	/* Autogenerado */
	public void setTotal(double total) {
		this.total = total;
		notificar();
	}

	public double getTotal() {
		return total;
	}
}