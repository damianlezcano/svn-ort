package ort.t6.chat.cliente.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class CustomCellRenderer implements ListCellRenderer {
	public Component getListCellRendererComponent(JList list, Object value,	int index, boolean isSelected, boolean cellHasFocus) {

		Color resaltado = new Color(223,230,243);
		Registro registro = (Registro) value;

		if(isSelected){
			registro.getPanel().setBackground(resaltado);
			registro.setBackground(resaltado);
			registro.getIp().setForeground(Color.BLUE);
		}else{
			registro.getPanel().setBackground(Color.WHITE);
			registro.setBackground(Color.WHITE);
			registro.getIp().setForeground(Color.GRAY);
		}
		
		return registro;
	}
}