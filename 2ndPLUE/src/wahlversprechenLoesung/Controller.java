package wahlversprechenLoesung;

import java.awt.event.*;

import javax.swing.*;

import java.io.File;

/** Controller f�r's Hauptfenster
 *  ... erh�lt eine Referenz auf das Hauptfenster und
 *  ... eine Referenz auf das Model
 *  beides wurde vom Konstruktor des Hauptfensters erzeugt
 *
 *	@author Gerald Schildberger
 *  @version 2015
 */
public class Controller implements ActionListener 
{
	private Hauptfenster  view;
	private Parteiprogramm model;
	private int aktIndex;          // Index des aktuell angezeigten Eintrags des Models
	
	/**
	 * @param view Referenz auf das Hauptfenster
	 */
	public Controller(Hauptfenster view, Parteiprogramm model)
	{
		this.view = view;
		this.model = model;
		aktIndex = 0; // m�glicherweise gibt es kein 0. Element (leer) 
		              // -> model liefert null -> Felder bleiben leer
	}
	
	/**
	 * Die zentrale Methode zur Steuerung des Programms = Listener des Hauptfensters.
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch (e.getActionCommand())
		{
			case "<": 			zurueck();		
					break;
			case ">": 			vor();			
					break;
			case "Hinzuf�gen": 	new HinzufuegenFenster(this); 
								// ruft nach erfolgter Eingabe hinzufuegen(...) auf	
								// ("ruft zur�ck")
					break;
			case "�ndern": 		Wahlversprechen aktWV = model.getWahlversprechen(aktIndex);
								if (aktWV!=null) new AendernFenster(this, aktWV);
								// dem �ndernfenster wird eine Referenz auf das zu �ndernde 
								// Objekt mitgegeben und es ruft dann aendern(...) auf
								// ("ruft zur�ck")      ("�ndern" ist nicht Teil der prLUe!)
					break;
			case "L�schen":		loeschen();		
					break;
			case "alphabetisch":
			case "nach Kosten":
			case "nach Stimmen":sortierteListe(e.getActionCommand());
					break;
			case "Laden":		laden();		
					break;
			case "Speichern":	speichern();	
					break;
			default: view.zeigeFehlermeldung("\""+e.getActionCommand()+"\"", "Aktion noch nicht unterst�tzt!");
					// System.out.println("\""+e.getActionCommand() + "\" ... Aktion noch nicht unterst�tzt!");
		}
	}
	
	// zur�ckbl�ttern
	private void zurueck()
	{
		if (aktIndex>0)
		  {
			  view.aktualisiereAnzeige(model.getWahlversprechen(--aktIndex));
		  }
	}
	
	// vorbl�ttern
	private void vor()
	{
		if (aktIndex<model.getAnzahlWahlversprechen()-1)
		  {
			  view.aktualisiereAnzeige(model.getWahlversprechen(++aktIndex));
		  }
	}
	
	// Wird vom Hinzuf�gen-Fensters aufgerufen sobald dort die Eingabe erfolgte 
	// und ein Wahlversprechen-Objekt erzeugt wurde.
	// Trick: Die Exception erm�glicht dem Hinzuf�gen-Fenster auf Fehler zu reagieren
	public void hinzufuegen(Wahlversprechen wv) throws WahlversprechenException
	{
			model.hinzufuegen(wv);
			view.aktualisiereAnzeige(model.getWahlversprechen(aktIndex));
	}
	
	// Die �nderung wurde eigentlich schon AendernFenster erledigt,
	// hier ist nur mehr der "R�ckruf", um die Anzeige zu aktualisieren (Beta!)
	public void aendern(Wahlversprechen wv)
	{
		// eventuelle �nderungen anzeigen 
		// (wenn im Hauptfenster inzwischen nicht weitergebl�ttert wurde) 
		if (wv== model.getWahlversprechen(aktIndex))
			view.aktualisiereAnzeige(wv);

		/*  Anm.: Sch�nere Alternative w�re ein �ndern-Fenster, welches basierende auf dem
		 *        �bergebenen Objekt ein neues erzeugt (oder schon eine Kopie erh�lt),
		 *        diese dann dem Model schickt und das Model gleicht ab bzw. f�hrt dann die
		 *        erforderlichen �nderungen durch (inkl. aller Pr�fungen).
		*/
	}
	
	// l�scht den aktuell angezeigten Eintrag
	private void loeschen()
	{
		Wahlversprechen aktVersprechen = model.getWahlversprechen(aktIndex);
		// das eigentlich L�schen versteckt sich hier -v 
		if (aktVersprechen!=null && model.loeschen(aktVersprechen))  // wenn erfolgreich
		{
			// Das angezeigte Element wurde gel�scht, was zeigen wir nun an?
			//   Wurde das letzte Element gel�scht -> Index reduzieren (Voriges anzeigen)
			//   sonst bleibt der Index unver�ndert (das N�chste wird dadurch autom. angezeigt)
			if (aktIndex == model.getAnzahlWahlversprechen())
			{
				aktIndex--;
			}
			aktVersprechen = model.getWahlversprechen(aktIndex);
			view.aktualisiereAnzeige(aktVersprechen);		
		}
		else
		{
			view.zeigeFehlermeldung("L�schen nicht m�glich","Kein Element ausgew�hlt!");
		}
	}
	
	// �ffnet ein Fenster und �bergibt ihm den anzuzeigenden Text
	private void sortierteListe(String wonachSortieren)
	{
		new SortierteListeFenster(wonachSortieren, model.getSortierteListeAlsText(wonachSortieren));
	}
	
	// Laden: JFileChooser zur Bestimmung des Dateinamens, dann Aufruf im Model. 
	private void laden()
	{
		JFileChooser chooser = new JFileChooser();
		// nicht erforderlich, aber setzt ein Ausgangsverzeichnis und einen Vorschlag f�r den Namen:
		chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		// oder: chooser.setCurrentDirectory(new File("."));
		chooser.setSelectedFile(new File("Wahlversprechen.dat"));
		int result = chooser.showOpenDialog(view);
		
		if(result == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				model.laden(chooser.getSelectedFile().getAbsolutePath());
				view.aktualisiereAnzeige(model.getWahlversprechen(aktIndex));
			} 
			catch (Exception ex) 
			{
				view.zeigeFehlermeldung("Datei konnte nicht gelesen werden!", ex.getMessage());
			}
		}
	}
	
	// Speichern: JFileChooser zur Bestimmung des Dateinamens, dann Aufruf im Model. 
	private void speichern()
	{ 
		JFileChooser chooser = new JFileChooser();
		// nicht erforderlich, aber setzt ein Ausgangsverzeichnis und einen Vorschlag f�r den Namen:
		chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		// oder: chooser.setCurrentDirectory(new File("."));
		chooser.setSelectedFile(new File("Wahlversprechen.dat"));
		int result = chooser.showSaveDialog(view);
		
		if(result == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				model.speichern(chooser.getSelectedFile().getAbsolutePath());
			} 
			catch (Exception ex) 
			{
				view.zeigeFehlermeldung("Datei konnte nicht gespeichert werden!",  ex.getMessage());
			}
		}
	}
	
	/* Fehlermeldungen werden ans Hauptfenster (view) weitergeleitet.
	 * Vorteil: Andere Fenster/Controller brauchen keine Referenz auf das Hauptfenster, 
	 *          sondern nur auf diesen (Haupt-) Controller.
	 */           
	public void zeigeFehlermeldung(String meldung) 	
	{ view.zeigeFehlermeldung(meldung);	}
	public void zeigeFehlermeldung(String titel, String meldung) 
	{ view.zeigeFehlermeldung(titel, meldung);	}
}
