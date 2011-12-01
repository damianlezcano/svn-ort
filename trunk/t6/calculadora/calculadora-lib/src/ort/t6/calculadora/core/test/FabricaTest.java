package ort.t6.calculadora.core.test;

import ort.t6.calculadora.core.fabrica.FabricaOperaciones;

public class FabricaTest {

	public static void main(String[] args) {
		traerTodasLasOperaciones();
		//comprobarInstancia();
	}

	public static void traerTodasLasOperaciones(){
		FabricaOperaciones fabrica = FabricaOperaciones.getInstance();
		System.out.println(fabrica.traerOperaciones().size());
	}
	
	public static void comprobarInstancia(){
		FabricaOperaciones fabrica = FabricaOperaciones.getInstance();
		fabrica.crearOperacion("+");
		
		if(fabrica instanceof FabricaOperaciones){
			System.out.println("todo ok");
		}else{
			System.out.println("todo mal");
		}
	}	
}