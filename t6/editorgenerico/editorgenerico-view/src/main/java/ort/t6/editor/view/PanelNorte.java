package ort.t6.editor.view;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class PanelNorte extends JPanel {
	
	private static final long serialVersionUID = 4611693976110369355L;
	private final static Logger log = Logger.getLogger(PanelNorte.class);
	
	private JTextField direccion;
	private JButton abrir;
	private JButton guardar;
	private JButton cerrar;
	
	public PanelNorte(){
		super();
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
		
		BoxLayout layout = new BoxLayout(this, BoxLayout.LINE_AXIS);
		setLayout(layout);
		
		direccion = new JTextField();
		direccion.setBackground(Color.WHITE);
		direccion.setEditable(false);
		add(direccion);
		
		abrir = new JButton("Abrir");
		add(abrir);
		
		guardar = new JButton("Guardar");
		guardar.setEnabled(false);
		add(guardar);
		
		cerrar = new JButton("Cerrar");
		cerrar.setEnabled(false);
		add(cerrar);
	}

	//*************************************************

	public JTextField getDireccion() {
		return direccion;
	}

	public void setDireccion(JTextField direccion) {
		this.direccion = direccion;
	}

	public JButton getAbrir() {
		return abrir;
	}

	public void setAbrir(JButton abrir) {
		this.abrir = abrir;
	}

	public JButton getGuardar() {
		return guardar;
	}

	public void setGuardar(JButton guardar) {
		this.guardar = guardar;
	}

	public JButton getCerrar() {
		return cerrar;
	}

	public void setCerrar(JButton cerrar) {
		this.cerrar = cerrar;
	}
}