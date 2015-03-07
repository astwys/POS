package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View extends JFrame{
	private JPanel panel1;

	private JCheckBox checkbox;
	private JTextField anzahlMitarbeiter;
	private JTextArea mitarbeiter;
	private JScrollPane scroll;
	
	public View() {
		initFrame();
		initComponents();
		setVisible(true);
	}

	private void initFrame() {
		setTitle("Hauptfenster");
		setSize(650, 500);

		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int) (d.getWidth()/2-this.getWidth()/2);
		int y=(int) (d.getHeight()/2-this.getHeight()/2);
		setLocation(x,y);

		this.setResizable(false);
	}

	private void initComponents() {
		panel1=new JPanel();

		checkbox=new JCheckBox();

		anzahlMitarbeiter=new JTextField(); anzahlMitarbeiter.setPreferredSize(new Dimension(200,20)); anzahlMitarbeiter.setEditable(false);

		mitarbeiter=new JTextArea(20,50); mitarbeiter.setLineWrap(true);

		scroll=new JScrollPane(mitarbeiter, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		panel1.add(new JLabel("nur Abteilungsleiter anzeigen:"));
		panel1.add(checkbox);
		panel1.add(new JLabel("Gesmatanzahl aller Mitarbeiter: "));
		panel1.add(anzahlMitarbeiter);

		panel1.add(scroll);
		
		this.add(panel1);
	}
}
