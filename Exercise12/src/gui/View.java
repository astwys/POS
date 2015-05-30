/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import data.Firma;
import data.Test;

/**
 * @author jonas_000
 *
 */
public class View extends JFrame implements ActionListener {

	
	public static final String TITLE = "Hauptfenster";
	public static final int HEIGHT = 400;
	public static final int WIDTH = 600;
	
//	model && controller
	private Firma model;
	private Controller controller;
	
	//TOP
	private JCheckBox nurAbteilungsleiter;
	private JLabel mitarbeiterLabel;
	private JLabel anzahlMitarbeiter;
	//CENTER
	private JTextArea area;
	private JScrollPane pane;
	//MENU
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem menuItem;

	private JPanel panel_north;
	private JPanel panel_center;
	
	public View() {
		setTitle(TITLE);
		setBounds(400, 400, WIDTH, HEIGHT);
		
		this.model = new Firma("TestFirma");
		this.controller = new Controller(model, this);
		
		initComponents();
		setVisible(true);
	}
	
	public void initComponents() {
		panel_north = new JPanel(new GridLayout(1,3));
		panel_center = new JPanel(new GridLayout(1,1));
		
		//north
		mitarbeiterLabel = new JLabel();
		mitarbeiterLabel.setText("nur Abteilungsleiter anzeigen");
		panel_north.add(mitarbeiterLabel);
		nurAbteilungsleiter = new JCheckBox();
		nurAbteilungsleiter.addActionListener(this);
		panel_north.add(nurAbteilungsleiter);
		anzahlMitarbeiter = new JLabel("Gesamtanzahl der Mitarbeiter "+model.size());
		panel_north.add(anzahlMitarbeiter);
		this.add(panel_north, BorderLayout.NORTH);
		
		//center
		area = new JTextArea();
//		area.setEditable(false);
		pane = new JScrollPane(area);
		panel_center.add(pane);
		
		this.add(panel_center, BorderLayout.CENTER);
		
		//Menu
		menuBar = new JMenuBar();
		menu = new JMenu("Datei");
		menuItem = new JMenuItem("Laden");
		menuItem.addActionListener(controller);
		menu.add(menuItem);
		menuBar.add(menu);
		menuItem = new JMenuItem("Speichern");
		menuItem.addActionListener(controller);
		menu.add(menuItem);
		menu = new JMenu("Mitarbeiter");
		menuItem = new JMenuItem("Anstellen");
		menuItem.addActionListener(controller);
		menu.add(menuItem);
		menuItem = new JMenuItem("Entlassen");
		menuItem.addActionListener(controller);
		menu.add(menuItem);
		menuItem = new JMenuItem("Suchen");
		menuItem.addActionListener(controller);
		menu.add(menuItem);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
	}
	
	public void refreshView(){
		mitarbeiterLabel.setText("nur Abteilungsleiter anzeigen");
		anzahlMitarbeiter.setText("Gesamtanzahl der Mitarbeiter "+model.size());
		area.setText(this.model.returnMitarbeiter());
		
		//setzen der text area!!!
	}
	
	public void showErrorMessage(String title, String message) {
		JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(nurAbteilungsleiter.isSelected()) {
			area.setText(model.returnOnlyAbteilungsleiter());
		}
		else {
			area.setText(model.returnMitarbeiter());
		}
	}
}
