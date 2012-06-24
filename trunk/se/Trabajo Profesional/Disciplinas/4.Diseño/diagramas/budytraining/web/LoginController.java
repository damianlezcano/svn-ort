package web;


import service.UserServiceBean;
import model.User;



/**
 * Pagina de Login
 */
public class LoginController {
	
	private User user;
	private UserServiceBean userservicebean;

	public void authenticated(String email, String password){
	}

	public void rememberMail(String email){
	}
	
	public boolean isRegistred(String email){
		return false;
	}
	
	public void changesPassword(){
	}
	
	public void setPassword(String password, String newPassword){
		
	}
	
	public boolean validator(){
		return true;
	}
	
	public void save(){
	}
	
}
