package wahlversprechen;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ViewMain extends JFrame {
	
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	
	private JMenuBar menuB;
	private JMenu menu;
	private JMenuItem menuI;
	
	private JLabel label;
	
	private JTextArea schlagwort;
	private JTextArea beschreibung;
	private JTextArea ausrede;
	
	private JScrollPane scroll;
	
	private JCheckBox aktiv;
	
	private JButton previous;
	private JButton next;
	
	private ControllerMenu contM;
	
	public ViewMain() {
		// TODO Auto-generated constructor stub
		contM=new ControllerMenu(this);
		frame();
		components();
		setVisible(true);
	}
	
	public void frame() {
		setTitle("Wahlversprechen");
		setSize(370, 550);
		
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int) (d.getWidth()/2 - this.getWidth()/2);
		int y=(int) (d.getHeight()/2 - this.getHeight()/2);
		setLocation(x,y);
		
		this.setResizable(false);
	}
	
	public void components() {
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		
		menuB=new JMenuBar();
		menu=new JMenu("Datei");
		menuB.add(menu);
		menuI=new JMenuItem("Hinzufügen");
		menuI.addActionListener(contM);
		menu.add(menuI);
		
		menuI=new JMenuItem("Entfernen");
		menuI.addActionListener(contM);
		menu.add(menuI);
		
		label=new JLabel("Stimmenanzahl: ");
		panel1.add(new JLabel("Stimmenanzahl: \t"));
		
		label=new JLabel("Schlagwort: ");
		schlagwort=new JTextArea(8,30);
		schlagwort.setEditable(false);
		schlagwort.setLineWrap(true);
//		scroll=new JScrollPane(schlagwort, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//		scroll.add(schlagwort);
		panel1.add(label);
		panel1.add(schlagwort);
		
		beschreibung=new JTextArea(8,30);
		beschreibung.setEditable(false);
		beschreibung.setLineWrap(true);
		panel1.add(new JLabel("Beschreibung: "));
		panel1.add(beschreibung);
		
		aktiv=new JCheckBox();
		aktiv.setEnabled(false);
		panel1.add(new JLabel("noch aktiv?"));
		panel1.add(aktiv);
		
		ausrede = new JTextArea(8,30);
		ausrede.setLineWrap(true);
		ausrede.setEditable(false);
		panel1.add(new JLabel("Ausrede: "));
		panel1.add(ausrede);
		
		previous=new JButton("<");
		previous.addActionListener(contM);
		next=new JButton(">");
		next.addActionListener(contM);
		panel1.add(previous);
		panel1.add(next);
		
		this.add(panel1);
		
		this.setJMenuBar(menuB);
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

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JTextArea getSchlagwort() {
		return schlagwort;
	}

	public void setSchlagwort(JTextArea schlagwort) {
		this.schlagwort = schlagwort;
	}

	public JTextArea getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(JTextArea beschreibung) {
		this.beschreibung = beschreibung;
	}

	public JTextArea getAusrede() {
		return ausrede;
	}

	public void setAusrede(JTextArea ausrede) {
		this.ausrede = ausrede;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public JCheckBox getAktiv() {
		return aktiv;
	}

	public void setAktiv(JCheckBox aktiv) {
		this.aktiv = aktiv;
	}

	public JButton getPrevious() {
		return previous;
	}

	public void setPrevious(JButton previous) {
		this.previous = previous;
	}

	public JButton getNext() {
		return next;
	}

	public void setNext(JButton next) {
		this.next = next;
	}

	public ControllerMenu getContM() {
		return contM;
	}

	public void setContM(ControllerMenu contM) {
		this.contM = contM;
	}

}
