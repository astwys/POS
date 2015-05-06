import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
/** Panel für die Eigenschaften eines Wahlversprechens
 */
public class WVPanel extends JPanel
{
	JTextField schlagwort;
	JTextArea beschreibung;
	JTextField stimmenzuwachs;
	JTextField kosten;
	JComboBox wirdVerworfen;
	JCheckBox gueltig;
	JTextArea ausrede;
	JLabel indikator;

	/** Erzeugt das Panel 
	 * 
	 * @param eingabebereit false: alle Komponenten werden unveränderbar angezeigt
	 *                      true: Felder sind Eingabebereit (siehe auch hinzufuegen)
	 * @param hinzufuegen   true: zum Hinzufügen ... alle Komponenten sind einabebereit
	 *                      false zum Ändern     ... das Feld Schlagwort ist nicht veränderbar
	 */
	public WVPanel(boolean eingabebereit, boolean hinzufuegen)
	{	this.setLayout(new GridLayout(6,2));
		
		schlagwort = new JTextField(20);
		beschreibung = new JTextArea(40,4);
		JScrollPane sBeschreibung = new JScrollPane(beschreibung);
		stimmenzuwachs = new JTextField(5);
		kosten = new JTextField(15);
		String[] auswahl = {Wahlversprechen.SOFORT,Wahlversprechen.IN_1_WOCHE,Wahlversprechen.IN_1_MONAT,Wahlversprechen.IN_1_JAHR};
		wirdVerworfen = new JComboBox(auswahl); wirdVerworfen.setName("wann verworfen");
		JPanel wVP = new JPanel(); 
		wVP.add(new JLabel("wird nach Wahl ungültig:"));
		wVP.add(wirdVerworfen);
		gueltig = new JCheckBox("Wahlversprechen noch gültig");
		ausrede = new JTextArea(40,4);
		JScrollPane sAusrede = new JScrollPane(ausrede);
		
		this.add(new JLabel("Schlagwort:"));          this.add(schlagwort);
		this.add(new JLabel("Beschreibung:"));        this.add(sBeschreibung);
		this.add(new JLabel("Stimmenzuwachs [%]: ")); this.add(stimmenzuwachs);
		this.add(new JLabel("Kosten [Mio.€]"));       this.add(kosten);
		this.add(gueltig);                            this.add(wVP/*wirdVerworfen*/); 
		this.add(new JLabel("Ausrede:"));             this.add(sAusrede);
	
		setEingabebereit(eingabebereit, hinzufuegen);
	}
	
	/** Aktiviert oder deaktiviert die Eingabebereitschaft der Felder
	 * 
	 * @param eingabebereit false: alle Komponenten werden unveränderbar angezeigt
	 *                      true: Felder sind Eingabebereit (siehe auch hinzufuegen)
	 * @param hinzufuegen   true: zum Hinzufügen ... alle Komponenten sind einabebereit
	 *                      false zum Ändern     ... das Feld Schlagwort ist nicht veränderbar
	 */
	public void setEingabebereit(boolean eingabebereit, boolean hinzufuegen)
	{
		if (eingabebereit && hinzufuegen) schlagwort.setEnabled(true);
		else                              schlagwort.setEnabled(false);
		beschreibung.setEnabled(eingabebereit);
		stimmenzuwachs.setEnabled(eingabebereit);
		kosten.setEnabled(eingabebereit);
		wirdVerworfen.setEnabled(eingabebereit);
		gueltig.setEnabled(eingabebereit);
		ausrede.setEnabled(eingabebereit);
	}
	
	public Wahlversprechen erzeugeWahlversprechen() throws NumberFormatException, WahlversprechenException
	{
		return new Wahlversprechen(schlagwort.getText(), 
								   beschreibung.getText(),
								   Float.parseFloat(stimmenzuwachs.getText()), 
								   Float.parseFloat(kosten.getText()),
								   (String)wirdVerworfen.getSelectedItem(),
								   gueltig.isSelected(),
								   ausrede.getText());
	}
	
	public void aktualisiereAnzeige(Wahlversprechen wv)
	{
		if (wv==null)
		{
			schlagwort.setText("");
			beschreibung.setText("");
			stimmenzuwachs.setText("");
			kosten.setText("");
			wirdVerworfen.setSelectedItem(Wahlversprechen.SOFORT);
			gueltig.setSelected(false);
			ausrede.setText("");
		}
		else
		{
			schlagwort.setText(wv.getSchlagwort());
			beschreibung.setText(wv.getBeschreibung());
			stimmenzuwachs.setText(String.valueOf(wv.getStimmenzuwachs()));
			kosten.setText(String.valueOf(wv.getKosten()));
			wirdVerworfen.setSelectedItem(wv.getWirdVerworfen());
			gueltig.setSelected(wv.isGueltig());
			ausrede.setText(wv.getAusrede());
			
		}
	}
}
