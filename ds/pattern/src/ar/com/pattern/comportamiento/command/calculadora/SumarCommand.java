package ar.com.pattern.comportamiento.command.calculadora;

/**
 * PARTICIPANTE: OrdenConcreta (OrdenPegar, OrdenAbrir) 
 * <li>Define un enlace entre un objeto Receptor y una accion 
 * <li>Implementa Ejecutar invocando la correspondiente operacion u operaciones del Receptor.
 */
public class SumarCommand implements Command {
	   private Calculadora calculadora;
	   
	   public SumarCommand(Calculadora calculadora) {
	        this.calculadora=calculadora;
	   }
	 
	   public void execute(){
		  System.out.println("SumarCommand: Ejecuto metodo 'execute()'");
	      calculadora.sumar();
	   }

	@Override
	public String nombreComando() {
		return "Sumar";
	}
}
