package persistence;


import java.util.List;


/**
 * Este es nuestro DAO
 */
public class EntityManager {

	private Query query;
	
	/**
	 * Crea o actualiza un dato 
	 */
	public Query create(Object ... item) {
		System.out.println("Creando un dato");
		return null;
	}

	public Query delete(Object ... item) {
		System.out.println("Elimino un dato");
		return null;
	}
	
	public Query find(Object ... item) {
		System.out.println("Buscando un dato");
		return null;
	}

	public Query update(Object ... user) {
		System.out.println("Actualizo un dato");
		return null;
	}

	//----
	
	public interface Query {
		public <T>List getListResult();
		public Object getSingleResult();
	}

}