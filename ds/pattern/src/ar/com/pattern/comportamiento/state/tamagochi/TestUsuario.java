package ar.com.pattern.comportamiento.state.tamagochi;

public class TestUsuario {

	private Estado estado;
	
	TestUsuario(){
		estado = new EstadoContento();
	}
	
	public Estado getEstado(){
		return estado;
	}

	public void setEstado(Estado estado){
		this.estado = estado;
	}
	
	public static void main(String[] args) {
		TestUsuario usuario = new TestUsuario();
		
		//estado = estado.comer();
		usuario.setEstado(usuario.getEstado().comer());
		//estado = estado.comer();
		usuario.setEstado(usuario.getEstado().comer());
		//estado = estado.comer();
		usuario.setEstado(usuario.getEstado().comer());		
	}
}