package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewSuchen extends JFrame {

	private JPanel mitte;
	private JPanel sued;
	
	private JTextField name;
	
	private JButton abbrechen;
	private JButton suchen;
	
	private JLabel label;
	
	private Controller ctrl;
	
	public ViewSuchen(Controller ctrl) {
		// TODO Auto-generated constructor stub
		this.ctrl=ctrl;
		setTitle("Suchen");
		setBounds(10, 10, 300, 200);
		setLayout(new BorderLayout());
		components();
		setVisible(true);
	}
	
	public void components() {
		mitte = new JPanel();
		sued = new JPanel();
		
		label= new JLabel("Name: ");
		mitte.add(label);
		name=new JTextField(20);
		mitte.add(name);
		
		abbrechen=new JButton("nicht suchen");
		abbrechen.addActionListener(ctrl);
		sued.add(abbrechen);
		
		suchen=new JButton("Jetzt Suchen");
		suchen.addActionListener(ctrl);
		sued.add(suchen);
		
		this.add(mitte, BorderLayout.CENTER);
		this.add(sued, BorderLayout.SOUTH);
		
	}
	
	public String returnName() {
		return name.getText();
	}
}
