package ort.t6.chat.cliente.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ort.t6.chat.model.Contacto;

public class Registro extends JPanel {

	private static final long serialVersionUID = -5781912743553129962L;
	
	private Contacto contacto;
	private JLabel estado;
	private JLabel nombre;
	private JLabel ip;
	private JLabel icono;
	
	private JPanel panel;
	
	public Registro(){
		setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
//		setBorder(BorderFactory.createLineBorder(new Color(186,214,250)));
	}
	
	public Registro(Contacto contacto){
		this();
		this.setContacto(contacto);
		
		add(Box.createRigidArea(new Dimension(10,0))); //agrego invisible para separar en ancho
		
		if(contacto.getEstado() == null){
			estado = new JLabel(new ImageIcon("./src/main/resources/img/invisible.png"));
		}else{
			if(contacto.getEstado()){
				estado = new JLabel(new ImageIcon("./src/main/resources/img/available.png"));
			}else{
				estado = new JLabel(new ImageIcon("./src/main/resources/img/offline.png"));
			}
		}
		add(estado);

		add(Box.createRigidArea(new Dimension(10,0))); //agrego elemento invisible para separar en ancho
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		nombre = new JLabel(contacto.getNick());
		Font newLabelFont = new Font(nombre.getFont().getName(),Font.BOLD,nombre.getFont().getSize());
		nombre.setFont(newLabelFont);
		panel.add(nombre,BorderLayout.NORTH);
		ip = new JLabel(contacto.getIp());
		panel.add(ip,BorderLayout.SOUTH);
		
		add(panel); //agrego 3er elemento
		
		add(Box.createRigidArea(new Dimension(0,35))); //agrego elemento invisible para separar en alto
		
		if(contacto.getEstado() == null){
			icono = new JLabel(new ImageIcon("./src/main/resources/img/all.png"));
		}else{
			icono = new JLabel(new ImageIcon("./src/main/resources/img/person.png"));
		}
		add(icono);
		
		add(Box.createRigidArea(new Dimension(10,0))); //agrego elemento invisible para separar en ancho
	}
	
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JPanel getPanel() {
		return panel;
	}
	
	public JLabel getEstado() {
		return estado;
	}

	public void setEstado(JLabel estado) {
		this.estado = estado;
	}

	public JLabel getNombre() {
		return nombre;
	}

	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}

	public JLabel getIp() {
		return ip;
	}

	public void setIp(JLabel ip) {
		this.ip = ip;
	}

	public JLabel getIcono() {
		return icono;
	}

	public void setIcono(JLabel icono) {
		this.icono = icono;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

}