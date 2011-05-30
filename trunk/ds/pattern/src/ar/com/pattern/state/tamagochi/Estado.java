package ar.com.pattern.state.tamagochi;

public interface Estado {
	public Estado comer();
	public Estado insultar();
	public Estado patear();
}