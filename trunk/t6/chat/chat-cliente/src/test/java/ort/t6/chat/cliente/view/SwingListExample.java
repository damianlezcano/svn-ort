package ort.t6.chat.cliente.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SwingListExample extends JPanel {

	private BookEntry books[] = {
			new BookEntry("Ant: The Definitive Guide", "src/1.gif"),
			new BookEntry("Database Programming with JDBC and Java", "src/2.gif"),
			new BookEntry("Developing Java Beans", "src/3.gif"),
			new BookEntry("Developing JSP Custom Tag Libraries", "src/4.gif"),
			new BookEntry("Java 2D Graphics", "src/4.gif"),
			new BookEntry("Java and XML", "src/5.gif"),
			new BookEntry("Java and XSLT", "src/1.gif"),
			new BookEntry("Java and SOAP", "src/2.gif"),
			new BookEntry("Learning Java", "src/3.gif") };

	private JList booklist;

	public SwingListExample() {
		setLayout(new BorderLayout());
		JButton button = new JButton("Print");
		button.addActionListener(new PrintListener());

		booklist = new JList(books);
		booklist.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				System.out.println(e.toString());
			}
		});
		booklist.setCellRenderer(new BookCellRenderer());
		booklist.setVisibleRowCount(4);
		JScrollPane pane = new JScrollPane(booklist);

		add(pane, BorderLayout.NORTH);
		add(button, BorderLayout.SOUTH);
	}

	public static void main(String s[]) {
		JFrame frame = new JFrame("List Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new SwingListExample());
		frame.pack();
		frame.setVisible(true);
	}

	// An inner class to respond to clicks on the Print button
	class PrintListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int selected[] = booklist.getSelectedIndices();
			System.out.println("Selected Elements:  ");

			for (int i = 0; i < selected.length; i++) {
				BookEntry element = (BookEntry) booklist.getModel()
						.getElementAt(selected[i]);
				System.out.println("  " + element.getTitle());
			}
		}
	}
}

//********************************************************************************

class BookEntry {

	private final String title;
	private final String imagePath;
	private ImageIcon image;

	public BookEntry(String title, String imagePath) {
		this.title = title;
		this.imagePath = imagePath;
	}

	public String getTitle() {
		return title;
	}

	public ImageIcon getImage() {
		if (image == null) {
			image = new ImageIcon(imagePath);
		}
		return image;
	}

	// Override standard toString method to give a useful result
	public String toString() {
		return title;
	}
}


class BookCellRenderer extends JPanel implements ListCellRenderer {

	private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

	public BookCellRenderer() {
		setOpaque(true);
		//setIconTextGap(12);
	}

	public Component getListCellRendererComponent(JList list, Object value,	int index, boolean isSelected, boolean cellHasFocus) {
		BookEntry entry = (BookEntry) value;
	    
	    this.setLayout(new BorderLayout());
	    add(new JButton("ss"),BorderLayout.WEST);
		add(new JLabel(entry.getTitle()),BorderLayout.CENTER);
		//setText(entry.getTitle());
		//setIcon(entry.getImage());
		if (isSelected) {
			setBackground(Color.GRAY);
//			setForeground(Color.white);
		} else {
			setBackground(Color.white);
//			setForeground(Color.black);
		}
		return this;
	}
}