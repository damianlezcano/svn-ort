package ort.t6.editor.core.operations;

import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;

import org.apache.log4j.Logger;

import ort.t6.editor.core.utils.JPanelConFondo;

public class ArchivoImagen extends ArchivoEditable {

	private final static Logger log = Logger.getLogger(ArchivoImagen.class);
	private JPanelConFondo panelImagen;
	
	public ArchivoImagen(){
		super();
		this.panelImagen = new JPanelConFondo();
		this.getPanel().add(panelImagen);
	}
	
	@Override
	public void open(String filename) throws FileNotFoundException, IOException {
	     Image imagen = new ImageIcon(filename).getImage();
		 panelImagen.setImagen(imagen);
		 notificar();
	}

	@Override
	public void save() throws IOException {
		log.info("Guardar archivo de texto");
		notificar();
	}

	@Override
	public void close() {
		log.info("Cerrar archivo de texto");
		notificar();
	}
}