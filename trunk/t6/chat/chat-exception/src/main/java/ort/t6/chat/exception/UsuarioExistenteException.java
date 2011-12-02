package ort.t6.chat.exception;

public class UsuarioExistenteException extends Exception {

	private static final long serialVersionUID = 6822742979115622985L;

	public UsuarioExistenteException(){
		super("El usuario ya existe");
	}
	
}