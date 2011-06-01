package ar.com.pattern.comportamiento.command.calculadora;

/*
 * PROPOSITO:
 * Encapsula una peticion en un objeto, permitiendo asi parametrizar a los clientes
 * con diferentes peticiones, hacer cola o llever un registro de las peticiones, y 
 * poder deshacer las operaciones
 * 
 * MOTIVACION:
 * A veces es necesario enviar peticiones a objetos sin saber nada acerca de las operaciones
 * solicitada o de quien es el receptor de la peticion.
 * 
 * COLABORACION
 * <ti> El cliente crea un objeto OrdenConcreta y especifica su receptor.
 * <ti> Un objeto Invocador almacena el objeto OrdenConcreta
 * <ti> El invocador envia una peticion llamando a Ejecutar sobre la orden. Cuando las ordenes
 * se pueden deshacer, OrdenConcreta guarda el estado para deshacer la orden antes de llamar a Ejecutar
 * <ti> El objeto OrdenConcreta invoca operaciones de su receptor para llevar a cabo la peticion.
 */

/**
 * PARTICIPANTE: Cliente (Aplicacion)
 * <li> Crea un objeto OrdenConcreta y establece su receptor
 */
public class TestClient {
	   public static void main(String[] args) {
	       
		   Calculadora calculadora = new Calculadora();
	       
	       Command sumar = new SumarCommand(calculadora);
	       Command restar = new RestarCommand(calculadora);
	       
	       Invoker invoker = new Invoker(sumar,restar);
	       
	       invoker.sumarGenerico();
	       invoker.restarGenerico();

	   }
}
