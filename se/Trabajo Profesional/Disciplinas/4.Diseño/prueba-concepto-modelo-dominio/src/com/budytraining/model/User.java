package com.budytraining.model;

/**
 * Usuario de la aplicacion
 */
public abstract class User {
	
	/**
	 * Nombre del usuario
	 */
	private String name;
	
	/**
	 * Si esta activo (si se confirmo el pago las subcripcion)
	 */
	private Boolean active;
	
	/**
	 * El rol del usuario
	 */
	private Role role;
	
	/**
	 * Direccion de correo electronico del usuario
	 */
	private String email;

	//------------------------------
	
	public User(){
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
}
