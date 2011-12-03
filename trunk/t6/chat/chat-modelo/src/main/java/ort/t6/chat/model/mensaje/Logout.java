package ort.t6.chat.model.mensaje;

import ort.t6.chat.model.Contacto;

public class Logout implements IMensaje {

	private static final long serialVersionUID = 7078535860133189652L;
	private Contacto contacto; //origen
	
	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public Contacto getContacto() {
		return contacto;
	}
	
	@Override
	public String toString(){
		return "user: " + contacto.getNick() + " ip: " + contacto.getIp();
	}
}