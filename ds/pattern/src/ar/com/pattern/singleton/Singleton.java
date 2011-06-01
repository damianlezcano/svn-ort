package ar.com.pattern.singleton;

/**
 * <li>Define una operacion Intancia....
 */
public class Singleton {

	// declaracion de la variable objeto singleto 
	// tambien se hace la instanciacion a null para denotar que no hay 
	// una instacia de este objeto
	private static Singleton unico = null;
	private static String texto;
	private static int	instancia = 0;
	/**
	 * @author pablo
	 * contructor por defecto, en privado para que desde afuera no
	 * puedan crear mas de una instancia del mismo objeto 
	 **/
	private Singleton(){
		texto = new String("He creado una nueva instancia");
		instancia++; // cada vez que accedo a crear una instacia acumulo. 
					 //solo se deveria ver siempre 1
	}
	
	/**
	 * constructor de la clase singleton  
	 * @return 
	 **/
	public static Singleton getInstancia()
	{
		if(unico == null)
			unico = new Singleton();
		else
			texto="No se ha podido crear una nueva instancia porque ya existe y el ID es ->";
		/*si la instancia no esta creada se crea y se devuelve el puntero 
		 * a la instancia*/
		imprimir();
		return unico;
	}
	
	private static void imprimir()
	{
		System.out.print(texto+" "+instancia+"\n");
	}	
}