package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.JFileChooser;

import data.Angestellter;
import data.CompanyException;
import data.Mitarbeiter;

public class Controller implements ActionListener, Serializable {

	private View view;
	private Model model;
	private ViewEinstellen einstellen;
	private ViewEntlassen entlassen;
	private ViewSuchen suchen;
	
	public Controller(View view) {
		// TODO Auto-generated constructor stub
		this.view = view;
		model = new Model(view);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "Laden": 
				laden();
				break;
			case "Speichern":
				speichern();
				break;
			case "Einstellen": 
				einstellen=new ViewEinstellen(this);
				break;
			case "Entlassen":
				entlassen=new ViewEntlassen(this);
				
				break;
			case "Suchen":
				suchen=new ViewSuchen(this);
				break;
			case "Abbrechen":
				einstellen.dispose();
				break;
			case "Jetzt entlassen":
			try {
				model.entlassen(entlassen.sozNrEntlassen());
				model.aktualisieren();
			} catch (CompanyException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
				view.showErrorMessage(e2.getMessage());
			}
				entlassen.dispose();
			case "Nicht Entlassen":
				entlassen.dispose();
				break;
			case "Annehmen":
				Angestellter a= einstellen.speichern();
					try {
						model.einstellen(a);
						model.aktualisieren();
//						view.aktualisiere();
					} catch (CompanyException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						view.showErrorMessage(e1.getMessage());
					}
				einstellen.dispose();
				break;
			case "Jetzt Suchen":
					try {
						model.suchen(suchen.returnName());
					} catch (CompanyException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						view.showErrorMessage(e1.getMessage());
					}
					suchen.dispose();
				break;
			case "nicht suchen":
				suchen.dispose();
				break;
			default: 
				break;
		}	
	}
	
	public void hinzufuegen(Angestellter a) throws CompanyException {
		model.einstellen(a);
	}
	
	public void laden() {
		JFileChooser chooser=new JFileChooser();
		chooser.setSelectedFile(new File("Mitarbeiter.dat"));
		int result = chooser.showOpenDialog(view);
		
		if (result==JFileChooser.APPROVE_OPTION) {
			try {
				model.laden(chooser.getSelectedFile().getAbsolutePath());
				model.aktualisieren();
			} catch (Exception e) {
				// TODO: handle exception
				view.showErrorMessage("Datei konnte nicht geladen werden."+e.getMessage());
			}
		}
	}
	
	public void speichern() {
		JFileChooser chooser = new JFileChooser();
		chooser.setSelectedFile(new File("Mitarbeiter.dat"));
		int result = chooser.showSaveDialog(view);
		
		if (result==JFileChooser.APPROVE_OPTION) {
			try {
				model.speichern(chooser.getSelectedFile().getAbsolutePath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				view.showErrorMessage("Datei konnte nicht gespeichert werden."+ e.getMessage());
			}
		}
	}
}
