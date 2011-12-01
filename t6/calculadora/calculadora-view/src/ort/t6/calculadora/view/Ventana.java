package ort.t6.calculadora.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ort.t6.calculadora.core.modelo.Calculadora;

public class Ventana extends JFrame implements Observer {

	public static final String NOMBRE_VENTANA = "Calculadora";
	private Calculadora calculadora;
	
	private PanelCentral center;
	private PanelNorte norte;
	private PanelEste este;
	
	public Ventana(){
		super();
		this.setTitle(NOMBRE_VENTANA);
		
		calculadora = new Calculadora();
		calculadora.addObserver(this);

		//Con set Bounds se hace puede ubicar y size
		setBounds(100,20,400,400);
		
		setLayouts();
		setListeners();
	}
	
	/**
	 * Se construye la interfaz grafica
	 */
	private void setLayouts(){
		JPanel principal = new JPanel();
		principal.setLayout(new BorderLayout(10, 10));
//		principal.setBackground(Color.RED);
		
		center = new PanelCentral(calculadora);
		principal.add(center,BorderLayout.CENTER);
		
		norte = new PanelNorte(calculadora);
		principal.add(norte,BorderLayout.NORTH);
		
		este = new PanelEste(calculadora);
		principal.add(este,BorderLayout.EAST);
		
		add(principal);
		
	}
	
	/**
	 * Se especifican los eventos de la aplicacion
	 */
	private void setListeners(){
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				cerrar();
			}
		});		
	}
	
	
	
	
	
	private void cerrar(){
		System.exit(0);//Se indica a maquina virtual que finalice la aplicacion
	}

	@Override
	public void update(Observable who, Object what) {
		Calculadora c = (Calculadora) who;
		//System.out.println(" : total acual es " + c.getTotal());
		Double total = c.getTotal();
		norte.getResultado().setText(total.toString());
	}
}