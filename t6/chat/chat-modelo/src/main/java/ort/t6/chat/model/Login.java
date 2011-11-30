package ort.t6.chat.model;

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
		return contacto.getNick() + " - " +contacto.getEstado().toString();
	}
	
}