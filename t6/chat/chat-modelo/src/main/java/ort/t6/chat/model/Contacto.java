package ort.t6.chat.model;

public class Contacto {

	private Boolean estado;
	private String nick;
	private String ip;

	public Contacto(Boolean estado, String nombre, String ip) {
		this.estado = estado;
		this.nick = nombre;
		this.ip = ip;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNick() {
		return nick;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}