package web;

import java.util.List;

import model.Sportsman;
import model.User;
import service.SportsmanServiceBean;

public class FindSportsmanController {

	private User user;
	private Sportsman sportsman;
	private SportsmanServiceBean sportsmanServiceBean;
	
	public List<Sportsman> find(){
		return sportsmanServiceBean.find(sportsman);
	}
}
