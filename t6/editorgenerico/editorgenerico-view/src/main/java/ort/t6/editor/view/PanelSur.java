package ort.t6.editor.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.log4j.PropertyConfigurator;


public class PanelSur extends JPanel {

	private static final long serialVersionUID = -6234816088373059991L;

	protected static final String MENSAJE_INICIAL = "No hay archivo cargado";
	protected static final String MENSAJE_ERROR_FORMATO = "No existe vista para este formato";
	protected static final String MENSAJE_EXITO = "Archivo cargado con exito";
	
	private JLabel mensaje;
	
	public PanelSur(){
		super();
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
		
		GridLayout layout = new GridLayout();
		setLayout(layout);
		
		mensaje = new JLabel();
		mensaje.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		add(mensaje);
		
		cambiarMensaje(PanelSur.MENSAJE_INICIAL, Color.YELLOW);
	}

	//************************************************************
	
	public void cambiarMensaje(String mensaje, Color color){
		this.mensaje.setText(mensaje);
		this.setBackground(color);
	}
}