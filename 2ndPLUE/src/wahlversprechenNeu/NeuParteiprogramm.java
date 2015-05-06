package wahlversprechenNeu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import javax.sound.sampled.Line;

import wahlversprechenLoesung.Wahlversprechen;

public class NeuParteiprogramm {
	private String parteiname;
	private float prozentStammwaehler;
	private ArrayList<NeuWahlversprechen> wunschliste;
	
	public NeuParteiprogramm(String parteiname, float prozenStammwaehler) throws NeuWahlversprechenException{
		// TODO Auto-generated constructor stub
		wunschliste=new ArrayList<NeuWahlversprechen>();
		setParteiname(parteiname);
		setProzentStammwaehler(prozentStammwaehler);
	}
	
	public String getParteiname() {
		return parteiname;
	}
	public void setParteiname(String parteiname) {
		this.parteiname = parteiname;
	}
	public float getProzentStammwaehler() {
		return prozentStammwaehler;
	}
	public void setProzentStammwaehler(float prozentStammwaehler) {
		this.prozentStammwaehler = prozentStammwaehler;
	}
	
	
	public void hinzufuegen(NeuWahlversprechen wv) throws NeuWahlversprechenException {
		if (wv==null || wunschliste.contains(wv)) throw new NeuWahlversprechenException("Dieses Wahlversprechen gibt es schon.");
		wunschliste.add(wv);
	}
	
	public boolean loeschen(String schlagwort) {
		Iterator<NeuWahlversprechen> it = wunschliste.iterator();
		
		while (it.hasNext()) {
			if (it.next().getSchlagwort().equals(schlagwort)) {
				it.remove(); 
				return true;
			}
		}
		return false;
	}
	
	public boolean loeschen(NeuWahlversprechen wv) {
		return wunschliste.remove(wv);
	}
	
	public NeuWahlversprechen getWahlversprechen(int index) {
		try {
			return wunschliste.get(index);
		} catch (IndexOutOfBoundsException ioobe) {
			// TODO: handle exception
			return null;
		}	
	}
	
	public int getAnzahlWahlversprechen() {
		return wunschliste.size();
	}
	
	public float berechneSummeStimmenzuwachs() {
		float summe=0;
		
		for(NeuWahlversprechen wv : wunschliste) {
			summe+=wv.getStimmenzuwachs();
		}
		
		return summe;
	}
	
	public String sortiereListeAlsText(String sortiertNach) throws NeuWahlversprechenException{
		ArrayList<Wahlversprechen> liste=new ArrayList(wunschliste);
		switch (sortiertNach) {
		case "alphabetisch": 
			Collections.sort(liste, new SchlagwortComparator());
			break;
		case "nach Kosten":
			Collections.sort(liste, new KostenComparator());
			break;
		case "nach Stimmen":
			Collections.sort(liste, new StimmenComparator());
			break;
		default:
			throw new NeuWahlversprechenException("Diese Funktion gibt es noch nicht");
		}
		
		StringBuilder sb=new StringBuilder();
		for (Wahlversprechen wv:liste) {
			sb.append(wv).append(System.getProperty("line.seperator"));
		}
		
		return sb.toString();
	}
	
	public class SchlagwortComparator implements Comparator<Wahlversprechen> {

		@Override
		public int compare(Wahlversprechen wv1, Wahlversprechen wv2) {
			// TODO Auto-generated method stub
			return wv1.getSchlagwort().compareTo(wv2.getSchlagwort());
		}
	}
	
	public class KostenComparator implements Comparator<Wahlversprechen> {

		@Override
		public int compare(Wahlversprechen wv1, Wahlversprechen wv2) {
			// TODO Auto-generated method stub
			return Float.compare(wv1.getKosten(), wv2.getKosten());
		}
	}
	
	public class StimmenComparator implements Comparator<Wahlversprechen> {

		@Override
		public int compare(Wahlversprechen wv1, Wahlversprechen wv2) {
			// TODO Auto-generated method stub
			return Float.compare(wv1.getStimmenzuwachs(), wv2.getStimmenzuwachs()); 
		}
	}
	
	public void speichern(String dateiname) {
		
		try (ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(dateiname));)
		{
			oos.writeObject(wunschliste);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void laden(String dateiname) {
		try (ObjectInputStream ois=new ObjectInputStream(new FileInputStream(dateiname));) 
		{
			wunschliste=(ArrayList<NeuWahlversprechen>) ois.readObject();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}