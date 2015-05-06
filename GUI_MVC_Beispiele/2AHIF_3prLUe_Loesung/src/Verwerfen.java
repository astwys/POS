/** Entwurf eines Aufzähltyps für den Gültigkeitszeitraum von Wahlversprechen
 * (nur testweise für mich, hat vorerst nichts mit der Lösung zu tun!)
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
	
	// alle möglichen Werte und Texte ausgeben:
	// for (Verwerfen v : Verwerfen.values())
    //		System.out.println(p + "..." + p.getText());
}
