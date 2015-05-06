import java.io.*;
import java.util.*;

/**
 *  Model: Verwaltung der Kunstwerke
 */
public class Kunstsammlung 
{
	// Datenstruktur ist in diesem Beispiel ein HashSet, könnte aber auch eine ArrayList ... sein
	private HashSet<Kunstwerk> kunstwerke;
	
	/**
	 * Erzeugt eine leere Kunstsammlung
	 */
	public Kunstsammlung()
	{
		kunstwerke = new HashSet<Kunstwerk>();
	}
	
	/** Ankauf eines Kunstobjekts.
	 * 
	 * Bedingung: 
	 * Es darf noch kein Kunstwerk mit identischer Bezeichnung vorhanden sein 
	 *
	 * WICHTIG:
	 * Sichergestellt wird das bereits durch die add-Methode der Hashtable UND
	 * das Überschreiben der equals() und hashCode()-Methode (bezogen auf bezeichnung)
	 * in der Klasse Kunstwerk!!! 
	 * 
	 * @param kunstwerk das neue Kunstobjekt.
	 * @return true: Kunstwerk wurde erfolgreich hinzugefügt, 
	 *         false: wenn eine Nullreferenz übergeben wurde oder das Kunstwerk schon vorhanden ist
	 */
	public boolean ankaufen(Kunstwerk kunstwerk) 
	{
		if (kunstwerk!=null) // wird aber beim Aufruf vom GUI immer ungleich null sein
			return kunstwerke.add(kunstwerk);
		else
			return false;
	}
	
	/** Verleih eines Kunstobjekts
	 * 
	 * @param bezeichnung Die Bezeichnung des zu verleihenden Objekts.
	 * @return true: Status erfolgreich geändert
	 *         false: kein Kunstwerk mit dieser Bezeichnung vorhanden
	 */
	public boolean verleihen(String bezeichnung, boolean verliehen)
	{
		for(Kunstwerk k : kunstwerke)
		{
			if(k.getBezeichnung().equals(bezeichnung))   
			{
				k.setVerliehen(verliehen);
				return true;
			}
		}
		
		return false; // kein Kunstwerk mit dieser Bezeichnung gefunden
	}
	
	/** Liefert einen Text einer Liste mit allen Kunstwerken
	 * 
	 * @param alle true: alle - auch die verliehenen - Kunstwerke kommen in die Liste
	 *             false: nur verfügbare - also nicht verliehene -Kunstobjekte auflisten
	 *                       
	 * @return eine Liste der gewählten Kunstwerke als Text
	 */
	public String getListeAlsText(boolean alle)
	{
		StringBuilder text = new StringBuilder();
		
		for(Kunstwerk k : kunstwerke)
		{
			if(alle || !k.isVerliehen())
			{
				text.append(k.toString()).append(System.getProperty("line.separator"));	
			}
		}
		return text.toString();
	}
	
	/** Zählt die Kunstwerke
	 * @param alle true:  alle
	 *             false: nur verfügbare (nicht verliehene)
     *
	 * @return Anzahl aller Kunstwerke
	 */
	public int anzahlKunstwerke(boolean alle)
	{
		if(alle)
		{
			return kunstwerke.size();
		}
		else 
		{
			int count = 0;
			for(Kunstwerk k : kunstwerke)
			{
				if(!k.isVerliehen()) count++;
			}
			return count;
		}
	}
	
	
	/**
	 * Liest aus einer Datei die Daten ein.
	 * 
	 * @param filename Dateiname.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException  
	 */
	@SuppressWarnings("unchecked")
	public void einlesen(String filename) throws FileNotFoundException, IOException, ClassNotFoundException  
	{
		
		try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(filename));)
		{
			kunstwerke = (HashSet<Kunstwerk>) reader.readObject();
		}
		// catch-Block fehlt hier absichtlich, weil Exceptions weitergeleitet werden sollen
		
		// reader.close fehlt nicht, sondern wird automatisch ausgeführt - siehe Interface AutoClosable!
	}
	
	/**
	 * Speichert die Daten in eine Datei.
	 * 
	 * @param filename Dateiname
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void speichern(String filename) throws FileNotFoundException, IOException
	{
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(filename));)
		{
			writer.writeObject(kunstwerke);
		}
		// catch-Block fehlt hier absichtlich, weil Exceptions weitergeleitet werden sollen
		
		// writer.close fehlt nicht, sondern wird automatisch ausgeführt - siehe Interface AutoClosable!

/* Schreibweise vor Java 1.7:

 		ObjectOutputStream writer=null;
		try 
		{
			writer = new ObjectOutputStream(new FileOutputStream(filename));
			writer.writeObject(kunstwerke);
		}
		
		finally
		{
			if (writer!=null)  // wenn ein writer erzeugt wurde ... wird gerne vergessen ... NullpointerException
				writer.close();
		}
*/
	}
}
