package ar.com.pattern.proxy;

//the Real Subject
public class PotOfTea implements PotOfTeaInterface {
	public PotOfTea() {
		System.out.println("Making a pot of tea");
	}

	public void pourTea() {
		System.out.println("Pouring tea");
	}
}
