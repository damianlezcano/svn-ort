package ort.t6.chat.model.mensaje;

import java.util.List;

import ort.t6.chat.model.Contacto;

public class Lista implements IMensaje {

	private static final long serialVersionUID = -7531940654325569957L;
	private List<Contacto> usuarios; // Si no se seleccion

	public Lista() {
	}

	public Lista(List<Contacto> conectados){
		this.usuarios = conectados;
	}

	public List<Contacto> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Contacto> usuarios) {
		this.usuarios = usuarios;
	}

}