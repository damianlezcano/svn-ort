package ort.t6.chat.model.mensaje;

import ort.t6.chat.model.Contacto;

public class Login implements IMensaje {

	private static final long serialVersionUID = 9149836013154774216L;
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