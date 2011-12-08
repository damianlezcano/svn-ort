package ort.t6.chat.cliente.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ort.t6.chat.cliente.lib.Cliente;
import ort.t6.chat.model.Contacto;
import ort.t6.chat.model.mensaje.Mensaje;

public class Conversacion extends JDialog {
	
	private static final long serialVersionUID = 6797375643842902194L;
	private JTextArea mensajes;
	private JTextField texto;
	
	private List<Contacto> destinatarios;
	private Cliente cliente;
	
	private final static String newline = "\n";
	
	public Conversacion(JFrame parent, List<Contacto> contactos, Cliente cliente) {
		super(parent, "Conversando con el grupo", false);
		init(cliente);

		this.destinatarios = contactos;
		mensajes.setBackground(new Color(249,225,225));
	}
	
	public Conversacion(JFrame parent, Contacto contacto, Cliente cliente) {
		super(parent, "Conversando con " + contacto.getNick(), false);
		init(cliente);

		List<Contacto> destinatario = new ArrayList<Contacto>();
		if(contacto.getEstado() != null){
			destinatario.add(contacto);
		}
		this.destinatarios = destinatario;
		mensajes.setBackground(new Color(253,255,221));
	}

	private void init(Cliente cliente){
		this.cliente = cliente;
		
		JPanel container = (JPanel) getContentPane();
		setBounds(0, 0, 300, 200);
		
		container.setLayout(new BorderLayout());
		mensajes = new JTextArea();
		mensajes.setFocusable(false);
		
		JScrollPane scroll = new JScrollPane(mensajes);
		container.add(scroll, BorderLayout.CENTER);
		
		JPanel panelEnvio = new JPanel();
		panelEnvio.setLayout(new BorderLayout());
		
		texto = new JTextField();
		texto.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					enviar();
				}
			}
		});
		panelEnvio.add(texto, BorderLayout.CENTER);
		
		JButton envio = new JButton("Enviar");
		envio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				enviar();
			}
		});
		panelEnvio.add(envio, BorderLayout.EAST);
		container.add(panelEnvio,BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	private void enviar(){
		try {
			Mensaje mensaje = new Mensaje();
			mensaje.setTexto(texto.getText());
			cliente.send(destinatarios, mensaje);
			refrescarHistorial();
			texto.setText(null);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void refrescarHistorial(){
		if(destinatarios.size() == 1){
			mensajes.setText(null);
			List<Mensaje> historico = cliente.mensajesDelContacto(destinatarios.get(0));
			for (Mensaje mensaje : historico) {
				mensaje.setLeido(true);
				mensajes.append(mensaje.getTexto() + newline);
			}
		}
	}

}