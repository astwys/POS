package wahlversprechenLoesung;

import java.awt.*;

import javax.swing.*;

/** View: Das Hauptfenster der grafischen Anwendung 
 *  
 *   @author Gerald Schildberger
 *   @version 2015
 */
@SuppressWarnings("serial")
public class Hauptfenster extends JFrame 
{
	Controller ctrl;
	Parteiprogramm model;

	WVPanel mitte;  // mittleres Panel, basierend auf WVPanel
	JLabel indikator;
	
	/**
	 * Im Konstruktor des Hauptfensters wird hier das Model und der Controller erzeugt und
	 * die grafischen Komponenten werden initialisiert. 
	 */
	public Hauptfenster(String parteiname, float stammwaehler)
	{
		model = new Parteiprogramm(parteiname, stammwaehler);
		ctrl = new Controller(this, model);		
		
		setTitle("Wahlversprechen der \"" + model.getParteiname() + "\"");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 450, 550);

		initComponents();

		setVisible(true);
	}
	
	/**
	 * Initialisiert alle GUI-Komponenten des Hauptfensters
	 */
	private void initComponents()
	{
		JPanel haupt = new JPanel(); haupt.setLayout(new BorderLayout());
		JPanel nord = new JPanel();  
		mitte = new WVPanel(false,false);
		JPanel sued = new JPanel();
		
		
		// n�rdl. Panel
		indikator = new JLabel(); // wird von aktualiereAnzeige(...) gesetzt
		indikator.setOpaque(true);
		nord.add(indikator); 

		// s�dl. Panel
		JButton zurueck = new JButton("<"); zurueck.addActionListener(ctrl); 
		JButton vor     = new JButton(">"); vor.addActionListener(ctrl);
		sued.add(zurueck);  sued.add(vor);
		
		haupt.add(nord, BorderLayout.NORTH);
		haupt.add(mitte, BorderLayout.CENTER);
		haupt.add(sued, BorderLayout.SOUTH);
		
		this.add(haupt);
		this.aktualisiereAnzeige(null);
		
		// Aufbau des Men�s (die Eintr�ge "�ndern" & "nach Kosen" waren nicht Teil der pLUe)

		JMenuItem hinzufuegen = new JMenuItem("Hinzuf�gen"); hinzufuegen.setMnemonic('H');
		JMenuItem aendern  = new JMenuItem("�ndern"); aendern.setMnemonic('e');
		JMenuItem loeschen = new JMenuItem("L�schen"); loeschen.setMnemonic('L');
		
		JMenu uebersicht = new JMenu("�bersicht sortiert"); uebersicht.setMnemonic('s');
		JMenuItem alphanum = new JMenuItem("alphabetisch"); alphanum.setMnemonic('a');
		JMenuItem kosten   = new JMenuItem("nach Kosten"); kosten.setMnemonic('K');
		JMenuItem stimmen  = new JMenuItem("nach Stimmen"); stimmen.setMnemonic('S');
		uebersicht.add(alphanum); uebersicht.add(kosten); uebersicht.add(stimmen);
		
		JMenu versprechen = new JMenu("Wahlversprechen"); versprechen.setMnemonic('W');
		versprechen.add(hinzufuegen); versprechen.add(aendern); versprechen.add(loeschen);
		versprechen.add(uebersicht);

		hinzufuegen.addActionListener(ctrl);
		aendern.addActionListener(ctrl);
		loeschen.addActionListener(ctrl);
		alphanum.addActionListener(ctrl);		
		kosten.addActionListener(ctrl);		
		stimmen.addActionListener(ctrl);

		// ----
		
		JMenuItem laden = new JMenuItem("Laden"); laden.setMnemonic('L');
		JMenuItem speichern = new JMenuItem("Speichern"); speichern.setMnemonic('S');

		JMenu datei = new JMenu("Datei"); datei.setMnemonic('D');
		datei.add(speichern); datei.add(laden);

		laden.addActionListener(ctrl);
		speichern.addActionListener(ctrl);

		JMenuBar bar = new JMenuBar();
		bar.add(versprechen);
		bar.add(datei); 
		this.setJMenuBar(bar);
	}

	
	/**
	 * Aktualisiert die Anzeige	 */
	public void aktualisiereAnzeige(Wahlversprechen wv)
	{
		mitte.aktualisiereAnzeige(wv);

		float prozent = model.getProzentStammwaehler() + model.berechneSummeStimmenzuwachs();
		indikator.setText("W�hlerstimmen: " + prozent + "%");
		if (prozent>50)
		{
			indikator.setForeground(Color.BLACK);
			indikator.setBackground(Color.GREEN);
		}
		else
		{
			indikator.setForeground(Color.WHITE);
			indikator.setBackground(Color.RED);
		}
	}
	
	/** Anzeige einer Fehlermeldung als JOptionPane.Error_Message
	 *  Titel des Popups lautet "Fehler!"
	 * 
	 * @param meldung
	 */
	public void zeigeFehlermeldung(String meldung)
	{
		zeigeFehlermeldung("Fehler!", meldung);
	}

	/** Anzeige einer Fehlermeldung als JOptionPane.Error_Message
	 * 
	 * @param titel 
	 * @param meldung
	 */
	public void zeigeFehlermeldung(String titel, String meldung)
	{
		if (titel==null) titel = "";
		JOptionPane.showMessageDialog(this, meldung, titel, JOptionPane.ERROR_MESSAGE);
	}
}
