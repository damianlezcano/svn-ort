package ort.t6.editor.core.operations;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;

public class ArchivoTexto extends ArchivoEditable {

	private final static Logger log = Logger.getLogger(ArchivoTexto.class);
	private JTextArea textArea;

	FileInputStream entrada;
	FileOutputStream salida;
	
	public ArchivoTexto(){
		super();
		this.textArea = new JTextArea();
		textArea.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                onChangeTextArea();
            }
        });
		this.getPanel().add(textArea);
	}

	@Override
	public void open(String filename) throws FileNotFoundException, IOException {
		log.info("Abrir archivo de texto");
		entrada = new FileInputStream(filename);
		StringBuffer sb = new StringBuffer();
		
		byte[] buffer = new byte[256];
		int leidos;
		while ((leidos = entrada.read(buffer)) > 0) {
			sb.append(new String(buffer, 0, leidos));
		}
		
		textArea.setText(sb.toString());
		notificar();
	}

	@Override
	public void save() throws IOException {
		log.info("Guardar archivo de texto");

		salida = new FileOutputStream("prueba.txt");
		byte[] buffer = new byte[256];
		int len;
		while ((len = entrada.read(buffer)) > 0) {
			salida.write(buffer, 0, len);
		}

		this.setModified(false);
		notificar();
	}

	@Override
	public void close() {
		log.info("Cerrar archivo de texto");
		notificar();
	}
	
	private void onChangeTextArea() {
		this.setModified(true);
	}
}