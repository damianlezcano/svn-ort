package ar.com.pattern.proxy;

//the Proxy
public class PotOfTeaProxy implements PotOfTeaInterface {
	PotOfTea potOfTea;

	public PotOfTeaProxy() {
	}

	public void pourTea() {
		if(potOfTea == null)
			potOfTea = new PotOfTea();
		
		potOfTea.pourTea();
	}
}