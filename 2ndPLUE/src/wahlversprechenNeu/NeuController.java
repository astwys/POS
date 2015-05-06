package wahlversprechenNeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import wahlversprechenLoesung.WahlversprechenException;

public class NeuController implements ActionListener {
	NeuViewMain view;
	NeuParteiprogramm model;
	private int index;
	
	public NeuController(NeuViewMain view, NeuParteiprogramm model) {
		// TODO Auto-generated constructor stub
		this.view=view;
		this.model=model;
		index=0;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "<":
			zurueck();
			break;
		case ">":
			vor();
			break;
		case "Hinzufügen":
			new NeuHinzufuegenFenster();
			break;
		case "Löschen":
			loeschen();
			break;
		case "alphabetisch":
		case "nach Stimmen":
			try {
				sortierteListe(e.getActionCommand());
				break;
			} catch (NeuWahlversprechenException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "Laden":
			laden();
			break;
		case "Speichern":
			speichern();
			break;
		default:
			break;
		}
	}
	
	public void zurueck() {
		if (index>0) {
			view.aktualisiereAnzeige(model.getWahlversprechen(--index));
		}
	}
	
	public void vor() {
		if (index<model.getAnzahlWahlversprechen()-1) {
			view.aktualisiereAnzeige(model.getWahlversprechen(++index));
		}
	}
	
	public void hinzufuegen(NeuWahlversprechen wv) throws NeuWahlversprechenException {
		model.hinzufuegen(wv);
		view.aktualisiereAnzeige(model.getWahlversprechen(index));
	}
	
	public void loeschen() {
		NeuWahlversprechen aktVersprechen=model.getWahlversprechen(index);
		
		if (aktVersprechen!=null && model.loeschen(aktVersprechen)) {
			if (index==model.getAnzahlWahlversprechen()) {
				index--;
			}
			
			aktVersprechen=model.getWahlversprechen(index);
			view.aktualisiereAnzeige(aktVersprechen);
		}
		else {
			view.zeigeFehlermeldung("Löschen nicht erflogreich");
		}
	}
	
	private void sortierteListe(String wonachSortieren) throws NeuWahlversprechenException {
		new NeuSortierteListeFenster(wonachSortieren, model.sortiereListeAlsText(wonachSortieren));
	}
	
	public void laden() {
		JFileChooser chooser=new JFileChooser();
		chooser.setSelectedFile(new File("Wahlversprechen.dat"));
		int result=chooser.showOpenDialog(view);
		
		if (result==JFileChooser.APPROVE_OPTION) {
			try {
				model.laden(chooser.getSelectedFile().getAbsolutePath());
				view.aktualisiereAnzeige(model.getWahlversprechen(index));
			}
			catch (Exception e) {
				view.zeigeFehlermeldung("Datei konnte nicht geladen werden");
			}
		}
	}
	
	public void speichern() {
		JFileChooser chooser = new JFileChooser();
		chooser.setSelectedFile(new File("Wahlversprechen.dat"));
		int result =chooser.showSaveDialog(view);
		
		if (result==JFileChooser.APPROVE_OPTION) {
			try {
				model.speichern(chooser.getSelectedFile().getAbsolutePath());
			} catch (Exception e) {
				// TODO: handle exception
				view.zeigeFehlermeldung("Datei konnte nicht gespeichert werden");
			}
		}
	}
	
	public void zeigeFehlerMeldung(String meldung) {
		view.zeigeFehlermeldung(meldung);
	}
}
