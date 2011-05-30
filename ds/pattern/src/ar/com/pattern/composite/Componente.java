package ar.com.pattern.composite;

public abstract class Componente {
	
	protected String nombre;

	public Componente(String nombre) {
		this.nombre = nombre;
	}

	abstract public void Anadir(Componente c);

	abstract public void Eliminar(Componente c);

	abstract public void ObtenerHijo(int hijo);
	
	abstract public void Operacion();
}
