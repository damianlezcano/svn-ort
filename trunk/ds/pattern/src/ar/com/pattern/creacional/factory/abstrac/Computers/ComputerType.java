package ar.com.pattern.creacional.factory.abstrac.Computers;

public class ComputerType {
	private computers comp;

	public static void main(String[] args) {
	  	  	ComputerType type = new ComputerType();

	computers computer = type.getComputer("workstation");
	System.out.println("Monitor: "+computer.getMonitor().getSpecification());
	System.out.println("RAM: "+computer.getRAM().getSpecification());
	System.out.println("Processor: "+computer.getProcessor().getSpecification());
	 }  	 
	  	  	

	/**
	* Returns a computer for a type
	*
	* @param computerType String, PC / Workstation / Server
	* @return Computer
	*/
	public computers getComputer(String ComputerType) {
	
			if (ComputerType.equals("pc"))
					comp = new pc();
			else if(ComputerType.equals("workstation"))
					comp = new workstation();
			else if(ComputerType.equals("server"))
				comp= new server();

	return comp;
	  	}
}
