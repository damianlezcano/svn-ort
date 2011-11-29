package ort.t6.chat.cliente.view;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListCellRenderer;


public class JListWithImages extends JList {

	private static final long serialVersionUID = 3624455291440957474L;

	public JListWithImages() {
		setCellRenderer(new CustomCellRenderer());
	}

	@SuppressWarnings({"unchecked"})
	public JListWithImages(List<Registro> registros) {
		this();
		Vector vector = new Vector();
		for (Registro registro : registros) {
			vector.addElement(registro);
		}
		setListData(vector);
	}
	
	//InnerClass para el tratamiento de registros
	class CustomCellRenderer implements ListCellRenderer {
		public Component getListCellRendererComponent(JList list, Object value,	int index, boolean isSelected, boolean cellHasFocus) {

			Color resaltado = new Color(223,230,243);
			Registro component = (Registro) value;

			if(isSelected){
				component.getPanel().setBackground(resaltado);
				component.setBackground(resaltado);
				component.getIp().setForeground(Color.BLUE);
			}else{
				component.getPanel().setBackground(Color.WHITE);
				component.setBackground(Color.WHITE);
				component.getIp().setForeground(Color.GRAY);
			}
			
			return component;
		}
	}
}