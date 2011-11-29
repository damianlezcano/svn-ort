package ort.t6.editor.core.operations;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Observable;

import javax.swing.JPanel;

import org.apache.log4j.PropertyConfigurator;

public abstract class ArchivoEditable extends Observable{

	private boolean modified;
	private JPanel panel;
	protected String filename;

	public ArchivoEditable(){
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
		panel = new JPanel(new BorderLayout());
	}
	
	public boolean isModified() {
		return modified;
	}

	protected void setModified(boolean value) {
		notificar();
		this.modified = value;
	}

	public JPanel getPanel() {
		return this.panel;
	}

	protected void notificar(){
		this.setChanged();
		this.notifyObservers();
	}

	//METODOS A IMPLEMENTAR
	public abstract void open(String filename) throws FileNotFoundException, IOException;
	public abstract void save() throws IOException;
	public abstract void close();
	
}