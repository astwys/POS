import java.awt.*;

import javax.swing.*;

/** Das Hauptfenster der grafischen Anwendung
 */
@SuppressWarnings("serial")
public class ViewHauptfenster extends JFrame 
{
	private JTextArea jtaAnzeige;
	private JCheckBox jcbZeigeAlle;
	private JLabel jlAnzahl;

	CtrlHauptfenster controller;
	Kunstsammlung model;

	/**
	 * Im Konstruktor des Hauptfensters wird hier das Model und der Controller erzeugt und
	 * die grafischen Komponenten werden initialisiert. 
	 */
	public ViewHauptfenster()
	{
		model      = new Kunstsammlung();
		controller = new CtrlHauptfenster(this, model);		
		
		// diesen Teil kann man auch komplett in intitComponents() packen
		setTitle("Kunstwerke");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 450, 550);
		
		initComponents();

		setVisible(true);
	}
	
	/**
	 * Initialisiert alle GUI-Komponenten.
	 */
	private void initComponents()
	{
		JPanel oberesPannel = new JPanel(new GridLayout(1, 2));
		JPanel hauptPannel = new JPanel(new BorderLayout());

		jtaAnzeige = new JTextArea();
		jlAnzahl = new JLabel();
		jcbZeigeAlle = new JCheckBox("Alle Kunstwerke anzeigen");
		jcbZeigeAlle.setSelected(true);
		jcbZeigeAlle.addActionListener(controller);
		JScrollPane jscp = new JScrollPane(jtaAnzeige);
		
		oberesPannel.add(jcbZeigeAlle);
		oberesPannel.add(jlAnzahl);
		hauptPannel.add(oberesPannel, BorderLayout.NORTH);
		hauptPannel.add(jscp, BorderLayout.CENTER);
		
		this.add(hauptPannel);
		
		// Aufbau des Menüs
		
		JMenuItem lesen = new JMenuItem("Einlesen"); lesen.setMnemonic('r');
		JMenuItem speichern = new JMenuItem("Speichern"); speichern.setMnemonic('s');
		lesen.addActionListener(controller);
		speichern.addActionListener(controller);
		
		JMenu datei = new JMenu("Datei"); datei.setMnemonic('d');
		datei.add(speichern); datei.add(lesen);

		JMenuItem ankaufen = new JMenuItem("Ankaufen"); ankaufen.setMnemonic('a');
		JMenuItem verleihen = new JMenuItem("Verleihen"); verleihen.setMnemonic('v');
		ankaufen.addActionListener(controller);
		verleihen.addActionListener(controller);

		JMenu kunstwerke = new JMenu("Kunstwerk"); kunstwerke.setMnemonic('k');
		kunstwerke.add(ankaufen); 
		kunstwerke.add(verleihen);
		
		JMenuBar bar = new JMenuBar();
		bar.add(datei); 
		bar.add(kunstwerke);
		this.setJMenuBar(bar);
	}

	/**
	 * Aktualisiert die angezeigte Anzahl der Kunstwerke und den Text der Anzeige.
	 * Da das Model als Attribut verfügbar ist, kann die Methode alle Infos dort abfragen.
	 */
	public void aktualisiereAnzeige()
	{
		aktualisiereAnzahl(model.anzahlKunstwerke(jcbZeigeAlle.isSelected()),
				           model.anzahlKunstwerke(true));
		aktualisiereAnzeige(model.getListeAlsText(jcbZeigeAlle.isSelected()));	
	}
	
	/**
	 * Aktualisiert die angezeigte Anzahl der Kunstwerke.
	 * 
	 * @param anzahl 
	 */
	public void aktualisiereAnzahl(int anzahl, int gesamt)
	{
		this.jlAnzahl.setText("angezeigt: " + anzahl + ((anzahl==1)? " Kunstwerk" : " Kunstwerke")
				              + " (gesamt: " + gesamt + ")");
	}
	
	/**
	 * Aktualisiert den Text der Anzeige (JTextArea).
	 * 
	 * @param text
	 */
	public void aktualisiereAnzeige(String text)
	{
		jtaAnzeige.setText(text);
	}
	
	/**
	 * @return Zustand der Checkbox "Alle Kunstwerke anzeigen"
	 */
	public boolean getZeigeAlle()
	{
		return jcbZeigeAlle.isSelected();
	}
	
	public void zeigeFehlermeldung(String meldung)
	{
		zeigeFehlermeldung("Fehler!", meldung);
	}

	public void zeigeFehlermeldung(String titel, String meldung)
	{
		if (titel==null) titel = "";
		JOptionPane.showMessageDialog(this, meldung, titel, JOptionPane.ERROR_MESSAGE);
	}
}
