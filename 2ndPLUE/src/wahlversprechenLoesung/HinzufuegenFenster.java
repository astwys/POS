package wahlversprechenLoesung;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/** View: Fenster zum Hinzuf�gen eines Eintrags 
 *  
 *   @author Gerald Schildberger
 *   @version 2015
 */
public class HinzufuegenFenster extends JFrame implements ActionListener
{
	Hauptfenster view;
	Controller ctrl;
	
	private JButton uebernehmen;
	private JButton verwerfen;
	private WVPanel mitte;
	
	public HinzufuegenFenster(Controller ctrl)
	{
		this.ctrl = ctrl;
		
		this.setBounds(350,10,400,500);
		this.setTitle("Wahlversprechen hinzuf�gen");
		this.setLayout(new BorderLayout());
		mitte = new WVPanel(true,true);
		JPanel sued = new JPanel();
		
		verwerfen = new JButton("Verwerfen"); verwerfen.addActionListener(this);
		uebernehmen = new JButton("�bernehmen"); uebernehmen.addActionListener(this);
		sued.add(verwerfen); sued.add(uebernehmen);
		
		this.add(mitte, BorderLayout.CENTER);
		this.add(sued, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource().equals(uebernehmen))
		{
			try
			{
				Wahlversprechen wv = mitte.erzeugeWahlversprechen(); // Werte auslesen
				ctrl.hinzufuegen(wv);
				this.dispose();
			}
			catch (Exception e)
			{
				ctrl.zeigeFehlermeldung(e.getMessage());
			}
		}
		else // verwerfen (Keine Angabe in der Angabe was man hier tun sollte) 
		{
			// this.dispose();               // Fenster schlie�en
			mitte.aktualisiereAnzeige(null); // alle Felder im Eingabepanel l�schen
		}
	}
}
