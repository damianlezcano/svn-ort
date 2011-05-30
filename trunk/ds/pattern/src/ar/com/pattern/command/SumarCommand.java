package ar.com.pattern.command;

/* The Command for turning the light on in North America, or turning the light off in most other places */
public class SumarCommand implements Command {
	   private Receiver theLight;
	   
	   public SumarCommand(Receiver light) {
	        this.theLight=light;
	   }
	 
	   public void execute(){
	      theLight.sumar();
	   }
}
