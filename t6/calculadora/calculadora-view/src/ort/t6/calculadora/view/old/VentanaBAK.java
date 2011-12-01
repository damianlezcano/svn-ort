package ort.t6.calculadora.view.old;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaBAK extends JFrame /*implements ActionListener*/ {

	public VentanaBAK(){
		this.setTitle("Titulo");
		
		//Otra fomra de hacerlo, solo para JFrame
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Jframe utiliza ContenPane como contenedor principal.
		
		this.setLocation(100,200);
		this.setSize(400,400);
		
		//Con set Bounds se hace puede ubicar y size
		//setBounds(100,20,400,400);
		
		//this.setLayout(null); //Al ponerlo en null se puede ubicar con pixeles
		this.setLayout(new BorderLayout());
		
		JPanel top = new JPanel();
		top.setBackground(Color.RED);
		this.add(top,BorderLayout.NORTH);
		
		top.setLayout(null);
		top.setPreferredSize(new Dimension(100,60));//
		
		JButton button1 = new JButton();
		button1.setText("Click 1");
		button1.setBounds(10,30,120,22);
		//button1.addActionListener(this); //cuando se implementa actionLisener en la clase
		button1.addActionListener(new ClickBoton1());//Para innerClass
		top.add(button1);//Agrego al contenedor

		JButton button2 = new JButton();
		button2.setText("Click 2");
		button2.setBounds(150,30,120,22);
		//button2.addActionListener(this); cuando se implementa actionLisener en la clase
		//button2.addActionListener(new ClickBoton2());//Para innerClass
		
		//Clase anonima, implementa ActionListener
		button2.addActionListener(new ActionListener(/*Es lo mismo que hacer class Object implement ActionListener*/) {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//Se puede llamar a clases locales como cerrar();
			}
		});
		
		top.add(button2);//Agrego al contenedor
		
		//Interfaces listener, se subcriben cuando ocurre un evento.
		this.addWindowListener(new CerrarVentana());
		
	}
	

//	@Override
//	public void actionPerformed(ActionEvent arg0) {
//		// TODO Auto-generated method stub
//		JButton btn = (JButton) arg0.getSource();
//		JOptionPane.showMessageDialog(this, "se hizo click" + btn.getText());
//	}
	
	private void cerrar(){
		System.exit(0);//Se indica a maquina virtual que finalice la aplicacion
	}
	
	class ClickBoton1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			JButton btn = (JButton) arg0.getSource();
			JOptionPane.showMessageDialog(VentanaBAK.this, "se hizo click" + btn.getText());
		}
	}
	
	class ClickBoton2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			JButton btn = (JButton) arg0.getSource();
			JOptionPane.showMessageDialog(VentanaBAK.this, "se hizo click" + btn.getText());
		}
	}
	
	/**
	 * eS una clase interna de Ventana.java
	 * Con extends WindowsAdapter se reescriben los metodos que se utilizan! 
	 * Generalmente se llaman igual que los Listener pero con Adapter.
	 * Los Adapter implementan los Listener pero vacios y uno las reimplementa!!
	 *
	 */
	public class CerrarVentana /*implements WindowListener*/ extends WindowAdapter {

//		@Override
//		public void windowActivated(WindowEvent arg0) {
//			// TODO Auto-generated method stub
//
//		}
//
//		@Override
//		public void windowClosed(WindowEvent arg0) {
//			// TODO Auto-generated method stub
//
//		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			// TODO Auto-generated method stub
			//System.exit(0);//Se indica a maquina virtual que finalice la aplicacion
			cerrar();
		}

//		@Override
//		public void windowDeactivated(WindowEvent arg0) {
//			// TODO Auto-generated method stub
//
//		}
//
//		@Override
//		public void windowDeiconified(WindowEvent arg0) {
//			// TODO Auto-generated method stub
//
//		}
//
//		@Override
//		public void windowIconified(WindowEvent arg0) {
//			// TODO Auto-generated method stub
//
//		}
//
//		@Override
//		public void windowOpened(WindowEvent arg0) {
//			// TODO Auto-generated method stub
//
//		}

	}


}
