package ar.com.pattern.command;

/* The Command for turning the light off in North America, or turning the light on in most other places */
public class RestarCommand implements Command {

	   private Receiver theLight;
	   
	   public RestarCommand(Receiver light) {
	        this.theLight=light;
	   }
	 
	   public void execute() {
	      theLight.restar();
	   }

}
