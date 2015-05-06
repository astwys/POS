import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/** View: Fenster zum Ändern eines Eintrags (nicht Teil der prLUe!) 
 *  
 *   @author Gerald Schildberger
 *   @version 2015
 */
// sehr ähnlich dem HinzufuegenFenster, bis auf 2 Unerschiede...
public class AendernFenster extends JFrame implements ActionListener
{
	Controller ctrl;
	private Wahlversprechen refOriginal; // Achtung: Referenz auf das Objekt im Model!!!
		
	private JButton uebernehmen;
	private JButton verwerfen;     // eigentlich nicht nötig
	private WVPanel mitte;
	
	public AendernFenster(Controller ctrl, Wahlversprechen wv)
	{
		this.ctrl = ctrl;
		this.refOriginal = wv;   
		this.setBounds(350,10,400,500);
		this.setTitle("Wahlversprechen ändern");
		this.setLayout(new BorderLayout());
        // 1. Unterschied zum HinzufuegenFenster:
		mitte = new WVPanel(true,false);      // Schlagwort nicht eingabebereit 
		mitte.aktualisiereAnzeige(wv);        // übergebenes Objekt anzeigen
		
		JPanel sued = new JPanel();
		verwerfen = new JButton("Verwerfen");    verwerfen.addActionListener(this);
		uebernehmen = new JButton("Übernehmen"); uebernehmen.addActionListener(this);
		sued.add(verwerfen); sued.add(uebernehmen);
		
		this.add(mitte, BorderLayout.CENTER);
		this.add(sued, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		// "übernehmen"
		if (ae.getSource().equals(uebernehmen))
		{
			try
			{
				Wahlversprechen wv = mitte.erzeugeWahlversprechen(); // Werte auslesen
				// 2. Unterschied zum HinzufuegenFenster:
				refOriginal.setBeschreibung(wv.getBeschreibung());
				refOriginal.setStimmenzuwachs(wv.getStimmenzuwachs());
				refOriginal.setKosten(wv.getKosten());
				refOriginal.setWirdVerworfen(wv.getWirdVerworfen());
				refOriginal.setGueltig(wv.isGueltig(), wv.getAusrede());
				ctrl.aendern(refOriginal);
				this.dispose();
			}
			catch (Exception e)
			{
				ctrl.zeigeFehlermeldung(e.getMessage());
			}
		}
		else // "verwerfen" (Keine Angabe in der Angabe was man hier tun sollte) 
		{			
			// einfachste Option: Fenster schließen (oder den Button weglassen)
			// this.dispose(); 

			// oder: den Originalzustand wiederherstellen (refOriginal hat ja noch die Werte)
			mitte.aktualisiereAnzeige(refOriginal);
			
			// oder: alle Felder leeren -> führt ev. zu einer Fehlermeldung wegen ungültiger Werte bei "übernehmen"
			// mitte.aktualisiereAnzeige(null);
		}
	}
}
