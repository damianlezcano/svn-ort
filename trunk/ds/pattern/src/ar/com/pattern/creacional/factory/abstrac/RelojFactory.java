package ar.com.pattern.creacional.factory.abstrac;

// Nuestra clase que contiene la el m�todo que elije las instancias. A diferencia del post anterior, ahora el par�metro que recibe el m�todo es un entero, que acepta los enteros especificados como constantes est�ticas en la clase. Esto se usa mucho para no estar adivinando los par�emetros que acepta el m�todo:
class RelojFactory {
	public static final int RELOJ_AM_PM = 0;
	public static final int RELOJ_24_HRS = 1;

	public static Reloj createReloj(int tipoDeReloj) {
		if (tipoDeReloj == RelojFactory.RELOJ_24_HRS) {
			return new Reloj24Hrs();
		}
		if (tipoDeReloj == RelojFactory.RELOJ_AM_PM) {
			return new RelojAmPm();
		}

		return null;
	}

}