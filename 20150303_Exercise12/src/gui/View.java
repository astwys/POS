package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import data.CompanyException;

public class View extends JFrame{
	private JPanel panel1;

	public JCheckBox checkbox;
	public JTextField anzahlMitarbeiter;
	public JTextArea mitarbeiter;
	private JScrollPane scroll;
	
	private JMenuBar menuB;
	private JMenu menu;
	private JMenuItem menuI;
	
	private Controller controllerMenu;
	private Model model;
//	private ControllerData controllerData;
	
	public View() {
		controllerMenu = new Controller(this);
		this.model=new Model(this);
//		controllerData = new ControllerData(this);
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
		
		menuB = new JMenuBar();
		
		menu = new JMenu("Datei");
		menuB.add(menu);
		menuI = new JMenuItem("Laden");
		menuI.addActionListener(controllerMenu);
		menu.add(menuI);
		menuI = new JMenuItem("Speichern");
		menuI.addActionListener(controllerMenu);
		menu.add(menuI);
		
		menu = new JMenu("Mitarbeiter");
		menuB.add(menu);
		menuI = new JMenuItem("Einstellen");
		menuI.addActionListener(controllerMenu);
		menu.add(menuI);
		menuI = new JMenuItem("Entlassen");
		menuI.addActionListener(controllerMenu);
		menu.add(menuI);
		menu.addSeparator();
		menuI = new JMenuItem("Suchen");
		menuI.addActionListener(controllerMenu);
		menu.add(menuI);
		
		checkbox=new JCheckBox();

		anzahlMitarbeiter=new JTextField(); anzahlMitarbeiter.setPreferredSize(new Dimension(200,20)); anzahlMitarbeiter.setEditable(false);

		mitarbeiter=new JTextArea(20,50); mitarbeiter.setLineWrap(true); mitarbeiter.setEditable(true);

		scroll=new JScrollPane(mitarbeiter, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		panel1.add(new JLabel("nur Abteilungsleiter anzeigen:"));
		panel1.add(checkbox);
		panel1.add(new JLabel("Gesmatanzahl aller Mitarbeiter: "));
		panel1.add(anzahlMitarbeiter);

		panel1.add(scroll);
		this.setJMenuBar(menuB);
		
		this.add(panel1);
	}
	
	public void aktualisiere(String text, int anzMitarbeiter) throws CompanyException {
//		mitarbeiter.setText(text);
		mitarbeiter.setText(text);
		anzahlMitarbeiter.setText(Integer.toString(anzMitarbeiter));
//		anzahlMitarbeiter.setText(Integer.toString(model.anzahlMitarbeiter()));
	}
	
	public void showErrorMessage(String error) {
		JOptionPane.showMessageDialog(this, error,"Error!", JOptionPane.ERROR_MESSAGE);
	}
	
	public void showMitarbeiter(String info) {
		JOptionPane.showMessageDialog(this,  info, "Mitarbeiter", JOptionPane.PLAIN_MESSAGE);
	}

	public JPanel getPanel1() {
		return panel1;
	}

	public void setPanel1(JPanel panel1) {
		this.panel1 = panel1;
	}

	public JCheckBox getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(JCheckBox checkbox) {
		this.checkbox = checkbox;
	}

	public JTextField getAnzahlMitarbeiter() {
		return anzahlMitarbeiter;
	}

	public void setAnzahlMitarbeiter(JTextField anzahlMitarbeiter) {
		this.anzahlMitarbeiter = anzahlMitarbeiter;
	}

	public JTextArea getMitarbeiter() {
		return mitarbeiter;
	}

	public void setMitarbeiter(JTextArea mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public JMenuBar getMenuB() {
		return menuB;
	}

	public void setMenuB(JMenuBar menuB) {
		this.menuB = menuB;
	}

	public JMenu getMenu() {
		return menu;
	}

	public void setMenu(JMenu menu) {
		this.menu = menu;
	}

	public JMenuItem getMenuI() {
		return menuI;
	}

	public void setMenuI(JMenuItem menuI) {
		this.menuI = menuI;
	}
}
