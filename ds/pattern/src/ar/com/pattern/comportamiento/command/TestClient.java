package ar.com.pattern.command;

/* The test class or client */
public class TestClient {
	   public static void main(String[] args) {
	       
		   Receiver lamp = new Receiver();
	       
	       Command switchUp = new SumarCommand(lamp);
	       Command switchDown = new RestarCommand(lamp);
	 
	       // See criticism of this model above:
	       // The switch itself should not be aware of lamp details (switchUp, switchDown) 
	       // either directly or indirectly
	       Invoker s = new Invoker(switchUp,switchDown);
	       
	       s.sumarGenerico();
	       s.restarGenerico();

	   }
}
