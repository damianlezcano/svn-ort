package model;

import java.util.List;

public class Professional extends User {

	private List<ITrainable> iTrainables;

	public void setiTrainables(List<ITrainable> iTrainables) {
		this.iTrainables = iTrainables;
	}

	public List<ITrainable> getiTrainables() {
		return iTrainables;
	}
	
}
