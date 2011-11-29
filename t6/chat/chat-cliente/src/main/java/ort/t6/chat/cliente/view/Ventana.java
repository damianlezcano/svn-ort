package ort.t6.chat.cliente.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

import ort.t6.chat.model.Contacto;

public class Ventana extends JFrame {

	private static final long serialVersionUID = -3345896499252067716L;
	
	private static final String LOOK_GTK = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
	private static final String LOOK_WINDOWS = "java.awt.swing.plaf.windows.WindowsLookAndFeel";
	private static final String LOOK_NIMBUS = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
	
	private final static Logger log = Logger.getLogger(Ventana.class);
	
	private JListWithImages registros;
	private JComboBox combo;

	public Ventana(){
		
		cambiarLookAndFeel(LOOK_WINDOWS);
		
		setTitle("Cliente");
		setBounds(10, 10, 250, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		mockRegistros();
		
		setListener();
		setLayout();
		
		combo.addItem("Desconectado");
		combo.addItem("Conectado");
		
	}

	private void setListener() {
		registros.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        doubleClickJList(evt);
		    }
		});
	}

	private void cambiarLookAndFeel(String look) {
		try {
			UIManager.setLookAndFeel(look);
		} catch (Exception b) {
			try {
				log.info("Error al cambiar look and feel");
				UIManager.setLookAndFeel(LOOK_NIMBUS);
			} catch (Exception c) {
				log.info("Error al cambiar look nimbus");
			}
		}
	}

	private void setLayout() {
		Container principal = getContentPane();
		principal.setLayout(new BorderLayout());
		
		JPanel norte = new JPanel();
		norte.setBackground(Color.WHITE);
		norte.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel tituloLista = new JLabel("Lista de Contactos");
		Font newLabelFont = new Font(tituloLista.getFont().getName(),Font.BOLD,tituloLista.getFont().getSize());
		tituloLista.setFont(newLabelFont);
		norte.add(Box.createRigidArea(new Dimension(4,0)));
		norte.add(tituloLista);
		principal.add(norte,BorderLayout.NORTH);
		
		principal.add(registros, BorderLayout.CENTER);
		
		combo = new JComboBox();
		principal.add(combo, BorderLayout.SOUTH);
	}

	public void doubleClickJList(MouseEvent evt) {
		JList list = (JList)evt.getSource();
        if (evt.getClickCount() == 2) { // Double-click
        	Registro registro = (Registro)list.getSelectedValue();
        	Contacto contacto = registro.getContacto();
        	if(contacto.getEstado() == null || contacto.getEstado()){
        		new Conversacion(this, contacto);
        	}
        }
	}
	
	// ************************************************

	public static void main(String[] args) {
		Ventana ventana = new Ventana();
		ventana.setVisible(true);
	}

	private void mockRegistros() {
		List<Registro> mocks = new ArrayList<Registro>();
		mocks.add(new Registro(new Contacto(null, "Todos", "a todos los contactos")));
		mocks.add(new Registro(new Contacto(true, "Pepe", "10.0.0.2")));
		mocks.add(new Registro(new Contacto(true, "Pablo", "10.0.0.3")));
		mocks.add(new Registro(new Contacto(false, "Ceci", "10.0.0.4")));
		registros = new JListWithImages(mocks);
	}
}