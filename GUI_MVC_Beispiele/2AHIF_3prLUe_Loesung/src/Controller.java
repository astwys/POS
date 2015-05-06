import java.awt.event.*;

import javax.swing.*;

import java.io.File;

/** Controller für's Hauptfenster
 *  ... erhält eine Referenz auf das Hauptfenster und
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
		aktIndex = 0; // möglicherweise gibt es kein 0. Element (leer) 
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
			case "Hinzufügen": 	new HinzufuegenFenster(this); 
								// ruft nach erfolgter Eingabe hinzufuegen(...) auf	
								// ("ruft zurück")
					break;
			case "Ändern": 		Wahlversprechen aktWV = model.getWahlversprechen(aktIndex);
								if (aktWV!=null) new AendernFenster(this, aktWV);
								// dem Ändernfenster wird eine Referenz auf das zu ändernde 
								// Objekt mitgegeben und es ruft dann aendern(...) auf
								// ("ruft zurück")      ("Ändern" ist nicht Teil der prLUe!)
					break;
			case "Löschen":		loeschen();		
					break;
			case "alphabetisch":
			case "nach Kosten":
			case "nach Stimmen":sortierteListe(e.getActionCommand());
					break;
			case "Laden":		laden();		
					break;
			case "Speichern":	speichern();	
					break;
			default: view.zeigeFehlermeldung("\""+e.getActionCommand()+"\"", "Aktion noch nicht unterstützt!");
					// System.out.println("\""+e.getActionCommand() + "\" ... Aktion noch nicht unterstützt!");
		}
	}
	
	// zurückblättern
	private void zurueck()
	{
		if (aktIndex>0)
		  {
			  view.aktualisiereAnzeige(model.getWahlversprechen(--aktIndex));
		  }
	}
	
	// vorblättern
	private void vor()
	{
		if (aktIndex<model.getAnzahlWahlversprechen()-1)
		  {
			  view.aktualisiereAnzeige(model.getWahlversprechen(++aktIndex));
		  }
	}
	
	// Wird vom Hinzufügen-Fensters aufgerufen sobald dort die Eingabe erfolgte 
	// und ein Wahlversprechen-Objekt erzeugt wurde.
	// Trick: Die Exception ermöglicht dem Hinzufügen-Fenster auf Fehler zu reagieren
	public void hinzufuegen(Wahlversprechen wv) throws WahlversprechenException
	{
			model.hinzufuegen(wv);
			view.aktualisiereAnzeige(model.getWahlversprechen(aktIndex));
	}
	
	// Die Änderung wurde eigentlich schon AendernFenster erledigt,
	// hier ist nur mehr der "Rückruf", um die Anzeige zu aktualisieren (Beta!)
	public void aendern(Wahlversprechen wv)
	{
		// eventuelle Änderungen anzeigen 
		// (wenn im Hauptfenster inzwischen nicht weitergeblättert wurde) 
		if (wv== model.getWahlversprechen(aktIndex))
			view.aktualisiereAnzeige(wv);

		/*  Anm.: Schönere Alternative wäre ein Ändern-Fenster, welches basierende auf dem
		 *        übergebenen Objekt ein neues erzeugt (oder schon eine Kopie erhält),
		 *        diese dann dem Model schickt und das Model gleicht ab bzw. führt dann die
		 *        erforderlichen Änderungen durch (inkl. aller Prüfungen).
		*/
	}
	
	// löscht den aktuell angezeigten Eintrag
	private void loeschen()
	{
		Wahlversprechen aktVersprechen = model.getWahlversprechen(aktIndex);
		// das eigentlich Löschen versteckt sich hier -v 
		if (aktVersprechen!=null && model.loeschen(aktVersprechen))  // wenn erfolgreich
		{
			// Das angezeigte Element wurde gelöscht, was zeigen wir nun an?
			//   Wurde das letzte Element gelöscht -> Index reduzieren (Voriges anzeigen)
			//   sonst bleibt der Index unverändert (das Nächste wird dadurch autom. angezeigt)
			if (aktIndex == model.getAnzahlWahlversprechen())
			{
				aktIndex--;
			}
			aktVersprechen = model.getWahlversprechen(aktIndex);
			view.aktualisiereAnzeige(aktVersprechen);		
		}
		else
		{
			view.zeigeFehlermeldung("Löschen nicht möglich","Kein Element ausgewählt!");
		}
	}
	
	// Öffnet ein Fenster und übergibt ihm den anzuzeigenden Text
	private void sortierteListe(String wonachSortieren)
	{
		new SortierteListeFenster(wonachSortieren, model.getSortierteListeAlsText(wonachSortieren));
	}
	
	// Laden: JFileChooser zur Bestimmung des Dateinamens, dann Aufruf im Model. 
	private void laden()
	{
		JFileChooser chooser = new JFileChooser();
		// nicht erforderlich, aber setzt ein Ausgangsverzeichnis und einen Vorschlag für den Namen:
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
		// nicht erforderlich, aber setzt ein Ausgangsverzeichnis und einen Vorschlag für den Namen:
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
