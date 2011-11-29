package ort.t6.chat.model;

import java.util.Vector;

public class Mensaje implements IMensaje {

	private static final long serialVersionUID = 1949388280696179950L;

	private Contacto contacto; //origen
	private String texto;
	private Vector usuarios; //Si no se seleccion
	
	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
	public Contacto getContacto() {
		return contacto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getTexto() {
		return texto;
	}
	public void setUsuarios(Vector usuarios) {
		this.usuarios = usuarios;
	}
	public Vector getUsuarios() {
		return usuarios;
	}
}