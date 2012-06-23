package model;

public class Standard extends User {
	
	private Sportsman sporstman;

	public void setSporstman(Sportsman sporstman) {
		this.sporstman = sporstman;
	}

	public Sportsman getSporstman() {
		return sporstman;
	}

	@Override
	public String getRole() {
		return "STANDARD";
	}

}
