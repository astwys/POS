import java.io.*;

/**
 *  Model: Einzelnes Objekt (Kunstwerk) das erfasst / eingefügt / ... werden soll 
 */
@SuppressWarnings("serial")
public class Kunstwerk implements Serializable
{
	private String bezeichnung;
	private boolean verliehen;
	private float wert;
	
	/** parameterloser Konstruktor, nur sinnvoll für Testzwecke (in der endgültigen Version z.B.: private deklarieren) 
	 * @throws KunstsammlungException (theoretisch) 
	 * */
	public Kunstwerk() throws KunstsammlungException
	{
		setBezeichnung("<Unbekannt>");
		setVerliehen(false);
		setWert(1000);
	}
	
	/** Konstruktor, ruft set-Methoden auf -> Prüfungen -> ev. Exception
	 * 
	 * @param bezeichnung ... muss vorhanden sein
	 * @param verliehen
	 * @param wert ... muss ein positiver Wert sein
	 * @throws KunstsammlungException bei Übergabe von unzulässigen Werten
	 */
	public Kunstwerk(String bezeichnung, boolean verliehen, float wert) throws KunstsammlungException
	{
		setBezeichnung(bezeichnung);
		setVerliehen(verliehen);
		setWert(wert);
	}

	/**
	 * @return Bezeichnung
	 */
	public String getBezeichnung() 
	{
		return bezeichnung;
	}
	
	/**
	 * @param bezeichnung zu verwendende Bezeichnung (muss angegeben werden)
	 * @throws KunstsammlungException bei Übergabe einer Nullreferenz oder eines Leerstrings
	 */
	public void setBezeichnung(String bezeichnung) throws KunstsammlungException
	{
		if (bezeichnung !=null && !bezeichnung.isEmpty())
			this.bezeichnung = bezeichnung;
		else
			throw new KunstsammlungException("Bezeichnung fehlt!");
	}

	/**
	 * @return true, falls das Kunstwerk verliehen ist
	 */
	public boolean isVerliehen() 
	{
		return verliehen;
	}

	/**
	 * @param verliehen true: das Kunstwerk ist verliehen
	 */
	public void setVerliehen(boolean verliehen)
	{
		this.verliehen = verliehen;
	}

	/**
	 * @return Wert des Bildes
	 */
	public float getWert()
	{
		return wert;
	}

	/**
	 * @param wert Wert des Kunstwerks 
	 * @throws KunstsammlungException bei Übergabe eines negativen Wertes
	 */
	public void setWert(float wert) throws KunstsammlungException
	{
		if (wert>=0)
			this.wert = wert;
		else
			throw new KunstsammlungException("Es ist nur ein Wert größer gleich 0 zulässig!");;
	}
	
	/**
	 * @return Text welcher das Objekt beschreibt
	 */
	@Override
	public String toString()
	{
		return getBezeichnung() + ", " 
			+ getWert() + "€,  verliehen: " + (isVerliehen() ? "ja" : "nein");
	}
//	@Override
	/** erforderlich für das Einfügen in eine Collection 
	 *  bzw. zum Vergleich anhand der Bezeichnung
	 *  Achtung: Override -> Übergabeparamtertyp nuss Object sein 
	 *
	 * @return true wenn die Bezeichnungen der beiden Kunstwerke gleich sind.
	 */

	public boolean equals(Object obj) 
	{
		Kunstwerk k = (Kunstwerk)obj;
		
		return getBezeichnung().equals(k.getBezeichnung());
	}

	/** erforderlich für das Einfügen in eine HashMap / Hashtable / HashSet 
	 *  Anmerkung: hier wird einfach der Hashcode der Bezeichnung verwendet
	 */

	@Override
	public int hashCode() 
	{
		return this.getBezeichnung().hashCode();
	}
}
