package ort.t6.chat.exception;

public class UsuarioInexistenteException extends Exception {

	private static final long serialVersionUID = 6822742979115622985L;

	public UsuarioInexistenteException(){
		super("El usuario no existe");
	}
	
}