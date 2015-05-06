package wahlversprechen;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ViewEntfernen extends JFrame{
	private JPanel panel1;
	
	private JOptionPane optionP;
	
	private JButton abbrechen;
	
	private ControllerEntfernen contE;
	
	public ViewEntfernen() {
		// TODO Auto-generated constructor stub
		contE=new ControllerEntfernen(this);
		frame();
		components();
		setVisible(true);
	}
	
	public void frame() {
		setTitle("Wahlversprechen löschen");
		setSize(370, 200);
		
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int) (d.getWidth()/2-this.getWidth()/2);
		int y=(int) (d.getHeight()/2-this.getHeight()/2);
		setLocation(x, y);
		
		this.setResizable(false);
	}
	
	public void components() {
		panel1=new JPanel();
		
		optionP=new JOptionPane();
		panel1.add(optionP);
		
		abbrechen=new JButton("Abbrechen");
		abbrechen.addActionListener(contE);
		panel1.add(abbrechen);
		
		this.add(panel1);
	}
}
