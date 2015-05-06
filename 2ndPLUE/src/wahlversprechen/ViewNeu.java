package wahlversprechen;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

public class ViewNeu extends JFrame {
	private JPanel mainP;
	
	private JButton speichern;
	private JButton abbrechen;
	
	private ControllerNeu contN;
	private ViewMid viewM;
	
	public ViewNeu() {
		// TODO Auto-generated constructor stub
//		contN=new ControllerNeu(this);
		frame();
		components();
		setVisible(true);
	}
	
	public void frame() {
		setTitle("Neues Wahlversprechen");
		setSize(370,550);
		
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int) (d.getWidth()/2-this.getWidth()/2)+40;
		int y=(int) (d.getHeight()/2-this.getHeight()/2)+40;
		setLocation(x, y);
		
		this.setResizable(false);
	}
	
	public void components() {
		mainP=new JPanel();
		mainP.setLayout(new BorderLayout());
		JPanel sued=new JPanel();
		
		viewM=new ViewMid();
		
		abbrechen=new JButton("Abbrechen");
		abbrechen.addActionListener(contN);
		sued.add(abbrechen);
		
		speichern=new JButton("Speichern");
		speichern.addActionListener(contN);
		sued.add(speichern);
		
		this.add(viewM, BorderLayout.CENTER);
		this.add(sued, BorderLayout.SOUTH);
	}

	public JTextComponent getSchlagwort() {
		// TODO Auto-generated method stub
		return null;
	}

	public JTextComponent getBeschreibung() {
		// TODO Auto-generated method stub
		return null;
	}

	public JTextComponent getAusrede() {
		// TODO Auto-generated method stub
		return null;
	}
}