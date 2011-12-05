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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

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
import ort.t6.chat.model.mensaje.Mensaje;

public class Ventana extends JFrame implements Observer {

	private static final long serialVersionUID = -3345896499252067716L;

	private final static Logger log = Logger.getLogger(Ventana.class);
	
	private static final String LOOK_GTK = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
	private static final String LOOK_WINDOWS = "java.awt.swing.plaf.windows.WindowsLookAndFeel";
	private static final String LOOK_NIMBUS = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
	
	private static String USER_NAME = "desktop2";
	private static final String SERVER_IP = "localhost";
	private static final Integer SERVER_PORT = 4000;
	
	private JList listadoRegistros;
	private JComboBox combo;
	private Cliente cliente;
	
	private Map<Contacto,Conversacion> conversacionesAbiertas;
	
	public Ventana(){
		Random r=new Random();
		r.setSeed(123456789);
		USER_NAME = "Usuario " + new GregorianCalendar().get(Calendar.SECOND);
		
		cambiarLookAndFeel(LOOK_NIMBUS);
		
		setTitle("Cliente: " + USER_NAME);
		setBounds(10, 10, 250, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		init();
		setListener();
		setLayout();
		
		cliente = new Cliente();
		cliente.addObserver(this);
		
		cargarComboEstados();
	}

	public void init(){
		combo = new JComboBox();
		listadoRegistros = new JList();
		conversacionesAbiertas = new HashMap<Contacto, Conversacion>();
	}
	
	private void cargarComboEstados(){
		combo.addItem("Conectado a " + SERVER_IP + ":" + SERVER_PORT);
		combo.addItem("Desconectar");
	}
	
	private void login(){
		try {
			cliente.login(USER_NAME,SERVER_IP,SERVER_PORT);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void setListener() {
		listadoRegistros.addMouseListener(new MouseAdapter() {
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
		
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//            	JComboBox combo = (JComboBox) evt.getSource();
//            	String seleccion = (String) combo.getSelectedItem();
//            	log.info("Cambio el combo de estado a " + seleccion);
//                if(!seleccion.contentEquals("Desconectar")){
//                	login();
//                }else{
//                	cerrar();
//                }
            }
        });
		
	}

	private void setLayout() {
		JPanel superior = new JPanel(new BorderLayout());
		
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
		inferior.add(listadoRegistros, BorderLayout.CENTER);
		
		inferior.add(combo, BorderLayout.SOUTH);
		
		Container principal = getContentPane();
		principal.add(superior, BorderLayout.NORTH);
		principal.add(inferior, BorderLayout.CENTER);
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
	
	private void doubleClickJList(MouseEvent evt) {
		JList list = (JList)evt.getSource();
        if (evt.getClickCount() == 2) { // Double-click
        	Registro registro = (Registro)list.getSelectedValue();
        	Contacto contacto = registro.getContacto();
        	if(contacto.getEstado() == null || contacto.getEstado()){
        		Conversacion conversacion = null;
        		if(conversacionesAbiertas.containsKey(contacto)){
        			conversacion = conversacionesAbiertas.get(contacto);
        			conversacion.refrescarHistorial();
        		}else{
        			conversacion = new Conversacion(this, contacto, cliente);
        			conversacionesAbiertas.put(contacto, conversacion);
        		}
        		conversacion.setVisible(true);
        	}
        }
	}
	
	@Override
	public void update(Observable who, Object what) {
		System.out.println("*** " + USER_NAME + " - size: " + cliente.contactosConectados().size());
		recargarListaDeContactos();
		recibirMensajesNuevos();
	}

	private void recibirMensajesNuevos(){
		for (Contacto contacto : cliente.contactosConectados()) {
			List<Mensaje> mensajes = cliente.mensajesDelContacto(contacto);
			for (Mensaje mensaje : mensajes) {
				if(!mensaje.getLeido()){
					Conversacion conversacion = conversacionesAbiertas.get(contacto);
					if(conversacion == null){
						conversacion = new Conversacion(this, contacto, cliente);
						conversacionesAbiertas.put(contacto, conversacion);
					}
					conversacion.refrescarHistorial();
					conversacion.setVisible(true);
				}
			}
		}
		
	}
	
	private void recargarListaDeContactos(){
		List<Registro> registros = new ArrayList<Registro>();
		for (Contacto contacto : cliente.contactosConectados()) {
			contacto.setEstado(true);
			registros.add(new Registro(contacto));
		}
		listadoRegistros.setListData(registros.toArray());
		listadoRegistros.setCellRenderer(new CustomCellRenderer());
	}
	
	// ************************************************

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Ventana ventana = new Ventana();
		ventana.setVisible(true);
		ventana.login();
	}

}