package ort.t6.chat.cliente.view;
import java.awt.Color;
import java.awt.Component;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class JListWithImagesOriginal extends JList {

	private static final long serialVersionUID = 2100670110870691697L;

	public JListWithImagesOriginal() {
		setCellRenderer(new CustomCellRenderer());
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		Vector vector = new Vector();
		//panel.setForeground(Color.black);
		//panel.setBackground(Color.white);

		//layout
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
	
		
		// first line
		JPanel jp1 = new JPanel();
		jp1.add(new JLabel(new ImageIcon("src/1.gif")));
		jp1.add(new JLabel("A line for Gumby"));

		// second line
		JPanel jp2 = new JPanel();
		jp2.add(new JLabel(new ImageIcon("src/2.gif")));
		jp2.add(new JLabel("Another line for Gumby"));

		vector.addElement(jp1);
		vector.addElement(jp2);

		JListWithImages jlwi = new JListWithImages();
		jlwi.setListData(vector);

		panel.add(jlwi);
		frame.getContentPane().add(panel);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	class CustomCellRenderer implements ListCellRenderer {
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			Component component = (Component) value;
			component.setBackground(isSelected ? Color.gray : Color.white);
			//component.setForeground(isSelected ? Color.white : Color.black);
			return component;
		}
	}
}