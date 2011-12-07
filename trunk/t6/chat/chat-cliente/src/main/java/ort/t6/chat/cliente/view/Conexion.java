package ort.t6.chat.cliente.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ort.t6.chat.cliente.lib.Cliente;

public class Conexion extends JDialog {
	
	private static final long serialVersionUID = 2098516089799113124L;

	private JTextField userLogin;
	private JTextField serverIp;
	private JTextField serverPort;
	
	private Cliente cliente;
	
	public void init(){
		userLogin = new JTextField();
		serverIp = new JTextField();
		serverPort = new JTextField();
	}
	
	public Conexion(JFrame parent, Cliente cliente) {
		super(parent, "Conectar con el servidor ", false);
		init();
		this.cliente = cliente;
		
		JPanel container = (JPanel) getContentPane();
		setBounds(0, 0, 300, 200);
		
		container.setLayout(new BorderLayout());

		JPanel superior = new JPanel(new GridLayout(3, 2, 0, 0));
		superior.add(new JLabel("Nombre de Usuario"));
		superior.add(userLogin);
		superior.add(new JLabel("IP del Servidor"));
		superior.add(serverIp);
		superior.add(new JLabel("Puerto"));
		superior.add(serverPort);
		
		JButton botonConectar = new JButton("Conectar");
		botonConectar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				conectar();
			}
		});
		
		container.add(superior, BorderLayout.CENTER);
		container.add(botonConectar, BorderLayout.SOUTH);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	private void conectar(){
		String name = userLogin.getText();
		String ip = serverIp.getText();
		Integer port = Integer.valueOf(serverPort.getText());
		try {
			cliente.login(name,ip,port);
			this.dispose();
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(this,"El servidor no esta disponible");
		} catch (ConnectException e){
			JOptionPane.showMessageDialog(this,"El servidor no esta disponible");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}