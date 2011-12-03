package ort.t6.chat.model.mensaje;

import java.util.List;

import ort.t6.chat.model.Contacto;

public class Mensaje implements IMensaje {

	private static final long serialVersionUID = 1949388280696179950L;

	private Contacto contacto; // origen
	private String texto;
	private List<Contacto> destinos; // Si no se seleccion

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

	public List<Contacto> getDestinos() {
		return destinos;
	}

	public void setDestinos(List<Contacto> destinos) {
		this.destinos = destinos;
	}
	
	@Override
	public String toString(){
		return texto; 
	}

}