package ar.com.pattern.creacional.factory.abstrac.jpanel;

//abstract factory
abstract class CUIFactory {

	public static int PANEL_ROJO = 0;
	public static int PANEL_VERDE = 1;
	public static int PANEL_AZUL = 2;

	public static CUIFactory getFactory(int clasif) {

		if (clasif == CUIFactory.PANEL_ROJO) {
			return new PanelRojoFactory();
		}else if(clasif == CUIFactory.PANEL_VERDE){
			return new PanelVerdeFactory();
		}else if(clasif == CUIFactory.PANEL_AZUL){
			return new PanelAzulFactory();
		}
		return null;
	}

	public abstract JCUIPanel createPanel();
}