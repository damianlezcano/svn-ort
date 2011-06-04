package ar.com.pattern.creacional.factory.abstrac.Computers;

public abstract class computers {
  	/**
	* Abstract method, returns the Parts ideal for
	* Server
	* @return Parts
	*/
	public abstract Parts getRAM();

	/**
	* Abstract method, returns the Parts ideal for
	* Workstation
	* @return Parts
	*/
	public abstract Parts getProcessor();

	/**
	* Abstract method, returns the Parts ideal for
	* PC
	* @return Parts
	*/
	public abstract Parts getMonitor();
	
}
