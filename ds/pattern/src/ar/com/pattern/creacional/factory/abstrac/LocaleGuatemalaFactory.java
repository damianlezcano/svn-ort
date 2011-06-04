package ar.com.pattern.creacional.factory.abstrac;

//Ahora implementamos nuestra clase LocaleGuatemalaFactory, que va así:
class LocaleGuatemalaFactory extends AbstractLocaleFactory {

	public LocaleGuatemalaFactory() {
		this.pais = this.GT;
	}

	public Traductor createTraductor() {
		return TraductorFactory.createTraductor("espanol");
	}

	public Reloj createReloj() {
		return RelojFactory.createReloj(RelojFactory.RELOJ_24_HRS);
	}

}