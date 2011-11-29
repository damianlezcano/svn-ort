package ort.t6.chat.model;

import java.io.Serializable;
import java.util.Vector;

public class Lista implements Serializable {

	private static final long serialVersionUID = -7531940654325569957L;
	private Vector usuarios; //Si no se seleccion

	public void setUsuarios(Vector usuarios) {
		this.usuarios = usuarios;
	}

	public Vector getUsuarios() {
		return usuarios;
	}
}