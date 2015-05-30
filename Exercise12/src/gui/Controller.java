package gui;

import data.Firma;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class Controller implements ActionListener {

	private Firma model;
	private View view;
	
	public Controller(Firma model, View view) {
		this.model = model;
		this.view = view;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch (arg0.getActionCommand()) {
			case "Speichern":
				speichern();
				break;
			case "Laden":
				laden();
				break;
			case "Anstellen":
				new ViewEinstellen(this.view, this.model);
				break;

			case "Entlassen":
				new ViewEntlassen(this.view, this.model);
				break;
			case "Suchen":
				new ViewSuchen(this.view, this.model);
				break;

			default:
				break;
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
				// e.printStackTrace();
				view.showErrorMessage("Datei konnte nicht gespeichert werden.", e.getMessage());
			}
		}
	}

	public void laden() {
		JFileChooser chooser=new JFileChooser();
		chooser.setSelectedFile(new File("Mitarbeiter.dat"));
		int result = chooser.showOpenDialog(view);

		if (result==JFileChooser.APPROVE_OPTION) {
			try {
				model.laden(chooser.getSelectedFile().getAbsolutePath());
				view.refreshView();
			} catch (Exception e) {
				// TODO: handle exception
				view.showErrorMessage("Datei konnte nicht geladen werden.", e.getMessage());
			}
		}
	}
}
