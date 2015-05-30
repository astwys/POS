package data;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * @author Jonas Neumair
 *
 */
public class Firma {

	private String name;
	private ArrayList<Mitarbeiter> mitarbeiter;
	
	public static final String ABTEILUNGSLEITER="Abteilungsleiter";
	public static final String TEILZEITANGESTELLTER="Teilzeitangestellter";
//	public static final String ABTEILUNGSLEITER="Abteilungsleiter";
//	public static final String ABTEILUNGSLEITER="Abteilungsleiter";
	
	
	
	/**
	 * @param name
	 * @param mitarbeiter
	 */
	public Firma(String name) {
		super();
		this.name = name;
		this.mitarbeiter=new ArrayList<Mitarbeiter>();
	}
	
	public void einstellen(Mitarbeiter m) throws CompanyExceptions{
		if(m == null) {
			throw new CompanyExceptions("Mitarbeiter ist null!");
		}
		else if(mitarbeiter.contains(m)) {
			throw new CompanyExceptions("Mitarbeiter wurde schon hinzugef�gt!");
		}
		mitarbeiter.add(m);
	}
	
	public boolean entlassen(String szvnr) throws CompanyExceptions{
		Iterator<Mitarbeiter> it = mitarbeiter.iterator();
		while (it.hasNext()) {
			if(it.next().getSozVersNr().equals(szvnr)) {
				it.remove();
				return true;
			}
		}
		throw new CompanyExceptions("Sozialversicherungsnummer nicht gefunden!");
		
	}
	
	public void printMitarbeiter(float gehalt){
		int i=0;
		for(Mitarbeiter m:mitarbeiter){
			if(m.berechneGehalt()>=gehalt){
				m.printInfo();
				i++;
			}
		}
		if(i==0){
			for(Mitarbeiter m1:mitarbeiter){
				m1.printInfo();
			}
		}
	}
	
	public String returnMitarbeiter(){
		StringBuilder mit = new StringBuilder();
			for(Mitarbeiter m:mitarbeiter){
				mit.append(m.toString()+"\n");
			}
		return mit.toString();
	}
	
	public String returnOnlyAbteilungsleiter(){
		Abteilungsleiter a = new Abteilungsleiter("daf", "2323", 2323, 2323);
		StringBuilder mit = new StringBuilder();
			for(Mitarbeiter m:mitarbeiter){
				if(m.getClass().isInstance(a))
					mit.append(m.toString()+"\n");
			}
		return mit.toString();
	}
	
	public String sucheMitarbeiter(String name) throws CompanyExceptions{
		StringBuilder sb = new StringBuilder();
		for(Mitarbeiter m:mitarbeiter){
			if(m.getName().compareTo(name)==0){
				sb.append(m.toString()+"\n");
			}
		}
		if(sb.length()==0) {
			throw new CompanyExceptions("Mitarbeiter nicht gefunden!");
		}
		return sb.toString();
	}
	
	public void speichern(String filename) throws FileNotFoundException, IOException {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(mitarbeiter);
		}	
	}
	
	public void laden(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			mitarbeiter = (ArrayList<Mitarbeiter>) ois.readObject();
		}
	}
	
	public int size() {
		return mitarbeiter.size();
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the mitarbeiter
	 */
	public ArrayList<Mitarbeiter> getMitarbeiter() {
		return mitarbeiter;
	}
	/**
	 * @param mitarbeiter the mitarbeiter to set
	 */
	public void setMitarbeiter(ArrayList<Mitarbeiter> mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}
	
	
}
