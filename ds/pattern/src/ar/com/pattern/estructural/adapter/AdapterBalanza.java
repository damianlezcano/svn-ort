package ar.com.pattern.estructural.adapter;

public class AdapterBalanza extends Regla {

	Balanza balanza;

	public void medir() {
		if (balanza == null)
			balanza = new Balanza();
		balanza.medimeEsta();
	}

}
