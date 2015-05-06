package wahlversprechenLoesung;

/** Entwurf eines Aufz�hltyps f�r den G�ltigkeitszeitraum von Wahlversprechen
 * (nur testweise f�r mich, hat vorerst nichts mit der L�sung zu tun!)
 * 
 * @author Gerald Schildberger
 * @version 2015
 */
public enum Verwerfen
{
	SOFORT ("sofort"),
	IN_1_WOCHE ("in einer Woche"),
	IN_1_MONAT ("in einem Monat"),
	IN_1_JAHR  ("in einem Jahr");

	private String text;
	
	private Verwerfen(String text)
	{
		this.text = text;
	}
	
	public String getText()
	{
		return text;
	}
	
	// alle m�glichen Werte und Texte ausgeben:
	// for (Verwerfen v : Verwerfen.values())
    //		System.out.println(p + "..." + p.getText());
}
