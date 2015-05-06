import java.io.*;
import java.util.*;

/** Model: Verwaltung der Wahlversprechen 
 * 		   (zugegeben ein etwas einfallsloses Parteiprogramm)
 *
 *   @author Gerald Schildberger
 *   @version 2015
*/
public class Parteiprogramm
{
	private String parteiname;
	private float prozentStammwaehler;
	private ArrayList<Wahlversprechen> wunschliste;
	// ... und was immer ein Parteiprogramm sonst noch enth�lt 
	//     (nicht Thema dieser Leistungs�berpr�fung) 

	/**
	 * @return parteiname
	 */
	public String getParteiname()
	{
		return parteiname;
	}
	
	/**
	 * @param parteiname 
	 */
	public void setParteiname(String parteiname)
	{	// stellt nur sicher, dass keine Null-Referenz als Name gesetzt wird
		if (parteiname==null) parteiname = ""; 
		this.parteiname = parteiname;
	}
	
	/**
	 * @return prozentStammwaehler Stimmenanteil bei einer Wahl ohne Wahlversprechen
	 */
	public float getProzentStammwaehler()
	{	
		return prozentStammwaehler;
	}
	
	/**
	 * @param prozentStammwaehler ein Wert zwischen 0% und 100% 
	 */
	public void setProzentStammwaehler(float prozentStammwaehler)
	{
		// nur ein g�ltiger Wert bewirkt eine �nderung
		if (prozentStammwaehler>=0 && prozentStammwaehler<100)
			this.prozentStammwaehler = prozentStammwaehler;
	}

	// -------- bitte eigene Erweiterungen ab hier einf�gen --------	

	/** �bernimmt Parteiname, Prozentwert der Stammw�hler und erzeugt die interne Liste
	 *   
	 * @param parteiname
	 * @param prozentStammwaehler
	 */
	public Parteiprogramm(String parteiname, float prozentStammwaehler)
	{
		setParteiname(parteiname);
		setProzentStammwaehler(prozentStammwaehler);
		wunschliste = new ArrayList<Wahlversprechen>();
	}
		
	/** F�gt in Wahlversprechen hinzu 
	 * 
	 * @param wv Wahlversprechen
	 * @throws WahlversprechenException es wurde eine Nullreferenz �bergeben 
	 *                                  oder es gibt schon einen Eintrag mit diesem Schlagwort
	 */
	public void hinzufuegen(Wahlversprechen wv) throws WahlversprechenException
	{
		if (wv==null || wunschliste.contains(wv))
		{
			throw new WahlversprechenException("Es gibt schon ein Wahlversprechen mit diesem Schlagwort!");
		}
		// (diese Pr�fung h�tte ich selbst beinahe �bersehen ;-)
		if (100<(prozentStammwaehler+berechneSummeStimmenzuwachs()+wv.getStimmenzuwachs()) )
		{
			throw new WahlversprechenException("Mit diesem Wahversprechen l�ge der Stimmanteil �ber 100%!");
		}
		wunschliste.add(wv);
	}
	
	/** in meiner L�sung nicht erforderlich, dass ist aber nur eine Beta-L�sung
	 * 
	 * @param wvNeu 
	 */
	public void aendern(Wahlversprechen wvNeu) 
	{
		// nicht erforderlich, wenn der GUI eine Referenz auf das originale Objekt �bergeben bekommt
		// und direkt �ndert (der Grund weshalb Wahversprechen keine public setSchalgwort() enth�lt!)
	}
	
	/** L�scht das Wahlversprechen mit dem angegebenen Schlagwort
	 * 
	 * @param schlagwort
	 * @return true wenn erfolgreich, false wenn kein entsprechender Eintrag gefunden wurde
	 */
	public boolean loeschen(String schlagwort) 
	{
		Iterator<Wahlversprechen> it = wunschliste.iterator();
		while (it.hasNext())
		{
			if (it.next().getSchlagwort().equals(schlagwort))
			{
				it.remove();
				return true;
			}
		}
		return false;		
	}
	
	/** L�scht das betreffende Objekt - funktioniert nat�rlich nur mir der orig. Referenz
	 * 
	 * @param wv Referenz auf ein Objekt der internen Liste
	 * @return true wenn erfolgreich
	 */
	public boolean loeschen(Wahlversprechen wv)
	{
		return wunschliste.remove(wv);
	}
	
	/** Liefert eine Referenz auf das Wahlversprechen-Objekt das in der internen Liste 
	 * unter dem angegebenen Index zu finden ist. (Achtung: erm�glicht direkte �nderungen!)
	 * 
	 * @param index wird �berpr�ft (zul�ssig: 0 bis < getAnzahlWahlversprechen())
	 * @return Referenz auf den entsprechenden Eintrag 
	 *         bzw. eine Nullreferenz bei ungl�ltigem Index!
	 */
	public Wahlversprechen getWahlversprechen(int index) 
	{
		try
		{
			return wunschliste.get(index);
		}
		catch (IndexOutOfBoundsException ioobe)
		{
			return null;
		}
	}
	
	/**
	 * @return Anzahl der eingetragenen Wahlversprechen
	 */
	public int getAnzahlWahlversprechen()
	{
		return wunschliste.size();
	}

	/** 
	 * @return die Summe der Stimmenzuw�chse aller Wahlversprechen
	 */
	public float berechneSummeStimmenzuwachs()
	{
		float summe = 0;
		for (Wahlversprechen wv : wunschliste)
		{
			summe+=wv.getStimmenzuwachs();
		}
		return summe;
	}
	
	/**  
	 * @param sortiertNach m�gliche Werte: "alphabetisch", "nach Kosten", "nach Stimmen"
	 * @retun eine sortierte Liste aller Wahlversprechen in Textform
	 */
	public String getSortierteListeAlsText(String sortiertNach)
	{
		ArrayList<Wahlversprechen> liste = new ArrayList(wunschliste);
		switch (sortiertNach)
		{
			case "alphabetisch": Collections.sort(liste, new SchlagwortComparator()); break;
			case "nach Kosten":  Collections.sort(liste, new KostenComparator()); break;
			case "nach Stimmen": Collections.sort(liste, new StimmenComparator()); break;
		}
		
		StringBuilder sb = new StringBuilder();
		for (Wahlversprechen wv : liste)
		{
			sb.append(wv).append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}
	
	/** Comparator zum Vegleich bez�glich Schlagwort
	 * (hier als innere Klasse, ist aber kein Muss)
	 */
	private class SchlagwortComparator implements Comparator<Wahlversprechen>
	{
		@Override
		public int compare(Wahlversprechen wv1, Wahlversprechen wv2)
		{
			return wv1.getSchlagwort().compareTo(wv2.getSchlagwort());
		}
	}
	
	/** Comparator zum Vegleich bez�glich Kosten
	 * (hier als innere Klasse, ist aber kein Muss)
	 */
	private class KostenComparator implements Comparator<Wahlversprechen>
	{
		@Override
		public int compare(Wahlversprechen wv1, Wahlversprechen wv2)
		{
			return Float.compare(wv1.getKosten(), wv2.getKosten());
		}
	}
	
	/** Comparator zum Vegleich bez�glich Stimmenzuwachs
	 * (hier als innere Klasse, ist aber kein Muss)
	 */
	private class StimmenComparator implements Comparator<Wahlversprechen>
	{
		@Override
		public int compare(Wahlversprechen wv1, Wahlversprechen wv2)
		{
			return Float.compare(wv1.getStimmenzuwachs(), wv2.getStimmenzuwachs());
		}
	}
	
	
	/**
	 * Liest aus einer Datei die Liste der Wahlversprechen ein 
	 * (nicht eingelesen werden andere Attribute wie Parteiname, ...)
	 * 
	 * @param filename Dateiname.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException  
	 */
	@SuppressWarnings("unchecked")
	public void laden(String filename) throws FileNotFoundException, IOException, ClassNotFoundException  
	{
		
		try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(filename));)
		{
			wunschliste = (ArrayList<Wahlversprechen>) reader.readObject();
		}
		// catch-Block fehlt hier absichtlich, weil Exceptions weitergeleitet werden sollen
		// reader.close fehlt nicht, sondern wird automatisch ausgef�hrt - siehe Interface AutoClosable!
	}
	
	/** Speichert die Liste der Wahlversprechen in eine Datei
	 * (nicht eingspeichert werden andere Attribute wie Parteiname, ...)	  
     *  
	 * @param filename Dateiname
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void speichern(String filename) throws FileNotFoundException, IOException
	{
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(filename));)
		{
			writer.writeObject(wunschliste);
		}
	}
}
