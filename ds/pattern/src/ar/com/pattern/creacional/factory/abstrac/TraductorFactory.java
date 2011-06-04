package ar.com.pattern.creacional.factory.abstrac;

class TraductorFactory {
     public TraductorFactory(){
     }
 
	public static Traductor createTraductor(String idioma){
		Traductor traductor = null;
		if (idioma=="español"){
			traductor = new TraductorEspanol();
		}
 
		if (idioma=="english"){
			traductor = new TraductorIngles();
		} 
		return traductor;
	}
}//de la clase