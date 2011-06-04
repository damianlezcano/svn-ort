package ar.com.pattern.creacional.factory.abstrac;

// Nuestra clase que contiene la el método que elije las instancias. A diferencia del post anterior, ahora el parámetro que recibe el método es un entero, que acepta los enteros especificados como constantes estáticas en la clase. Esto se usa mucho para no estar adivinando los paráemetros que acepta el método:
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