package gui;

import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import data.Angestellter;
import data.CompanyException;
import data.Firma;
import data.Mitarbeiter;

public class Model implements Serializable{
	
	private Firma firma;
	private View view;
	private ArrayList<Mitarbeiter> liste;
	
	public Model(View view) {
		// TODO Auto-generated constructor stub
		firma = new Firma("Bartl AG");
		liste= new ArrayList<Mitarbeiter>(firma.returnMitarbeiter());
		this.view=view;
	}
	
	public void einstellen(Angestellter a) throws CompanyException {
		firma.einstellen(a);
	}
	
	public void aktualisieren() throws CompanyException {
		int min=Integer.MIN_VALUE;

		view.aktualisiere(firma.printMitarbeiter(min), anzahlMitarbeiter());
	}
	
	public void entlassen(String sozNr) throws CompanyException {
		firma.entlassen(sozNr);
	}
	
	public void suchen(String name) throws CompanyException {
		view.showMitarbeiter(firma.sucheMitarbeiter(name));
	}
	
	public int anzahlMitarbeiter() {
		return firma.firmengröße();
	}
	
	public void laden(String filename) throws FileNotFoundException, IOException, ClassNotFoundException{
		try (ObjectInputStream reader=new ObjectInputStream(new FileInputStream(filename));) {
			liste= (ArrayList<Mitarbeiter>) reader.readObject();
			firma.setMitarbeiter(liste);
		}
	}
	
	public void speichern(String filename) throws FileNotFoundException, IOException {
//		liste = new ArrayList<Mitarbeiter>(firma.returnMitarbeiter());
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(filename));) {
			liste= new ArrayList<Mitarbeiter>(firma.returnMitarbeiter());
//			int i=0;
//			java.util.Iterator<Mitarbeiter> it=liste.iterator();
//			while(it.hasNext()) {
//				if(it.next()!=null) {
//					writer.writeObject(liste.get(i));
//				}
//			}
//			writer.writeObject(liste);
			
			
			writer.writeObject(liste);
		}
	}
}
