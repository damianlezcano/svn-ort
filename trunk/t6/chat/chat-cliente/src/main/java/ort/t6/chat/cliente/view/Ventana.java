package ort.t6.chat.cliente.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

import ort.t6.chat.cliente.lib.Cliente;
import ort.t6.chat.exception.UsuarioExistenteException;
import ort.t6.chat.model.Contacto;
import ort.t6.chat.model.mensaje.Mensaje;

public class Ventana extends JFrame implements Observer {

	private static final long serialVersionUID = -3345896499252067716L;

	private final static Logger log = Logger.getLogger(Ventana.class);
	
	private static final String LOOK_GTK = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
	private static final String LOOK_WINDOWS = "java.awt.swing.plaf.windows.WindowsLookAndFeel";
	private static final String LOOK_NIMBUS = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
	
	private JList listadoRegistros;
	private JComboBox combo;
	private Cliente cliente;
	
	private JTextField userLogin;
	private JTextField serverIp;
	private JTextField serverPort;
	private JButton botonConectar;
	
	private JPopupMenu menu;
	private JMenuItem menuItem;
	
	private Map<Contacto,Conversacion> conversacionesAbiertas;
	
	public Ventana(){
		init();
		cambiarLookAndFeel(LOOK_NIMBUS);
		setListener();
		setLayout();
	}

	public void init(){
		setTitle("Cliente");
		setBounds(10, 10, 250, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		combo = new JComboBox();
		listadoRegistros = new JList();
		conversacionesAbiertas = new HashMap<Contacto, Conversacion>();
		userLogin = new JTextField();
		serverIp = new JTextField();
		serverPort = new JTextField();
		botonConectar = new JButton("Conectar");
		
		userLogin.setText("pepe");
		serverIp.setText("localhost");
		serverPort.setText("4000");
		
		menu = new JPopupMenu();
		menuItem = new JMenuItem("Mandar mensaje al grupo");
		menu.add(menuItem);
		
		cliente = new Cliente();
		cliente.addObserver(this);
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
	
	private void setListener() {
		listadoRegistros.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        conversarConContacto(evt);
		    }
		});
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				salir();
			}
		});
		
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	JComboBox combo = (JComboBox) evt.getSource();
            	String seleccion = (String) combo.getSelectedItem();
            	if(seleccion != null) cambiarEstado(seleccion);
            }
        });
        
		botonConectar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				conectar();
			}
		});
		
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				for (Object obj : listadoRegistros.getSelectedValues()) {
//					System.out.println("Elemento: " + ((String)obj));
//				}
				conversarConGrupo(e);
			}
		});

		listadoRegistros.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mostrarMenu(e);
			}
		});
	}

	private void setLayout() {
		//Panel 1 para la conexion
		JPanel panel1 = new JPanel(new BorderLayout());
		JPanel superior = new JPanel(new GridLayout(3, 2, 10, 0));
		superior.add(new JLabel("Nombre de Usuario"));
		superior.add(userLogin);
		superior.add(new JLabel("IP del Servidor"));
		superior.add(serverIp);
		superior.add(new JLabel("Puerto"));
		superior.add(serverPort);
		panel1.add(new JLabel(new ImageIcon("./src/main/resources/img/login.png")), BorderLayout.NORTH);
		panel1.add(superior, BorderLayout.CENTER);
		panel1.add(botonConectar, BorderLayout.SOUTH);		
		
		//Panel 2 para la lista de conectados
		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.setLayout(new BorderLayout());
		JPanel norte = new JPanel();
		norte.setBackground(Color.WHITE);
		norte.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel tituloLista = new JLabel("Lista de Contactos");
		Font newLabelFont = new Font(tituloLista.getFont().getName(),Font.BOLD,tituloLista.getFont().getSize());
		tituloLista.setFont(newLabelFont);
		norte.add(Box.createRigidArea(new Dimension(4,0)));
		norte.add(tituloLista);
		panel2.add(norte,BorderLayout.NORTH);
		panel2.add(listadoRegistros, BorderLayout.CENTER);
		panel2.add(combo, BorderLayout.SOUTH);
		
		Container container = getContentPane();
		container.setLayout(new CardLayout());
		container.add("login",panel1);
		container.add("listado",panel2);
	}

	//********************************************************
	// 
	//********************************************************
	
	private void mostrarMenu(MouseEvent e) {
		Integer size = listadoRegistros.getSelectedValues().length;
		if (size > 1) {
			if (e.getButton() == e.BUTTON3) {
				menu.show(e.getComponent(), e.getX(), e.getY());
			}
		}
	}
	
	private void cambiarEstado(String seleccion){
    	log.info("Cambio el combo de estado a " + seleccion);
        if(seleccion.equalsIgnoreCase("Desconectar")){
        	try {
				cliente.logout();
				CardLayout layout = (CardLayout) getContentPane().getLayout();
				layout.previous(getContentPane());
			} catch (IOException e) {
				log.info("Error al cambiar de estado - Desconectar");
			}
        }
	}
	
	private void conversarConContacto(MouseEvent evt) {
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
	
	private void conversarConGrupo(ActionEvent e){
		List<Contacto> destinatarios = new ArrayList<Contacto>();
		List registrosSeleccionados = Arrays.asList(listadoRegistros.getSelectedValues());
		for (Object obj : registrosSeleccionados) {
			destinatarios.add(((Registro)obj).getContacto());
		}
		Conversacion conversacion = new Conversacion(this, destinatarios, cliente);
		conversacion.setVisible(true);
	}
	
	@Override
	public void update(Observable who, Object what) {
		if(!cliente.getEstadoConexion()){
			recargarListaDeContactos();
			recibirMensajesNuevos();
		}else{
			CardLayout layout = (CardLayout) getContentPane().getLayout();
			layout.previous(getContentPane());
		}
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
	
	private void cargarComboEstados(){
		combo.removeAllItems();
		combo.addItem("Conectado a " + serverIp.getText() + " : " + serverPort.getText());
		combo.addItem("Desconectar");
	}
	
	private void recargarListaDeContactos(){
		List<Registro> registros = new ArrayList<Registro>();
		registros.add(new Registro(new Contacto(null,"Todos los contactos",serverIp.getText())));
		for (Contacto contacto : cliente.contactosConectados()) {
			registros.add(new Registro(contacto));
		}
		listadoRegistros.setListData(registros.toArray());
		listadoRegistros.setCellRenderer(new CustomCellRenderer());
	}
	
	private void conectar(){
		String name = userLogin.getText();
		String ip = serverIp.getText();
		Integer port = Integer.valueOf(serverPort.getText());
		CardLayout layout = (CardLayout) getContentPane().getLayout();
		try {
			cliente.login(name,ip,port);
			cargarComboEstados();
			setTitle("Usuario: " + name);
			layout.next(getContentPane());
		} catch (ConnectException e){
			aviso("El servidor no esta disponible");
		} catch (UsuarioExistenteException e){
			aviso(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void salir() {
		try {
			cliente.logout();
		} catch (IOException e) {
			log.info("Error al salir de la aplicacion");
		} finally {
			System.exit(0);//Se indica a maquina virtual que finalice la aplicacion
		}
	}
	
	private void aviso(String mensaje){
		JOptionPane.showMessageDialog(this,mensaje);
	}
	
	// ************************************************

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Ventana ventana = new Ventana();
		ventana.setVisible(true);
	}

}