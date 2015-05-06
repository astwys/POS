package wahlversprechenLoesung;

import java.io.*;

/** Model: Einzelnes Objekt (Wahlversprechen)
 * 
 *   @author Gerald Schildberger
 *   @version 2015
 */
@SuppressWarnings("serial")
public class Wahlversprechen implements Serializable 
{
	/** m�gliche Werte f�r das Aufl�sen von Wahlversprechen" */
	public static final String SOFORT = "sofort";
	public static final String IN_1_WOCHE = "in einer Woche";
	public static final String IN_1_MONAT = "in einem Monat";
	public static final String IN_1_JAHR = "in einem Jahr";
	// (Enumeration w�re sch�ner, haben wir aber nicht gelernt)
	
	private String schlagwort;      // eindeutig & darf nicht leer sein 
	private String beschreibung;    // darf nicht leer sein
	private float stimmenzuwachs;   // in Prozent
	private float kosten;           // in � (nur hier, bei der PL� nicht in der Angabe!)
	private String wirdVerworfen;   // erlaubte Werte: SOFORT ... IN_1_JAHR;
	private boolean gueltig;        // true: Wahlversprechen wird eingehalten
	private String ausrede;         // darf nicht leer sein, wenn gueltig == false;
	
	public Wahlversprechen(	String schlagwort, String beschreibung, 
							float stimmenzuwachs, float kosten, 
							String wirdVerworfen, boolean gueltig, String ausrede) 
		throws WahlversprechenException
	{
		setSchlagwort(schlagwort);
		setBeschreibung(beschreibung);
		setStimmenzuwachs(stimmenzuwachs);
		setKosten(kosten);
		setWirdVerworfen(wirdVerworfen);
		setGueltig(gueltig, ausrede); 
	}

	/**
	 * @return schlagwort
	 */
	public String getSchlagwort()
	{
		return schlagwort;
	}
	
	/**
	 * @param schlagwort eindeutiger, kurzer Text, darf nicht leer sein und kann nachtr�glich nicht ge�ndert werden
	 * @throws WahlversprechenException wenn schlagwort leer oder null 
	 */
	private void setSchlagwort(String schlagwort) throws WahlversprechenException
	{
		if (schlagwort == null || schlagwort.isEmpty()) 
			throw new WahlversprechenException("Schlagwort muss angegeben werden!");
		this.schlagwort = schlagwort;
	}
	
	/**
	 * @return beschreibung
	 */
	public String getBeschreibung()
	{
		return beschreibung;
	}
	
	/**
	 * @param beschreibung detaillierte Beschreibgun, darf nicht leer sein 
	 * @throws WahlversprechenException wenn beschreibung leer oder null
	 */
	public void setBeschreibung(String beschreibung) throws WahlversprechenException
	{
		if (beschreibung == null || beschreibung.isEmpty()) 
			throw new WahlversprechenException("Beschreibung muss angegeben werden!");
		this.beschreibung = beschreibung;
	}
	
	/**
	 * @return stimmenzuwachs in Prozent
	 */
	public float getStimmenzuwachs()
	{
		return stimmenzuwachs;
	}
	
	/**
	 * @param stimmenzuwachs in Prozent (muss >0 und <=100 % sein)
	 * @throws WahlversprechenException wenn kein g�ltiger Prozentwert
	 */
	public void setStimmenzuwachs(float stimmenzuwachs) throws WahlversprechenException
	{
		if (stimmenzuwachs<=0 || stimmenzuwachs>100)
			throw new WahlversprechenException("Bitte nur Wahlversprechen, die mehr als 0% und max. 100% Stimmenzuwachs bringen!");
		this.stimmenzuwachs = stimmenzuwachs;
	}
	
	/**
	 * @return kosten in Mio.�
	 */
	public float getKosten()
	{
		return kosten;
	}
	
	/**
	 * @param kosten in Mio.�, beliebiger (auch negativer) Wert m�glich
	 */
	public void setKosten(float kosten)
	{
		this.kosten = kosten;
	}
	
	/**
	 * @return wirdVerworfen m�gliche R�ckgabewerte: Wahlversprechen.SOFORT, 
	 *                                               Wahlversprechen.IN_1_WOCHE, 
	 *                                               Wahlversprechen.IN_1_MONAT, 
	 *                                               Wahlversprechen.IN_1_JAHR
	 */
	public String getWirdVerworfen()
	{
		return wirdVerworfen;
	}
	
	/**
	 * @param wirdVerworfen wann nach der Wahl wird das Wahlversprechen verworfen
	 *        zul�ssige Werte: Wahlversprechen.SOFORT, 
	 *                         Wahlversprechen.IN_1_WOCHE, 
	 *                         Wahlversprechen.IN_1_MONAT, 
	 *                         Wahlversprechen.IN_1_JAHR
	 * @throws WahlversprechenException wenn keiner der vier zul�ssigen Texte (Zeitr�ume) angegeben wird
	 */
	public void setWirdVerworfen(String wirdVerworfen) throws WahlversprechenException
	{
		if (wirdVerworfen==null || !(wirdVerworfen.equals(Wahlversprechen.SOFORT)     ||  
									 wirdVerworfen.equals(Wahlversprechen.IN_1_WOCHE) ||
									 wirdVerworfen.equals(Wahlversprechen.IN_1_MONAT) ||
									 wirdVerworfen.equals(Wahlversprechen.IN_1_JAHR)     ))
			throw new WahlversprechenException("Es muss ein g�ltiger Zeitraum f�r das Aufl�sen des Wahlversprechens angegeben werden!");
		this.wirdVerworfen = wirdVerworfen;
	}
	
	/**
	 * @return gueltig true: das Wahlversprechen ist noch aktuell, false: es wurde bereits verworfen
	 */
	public boolean isGueltig()
	{
		return gueltig;
	}
	
	/**
	 * @return ausrede
	 */
	public String getAusrede()
	{
		return ausrede;
	}

	/**
	 * @param gueltig true: das Wahlversprechen ist noch aktuell, es muss keine Ausrede angegeben werden
	 *                false: das Wahlversprechen ist verworfen, es muss eine Ausrede angegeben werden!
	 * @throws WahlversprechenException wenn gueltig==false gesetzt ist und keine Ausrede angegeben wird
	 *                                  oder keine Ausrede angegeben ist und gueltig=false gesetzt werden soll
	 */
	public void setGueltig(boolean gueltig, String ausrede) throws WahlversprechenException
	{
		if (!gueltig && (ausrede==null || ausrede.isEmpty()))
			throw new WahlversprechenException("F�r ein verworfenes Wahlversprechen muss eine Ausrede angegeben werden!");
		
		this.gueltig = gueltig;
		this.ausrede = ausrede;
	}

	@Override
	public String toString()
	{
		return "Schlagwort: " + schlagwort + ", Beschreibung: " + beschreibung 
				+ ", Simmenzuwachs: " + stimmenzuwachs +"%, Kosten=" + kosten 
				+ "�, noch g�ltig: " + ((gueltig)?"ja":"nein") + ", wird verworfen: " + wirdVerworfen 
				+ ", Ausrede: " + ((ausrede!=null)?ausrede:"(fehlt)");
	}

	
	// -------- bitte eigene Erweiterungen ab hier einf�gen --------	

	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((schlagwort == null) ? 0 : schlagwort.hashCode());
		return result;
	}

	/* vergleich bez�glich Schlagwort
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (!(obj instanceof Wahlversprechen))
		{
			return false;
		}
		Wahlversprechen other = (Wahlversprechen) obj;
		if (schlagwort == null)
		{
			if (other.schlagwort != null)
			{
				return false;
			}
		} else if (!schlagwort.equals(other.schlagwort))
		{
			return false;
		}
		return true;
	}
}
