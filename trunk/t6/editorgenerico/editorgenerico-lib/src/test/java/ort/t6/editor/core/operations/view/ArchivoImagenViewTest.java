package ort.t6.editor.core.operations.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;

import ort.t6.editor.core.operations.ArchivoImagen;

public class ArchivoImagenViewTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		ArchivoImagen archivo = new ArchivoImagen();
		JFrame frame = new JFrame();
		frame.setBounds(100,20,400,400);
		frame.add(archivo.getPanel());
		archivo.open("./src/test/resources/file.jpg");
		frame.setVisible(true);
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});	
		
	}
}