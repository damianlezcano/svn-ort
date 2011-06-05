package ar.com.pattern.creacional.factory.abstrac.Computers;

public class ComputerType {
	
	private computers comp;

	/**
	 * Returns a computer for a type
	 * @param computerType String, PC / Workstation / Server
	 * @return Computer
	 */
	public computers getComputer(String computerType) {

		if (computerType.equals("pc"))
			comp = new pc();
		else if (computerType.equals("workstation"))
			comp = new workstation();
		else if (computerType.equals("server"))
			comp = new server();

		return comp;
	}
}
