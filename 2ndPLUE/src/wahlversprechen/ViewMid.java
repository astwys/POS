package wahlversprechen;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ViewMid extends JFrame {
	private JPanel panel1;
	
	private JTextArea schlagwort;
	private JTextArea beschreibung;
	private JTextArea ausrede;
	
	private JCheckBox aktiv;
	private JComboBox<String> comboB;
	
	public ViewMid() {
		// TODO Auto-generated constructor stub
		frame();
		components();
		setVisible(true);
	}
	
	public void frame() {
		setTitle("Neues Wahlversprechen");
//		setSize(370,550);
//		
//		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
//		int x=(int) (d.getWidth()/2-this.getWidth()/2)+40;
//		int y=(int) (d.getHeight()/2-this.getHeight()/2)+40;
//		setLocation(x, y);
		
		setBounds(0, 0, 370, 550);
		
		this.setResizable(false);
	}
	
	public void components() {
		panel1=new JPanel();
		
		schlagwort=new JTextArea(8,30);
		schlagwort.setLineWrap(true);
		panel1.add(new JLabel("Schlagwort: "));
		panel1.add(schlagwort);
		
		beschreibung=new JTextArea(8,30);
		beschreibung.setLineWrap(true);
		panel1.add(new JLabel("Beschreibung: "));
		panel1.add(beschreibung);
		
		aktiv=new JCheckBox();
		panel1.add(new JLabel("noch aktiv?"));
		panel1.add(aktiv);
		
		ausrede=new JTextArea(8,30);
		ausrede.setLineWrap(true);
		panel1.add(new JLabel("Ausrede: "));
		panel1.add(ausrede);
		
		this.add(panel1);
	}

}
