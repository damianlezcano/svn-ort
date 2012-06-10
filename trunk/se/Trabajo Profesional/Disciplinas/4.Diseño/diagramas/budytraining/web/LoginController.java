package web;



/**
 * Pagina de Login
 */
public class LoginController {

	private String name;
	private String password;
	
	public void authenticated(String name, String password){
		SmookUtil.call("UserServiceBean", "isRegistred", name, password);
	}

	
	private boolean validateMail(String email){
		return true;
	}

}
