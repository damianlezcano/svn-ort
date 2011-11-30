package ort.t6.chat.model;

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
		return contacto.getNick() + " - " +contacto.getEstado().toString();
	}
}