package ort.t6.chat.cliente.view;

import java.awt.Component;
import java.awt.Font;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class RenderLista extends JLabel implements ListCellRenderer {

	private Hashtable<Object, ImageIcon> elementos;
	private ImageIcon icononulo = new ImageIcon(this.getClass().getResource("/img/invisible.png"));

	public RenderLista() {
		elementos = new Hashtable<Object, ImageIcon>();
		ImageIcon icono1 = new ImageIcon(this.getClass().getResource("/img/available.png"));
		ImageIcon icono2 = new ImageIcon(this.getClass().getResource("/img/offline.png"));
		elementos.put("true", icono1);
		elementos.put("false", icono2);
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		if (elementos.get(value) != null) {
			setIcon(elementos.get(value));
			setText("" + value);
			if (isSelected) {
				setFont(new Font("Verdana", Font.BOLD, 16));
			} else {
				setFont(null);
			}
		} else {
			setIcon(icononulo);
			setText("" + value);
			if (isSelected) {
				setFont(new Font("Verdana", Font.BOLD, 16));
			} else {
				setFont(null);
			}
		}
		return this;
	}
}
