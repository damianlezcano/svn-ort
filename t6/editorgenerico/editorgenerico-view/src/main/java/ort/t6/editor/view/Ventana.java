package ort.t6.editor.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import ort.t6.editor.core.factory.FabricaArchivos;
import ort.t6.editor.core.operations.ArchivoEditable;
import ort.t6.editor.core.operations.ArchivoTexto;

public class Ventana extends JFrame implements Observer {

	private static final long serialVersionUID = 6090183255147166404L;
	private final static Logger log = Logger.getLogger(ArchivoTexto.class);

	private static final String NOMBRE_VENTANA = "Editor Generico";
	
	private ArchivoEditable archivoEditable;
	
	private PanelNorte norte;
	private PanelSur sur;
	
	public Ventana(){
		super();
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setTitle(NOMBRE_VENTANA);
		
		//Con set Bounds se hace puede ubicar y size
		setBounds(100,20,600,600);
		
		setLayouts();
		setListeners();
	}
	
	/**
	 * Se construye la interfaz grafica
	 */
	private void setLayouts(){
		getContentPane().setLayout(new BorderLayout(5,5));
		
		sur = new PanelSur();
		getContentPane().add(sur,BorderLayout.SOUTH);

		norte = new PanelNorte();
		getContentPane().add(norte,BorderLayout.NORTH);
		
		getContentPane().add(new PanelCentral(),BorderLayout.CENTER);
	}

	/**
	 * Se especifican los manejadores de eventos en la aplicacion
	 */
	private void setListeners(){
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				cerrar();
			}
		});
		
		norte.getAbrir().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abrir();
			}
		});
		
		norte.getGuardar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		
		norte.getCerrar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}
		});
	}

	@Override
	public void update(Observable who, Object what) {
		ArchivoEditable c = (ArchivoEditable) who;

		if(c.isModified()){
			norte.getGuardar().setEnabled(true);
		}else{
			norte.getGuardar().setEnabled(false);
		}
		
		norte.getCerrar().setEnabled(true);
	}
	
	//************************************************************************
	
	private void abrir() {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);

		if(archivoEditable != null && archivoEditable.isModified()){
			if(pregunta(false) == JOptionPane.CANCEL_OPTION){
				return;
			}
		}
		
		if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			log.info("Abrir archivo");
			
			String fullpath = fileChooser.getSelectedFile().getPath();
			String nombreArchivo = fileChooser.getSelectedFile().getName();
			String formato = formato(nombreArchivo);
			ArchivoEditable editor = FabricaArchivos.getInstance().crearVista(formato);
			
			if(editor == null){ //Si no existe editor para ese tipo de formato
				archivoEditable = null;
				norte.getDireccion().setText(null);
				norte.getCerrar().setEnabled(false);
				getContentPane().add(new PanelCentral(),BorderLayout.CENTER);
				sur.cambiarMensaje(PanelSur.MENSAJE_ERROR_FORMATO, Color.RED);
			}else{
				archivoEditable = editor;
				archivoEditable.addObserver(this);
				try {
					archivoEditable.open(fullpath);
					norte.getDireccion().setText(fullpath);
					norte.getCerrar().setEnabled(true);
					getContentPane().add(archivoEditable.getPanel(),BorderLayout.CENTER);
					sur.cambiarMensaje(PanelSur.MENSAJE_EXITO, Color.GREEN);
				} catch (FileNotFoundException e) {
					log.error("Error al abrir el archivo FileNotFoundException");
					sur.cambiarMensaje("El archivo que intenta abrir no existe", Color.RED);
				} catch (IOException e) {
					log.error("Error al abrir el archivo IOException");
				}
			}
		}
	}

	private void guardar() {
		log.info("Guardar archivo");
		try {
			archivoEditable.save();
		} catch (IOException e) {
			log.error("Error al guardar el archivo");
			sur.cambiarMensaje("Error al guardar el archivo",Color.RED);
		}
	}
	
	private void cerrar(){
		if(archivoEditable != null && archivoEditable.isModified()){
			pregunta(true);
		}else{
			System.exit(0);
		}
	}
	
	private Integer pregunta(Boolean salir){
		Integer seleccion = JOptionPane.showOptionDialog(this,
				"Se realizaron cambios, ¿desea guardarlos?",
				"Selector de opciones", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, // null para icono por defecto.
				new Object[] { "Si", "No", "Cancelar" }, null);
		
		switch (seleccion) {
		case JOptionPane.YES_OPTION: //SI
			try {
				archivoEditable.save();
				archivoEditable.close();
				norte.getDireccion().setText(null);
				norte.getGuardar().setEnabled(false);
				norte.getCerrar().setEnabled(false);
				if (salir){
					System.exit(0);
				}
			} catch (IOException e) {
				log.error("Error al guardar archivo");
			}
			break;
		case JOptionPane.NO_OPTION: //NO
			archivoEditable.close();
			norte.getDireccion().setText(null);
			norte.getGuardar().setEnabled(false);
			norte.getCerrar().setEnabled(false);
			if (salir){
				System.exit(0);
			}
			break;
		}
		return seleccion;
	}
	
	private String formato(String nombreArchivo){
		try {
			String[] archivo = nombreArchivo.split("\\.");
			return archivo[1];
		} catch (ArrayIndexOutOfBoundsException e) {
			return nombreArchivo;
		}
	}
}