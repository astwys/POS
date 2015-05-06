package kunstsammlung;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

/** (Haupt-) Controller f�r's Hauptfenster
 *  ... erh�lt eine Referenz auf die View und
 *  ... eine Referenz auf das Model
 *  beides wurde vom Konstruktor des Hauptfensters erzeugt
 */
public class CtrlHauptfenster implements ActionListener 
{
	private ViewHauptfenster view;
	private Kunstsammlung model;
	
	/**
	 * @param view Referenz auf das Hauptfenster
	 */
	public CtrlHauptfenster(ViewHauptfenster view, Kunstsammlung model)
	{
		this.view = view;
		this.model = model;
	}
	
	/**
	 * Die zentrale Methode zur Steuerung des Programms = Listener des Hauptfensters.
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if("Alle Kunstwerke anzeigen".equals(e.getActionCommand()))
		{
			view.aktualisiereAnzeige();
		}
		// ----------------------------------------------------------------------------------
		else if("Ankaufen".equals(e.getActionCommand()))
		{
			new ViewAnkaufen(view, model);
			// view.aktualisiereAnzeige(); 
			// Frage:   Warum kann das hier nicht funktionieren???
		    // Antwort: new... Erzeugt das Ankaufen-Fenster, wartet aber nicht auf eine Eingabe!
			// (ASYNCHRON)
		}
		// ----------------------------------------------------------------------------------
		else if("Verleihen".equals(e.getActionCommand()))
		{
			// "warten" auf die Benutzereingabe...
			String eingegBezeichnung = JOptionPane.showInputDialog(view, 
					                                               "Bezeichnung", 
					                                               "Kunstwerk verleihen",
					                                               JOptionPane.QUESTION_MESSAGE);
			// Benutzereingabe erfolgt, e geht weiter (SYNCHRON)
			if(!eingegBezeichnung.isEmpty())
			{
				if (model.verleihen(eingegBezeichnung, true) == false)
					view.zeigeFehlermeldung("Es gibt kein Kunstwerk mit dieser Bezeichnung in der Sammlung!");
				else
					view.aktualisiereAnzeige();
			}
			else 
				view.zeigeFehlermeldung("Sie haben keine Bezeichnung eingegeben!");
		}
		// ----------------------------------------------------------------------------------
		else if("Einlesen".equals(e.getActionCommand()))
		{
			JFileChooser chooser = new JFileChooser();
			// nicht erforderlich, aber setzt ein Ausgangsverzeichnis und einen Vorschlag f�r den Namen:
			chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
			// oder: chooser.setCurrentDirectory(new File("."));
			chooser.setSelectedFile(new File("Kunstsammlung.dat"));
			int result = chooser.showOpenDialog(view);
			
			if(result == JFileChooser.APPROVE_OPTION)
			{
				try
				{
					model.einlesen(chooser.getSelectedFile().getAbsolutePath());
					view.aktualisiereAnzeige();
				} 
				catch (Exception ex) 
				{
					view.zeigeFehlermeldung("Datei konnte nicht gelesen werden!", ex.getMessage());
				}
			}
		}
		// ----------------------------------------------------------------------------------
		else if("Speichern".equals(e.getActionCommand()))
		{
			JFileChooser chooser = new JFileChooser();
			// nicht erforderlich, aber setzt ein Ausgangsverzeichnis und einen Vorschlag f�r den Namen:
			chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
			// oder: chooser.setCurrentDirectory(new File("."));
			chooser.setSelectedFile(new File("Kunstsammlung.dat"));
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
	}
}
