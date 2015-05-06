package kunstsammlung;

import java.awt.event.*;

/** Controller f�r's Ankaufen-Fenster 
 */
public class CtrlAnkaufen implements ActionListener
{
	private ViewHauptfenster viewHF;
	private ViewAnkaufen viewAF;
	private Kunstsammlung model;
	
	/**
	 * @param viewHF ... Referenz auf das Hauptfenster
	 * @param viewAF ... Referenz auf das Ankaufen-Fenster
	 * @param model  ... Referenz auf das Model
	 */
	public CtrlAnkaufen(ViewHauptfenster viewHF, ViewAnkaufen viewAF, Kunstsammlung model)
	{
		this.viewHF = viewHF;
		this.viewAF = viewAF;
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("OK"))
		{
			try 
			{
				String bezeichnung = viewAF.getBezeichnung();
				float wert = Float.parseFloat(viewAF.getWert());
				boolean verliehen = viewAF.getVerliehen();
				
				Kunstwerk k = new Kunstwerk(bezeichnung, verliehen, wert);
				boolean erfolgt = model.ankaufen(k);
				if (erfolgt)
				{
					viewHF.aktualisiereAnzeige();
					viewAF.dispose();
				}
				else
				{
					viewHF.zeigeFehlermeldung("Ankauf nicht m�glich!", "Die Sammlung enth�lt schon ein Kunstwerk mit dieser Bezeichnung!");
				}
			} 
			catch (NumberFormatException nfe)
			{
				viewHF.zeigeFehlermeldung("Bitte einen g�ltigen Wert eingeben!", nfe.getMessage());
			}
			catch (KunstsammlungException ke) 
			{
				viewHF.zeigeFehlermeldung("Ankauf nicht m�glich!", ke.getMessage());
			}
		} 
		else if(e.getActionCommand().equals("Abbrechen"))
		{
			viewAF.dispose();
		}
	}
	
}
