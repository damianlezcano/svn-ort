package ort.t6.chat.cliente.view;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class Principal extends JFrame {

	 private JList lista;
	 
	 public Principal(){
		 setBounds(300,300,300,300);
		 setVisible(true);
	 }
	 
	 public void init(){
	  JPanel panel = new JPanel();
	  
	  lista=new JList();
	  Object datos[]=new Object[4];
	  datos[0]="Elemento 1";
	  datos[1]="Elemento 2";
	  datos[2]="Java Zone";
	  datos[3]="Elemento 3";
	  lista.setListData(datos);
	  
	  RenderLista rl=new RenderLista();
	  
	  lista.setCellRenderer(rl);
	  
	  getContentPane().add(lista);
	 }
	 
	 public static void main(String[] args) {
		Principal principal = new Principal();
		principal.init();
	}
}