package ort.t6.chat.cliente.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

import ort.t6.chat.cliente.lib.Cliente;
import ort.t6.chat.model.Contacto;

public class Ventana extends JFrame implements Observer {

	private static final long serialVersionUID = -3345896499252067716L;
	
	private static final String LOOK_GTK = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
	private static final String LOOK_WINDOWS = "java.awt.swing.plaf.windows.WindowsLookAndFeel";
	private static final String LOOK_NIMBUS = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
	
	private final static Logger log = Logger.getLogger(Ventana.class);
	
	private JListWithImages registros;
	private JComboBox combo;
	private Cliente cliente;

	private JLabel userLogin;
	private JLabel serverHost;
	private JLabel serverPort;
	
	public Ventana(){
		
		cambiarLookAndFeel(LOOK_WINDOWS);
		
		setTitle("Cliente");
		setBounds(10, 10, 250, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		registros = new JListWithImages();
		cliente = new Cliente();
		cliente.addObserver(this);
		
		login();
		
		setListener();
		setLayout();
		
		combo.addItem("Conectado a 192.168.105.112");
		combo.addItem("Desconectar");

	}

	private void login(){
		try {
			cliente.login();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void setListener() {
		registros.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        doubleClickJList(evt);
		    }
		});
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				cerrar();
			}
		});
	}

	private void cerrar() {
		try {
			cliente.logout();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		
		JPanel superior = new JPanel(new BorderLayout());
		JLabel host = new JLabel("user:");
		superior.add(host,BorderLayout.NORTH);
		JLabel servidor = new JLabel("host:");
		superior.add(servidor,BorderLayout.SOUTH);
		
		JPanel inferior = new JPanel(new BorderLayout());
		inferior.setLayout(new BorderLayout());
		
		JPanel norte = new JPanel();
		norte.setBackground(Color.WHITE);
		norte.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel tituloLista = new JLabel("Lista de Contactos");
		Font newLabelFont = new Font(tituloLista.getFont().getName(),Font.BOLD,tituloLista.getFont().getSize());
		tituloLista.setFont(newLabelFont);
		norte.add(Box.createRigidArea(new Dimension(4,0)));
		norte.add(tituloLista);
		inferior.add(norte,BorderLayout.NORTH);
		inferior.add(registros, BorderLayout.CENTER);
		
		combo = new JComboBox();
		inferior.add(combo, BorderLayout.SOUTH);
		
		Container principal = getContentPane();
		principal.add(superior, BorderLayout.NORTH);
		principal.add(inferior, BorderLayout.CENTER);
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
	
	@Override
	public void update(Observable who, Object what) {
//		Cliente cliente = (Cliente) who;
//		List<Registro> conectados = new ArrayList<Registro>();
//		for (Contacto conectado : cliente.getContactos()) {
//			conectados.add(new Registro(conectado));
//		}
//		registros = new JListWithImages(conectados);
//		registros.repaint();
	}
	
	// ************************************************

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Ventana ventana = new Ventana();
		ventana.setVisible(true);
	}

//	private void mockRegistros() {
//		List<Registro> mocks = new ArrayList<Registro>();
//		mocks.add(new Registro(new Contacto(null, "Todos", "a todos los contactos")));
//		mocks.add(new Registro(new Contacto(true, "Pepe", "10.0.0.2")));
//		mocks.add(new Registro(new Contacto(true, "Pablo", "10.0.0.3")));
//		mocks.add(new Registro(new Contacto(false, "Ceci", "10.0.0.4")));
//		registros = new JListWithImages(mocks);
//	}
}