package ort.t6.chat.model;

public class Error implements IMensaje {

	private static final long serialVersionUID = -6036276362104234786L;
	
	private Exception excepcion;

	public Exception getExcepcion() {
		return excepcion;
	}

	public void setExcepcion(Exception excepcion) {
		this.excepcion = excepcion;
	}
	
	@Override
	public String toString(){
		return "Esto es un error";
	}
	
}