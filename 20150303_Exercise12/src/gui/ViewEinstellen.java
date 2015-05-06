package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.print.attribute.standard.JobName;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.Angestellter;
import data.Mitarbeiter;

public class ViewEinstellen extends JFrame {
	private JTextField name;
	private JTextField sozNr;
	private JTextField gehalt;
	private JButton abbrechen;
	private JButton speichern;
	private JLabel label;
	private JPanel haupt;
	private JPanel mitte;
	private JPanel sued;
	
	private Controller ctrl;
	
	public ViewEinstellen(Controller ctrl) {
		this.ctrl=ctrl;
		// TODO Auto-generated constructor stub
		setTitle("Einstellen");
		setBounds(10, 10, 300, 500);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		components();
		setVisible(true);
	}
	
	public void components() {
//		haupt =new JPanel(); 
//		haupt.setLayout(new BorderLayout());
		mitte=new JPanel();
		sued=new JPanel();
		
		mitte.setLayout(new GridLayout(3,2));
		
		label=new JLabel("name: ");
		mitte.add(label);
		
		name=new JTextField(20);
		mitte.add(name);
		
		label=new JLabel("sozialversicherungsnummer: ");
		mitte.add(label);
		
		sozNr=new JTextField(20);
		mitte.add(sozNr);
		
		label=new JLabel("Gehalt: ");
		mitte.add(label);
		
		gehalt=new JTextField();
		mitte.add(gehalt);
		
		abbrechen=new JButton("Abbrechen");
		abbrechen.addActionListener(ctrl);
		sued.add(abbrechen);
		
		speichern=new JButton("Annehmen");
		speichern.addActionListener(ctrl);
		sued.add(speichern);
	
		this.add(mitte, BorderLayout.CENTER);
		this.add(sued, BorderLayout.SOUTH);
	}
	
	public Angestellter speichern() {
		return new Angestellter(name.getText(), sozNr.getText(), Float.parseFloat(gehalt.getText())){
		};
	}
}
