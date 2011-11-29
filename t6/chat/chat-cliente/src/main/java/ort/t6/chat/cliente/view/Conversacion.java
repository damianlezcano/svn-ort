package ort.t6.chat.cliente.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ort.t6.chat.model.Contacto;

public class Conversacion extends JDialog {
	
	private static final long serialVersionUID = 6797375643842902194L;
	private JTextArea mensajes;
	private JTextField texto;
	
	private final static String newline = "\n";
	
	public Conversacion(JFrame parent, Contacto contacto) {
		
		super(parent, "Conversando con " + contacto.getNick(), false);
		
		JPanel container = (JPanel) getContentPane();
		setBounds(0, 0, 300, 200);
		
		container.setLayout(new BorderLayout());
		mensajes = new JTextArea();
		mensajes.setFocusable(false);
		
		if(contacto.getEstado() == null){
			mensajes.setBackground(new Color(249,225,225));
		}else{
			mensajes.setBackground(new Color(253,255,221));
		}
		
		
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
		setVisible(true);
	}
	
	private void enviar(){
		mensajes.append("Yo: " + texto.getText() + newline);
		texto.setText(null);
	}

}