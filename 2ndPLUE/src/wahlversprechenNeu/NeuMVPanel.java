package wahlversprechenNeu;

import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NeuMVPanel extends JPanel {
	JTextField schlagwort;
	JTextArea beschreibung;
	JTextField stimmenzuwachs;
	JComboBox wirdVerworfen;
	JCheckBox gueltig;
	JTextArea ausrede;
	JLabel indikator;
	
	public NeuMVPanel(boolean eingabebereit, boolean hinzufuegen) {
		// TODO Auto-generated constructor stub
		this.setLayout(new GridLayout(6,2));
		
		schlagwort=new JTextField(20);
		beschreibung=new JTextArea(40,4);
		JScrollPane sBeschreibung=new JScrollPane(beschreibung);
		stimmenzuwachs=new JTextField(5);
		String[] auswahl={NeuWahlversprechen.SOFORT,NeuWahlversprechen.IN_1_WOCHE, NeuWahlversprechen.IN_1_MONAT, NeuWahlversprechen.IN_1_JAHR};
		wirdVerworfen=new JComboBox(auswahl); wirdVerworfen.setName("wann verworfen");
		JPanel wVP=new JPanel();
		wVP.add(new JLabel("wird nach Wahl ungültig"));
		wVP.add(wirdVerworfen);
		gueltig=new JCheckBox("Wahlversprechen nich gültig");
		ausrede=new JTextArea(40,4);
		JScrollPane sAusrede=new JScrollPane(ausrede);
		
		this.add(new JLabel("Schlagwort: "));			this.add(schlagwort);
		this.add(new JLabel("Beschreibung: "));			this.add(sBeschreibung);
		this.add(new JLabel("Stimmenzuwachs [%]: "));	this.add(stimmenzuwachs);
		this.add(new JLabel("Ausrede: "));				this.add(sAusrede);
		
		setEingabebereit(eingabebereit, hinzufuegen);
	}
	
	public void setEingabebereit(boolean eingabebereit, boolean hinzufuegen) {
		if (eingabebereit && hinzufuegen) {
			schlagwort.setEnabled(true);
		}
		else {
			schlagwort.setEnabled(false);
			beschreibung.setEnabled(eingabebereit);
			stimmenzuwachs.setEnabled(eingabebereit);
			wirdVerworfen.setEnabled(eingabebereit);
			gueltig.setEnabled(eingabebereit);
			ausrede.setEnabled(eingabebereit);
		}
	}
	
	public NeuWahlversprechen erzeugeWahlversprechen() {
		return new NeuWahlversprechen(schlagwort.getText(), 
								beschreibung.getText(), 
								Float.parseFloat(stimmenzuwachs.getText()), 
								(String)wirdVerworfen.getSelectedItem(),
								gueltig.isSelected(),
								ausrede.getText());
	}
	
	public void aktualisiereAnzeige(NeuWahlversprechen wv) {
		schlagwort.setText(wv.getSchlagwort());
		beschreibung.setText(wv.getBeschreibung());
		stimmenzuwachs.setText(String.valueOf(wv.getStimmenzuwachs()));
		wirdVerworfen.setSelectedItem(wv.getWirdVerworfen());
		gueltig.setSelected(wv.isGueltig());
		ausrede.setText(wv.getAusrede());
	}
}
