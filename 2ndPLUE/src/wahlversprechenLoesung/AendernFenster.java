package wahlversprechenLoesung;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/** View: Fenster zum �ndern eines Eintrags (nicht Teil der prLUe!) 
 *  
 *   @author Gerald Schildberger
 *   @version 2015
 */
// sehr �hnlich dem HinzufuegenFenster, bis auf 2 Unerschiede...
public class AendernFenster extends JFrame implements ActionListener
{
	Controller ctrl;
	private Wahlversprechen refOriginal; // Achtung: Referenz auf das Objekt im Model!!!
		
	private JButton uebernehmen;
	private JButton verwerfen;     // eigentlich nicht n�tig
	private WVPanel mitte;
	
	public AendernFenster(Controller ctrl, Wahlversprechen wv)
	{
		this.ctrl = ctrl;
		this.refOriginal = wv;   
		this.setBounds(350,10,400,500);
		this.setTitle("Wahlversprechen �ndern");
		this.setLayout(new BorderLayout());
        // 1. Unterschied zum HinzufuegenFenster:
		mitte = new WVPanel(true,false);      // Schlagwort nicht eingabebereit 
		mitte.aktualisiereAnzeige(wv);        // �bergebenes Objekt anzeigen
		
		JPanel sued = new JPanel();
		verwerfen = new JButton("Verwerfen");    verwerfen.addActionListener(this);
		uebernehmen = new JButton("�bernehmen"); uebernehmen.addActionListener(this);
		sued.add(verwerfen); sued.add(uebernehmen);
		
		this.add(mitte, BorderLayout.CENTER);
		this.add(sued, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		// "�bernehmen"
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
			// einfachste Option: Fenster schlie�en (oder den Button weglassen)
			// this.dispose(); 

			// oder: den Originalzustand wiederherstellen (refOriginal hat ja noch die Werte)
			mitte.aktualisiereAnzeige(refOriginal);
			
			// oder: alle Felder leeren -> f�hrt ev. zu einer Fehlermeldung wegen ung�ltiger Werte bei "�bernehmen"
			// mitte.aktualisiereAnzeige(null);
		}
	}
}
