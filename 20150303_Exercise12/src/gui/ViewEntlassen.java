package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ViewEntlassen extends JFrame {

	private JTextField sozNr;
	private JButton abbrechen;
	private JButton entlassen;
	
	private JPanel mitte;
	private JPanel sued;
	
	private JLabel label;
	
	private Controller ctrl;
	
	public ViewEntlassen(Controller ctrl) {
		// TODO Auto-generated constructor stub
		this.ctrl=ctrl;
		setTitle("Entlassen");
		setBounds(10, 10, 300, 200);
		setLayout(new BorderLayout());
		components();
		setVisible(true);
	}
	
	public void components() {
		mitte=new JPanel();
		sued=new JPanel();
		
		label=new JLabel("Sozialversicherungsnummer: ");
		mitte.add(label);
		sozNr = new JTextField(20);
		mitte.add(sozNr);
		
		abbrechen=new JButton("Nicht Entlassen");
		abbrechen.addActionListener(ctrl);
		sued.add(abbrechen);
		
		entlassen=new JButton("Jetzt entlassen");
		entlassen.addActionListener(ctrl);
		sued.add(entlassen);
		
		this.add(mitte, BorderLayout.CENTER);
		this.add(sued, BorderLayout.SOUTH);
	}
	
	public String sozNrEntlassen() {
		return sozNr.getText();
	}
}
