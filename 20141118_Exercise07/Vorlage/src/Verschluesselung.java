import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**Klasse welche alle wesentlichen Methoden zur Verschlüsselung, Entschlüssungen und
 * für den Vergleich der Ergebnisse enthält. Zusätzlich werden auch alle Einstellungen, 
 * sowie die Buchstabenzuordnung (der eigentliche Schlüssel) in Properties-Objekten gehalten.
 * 
 * Zum Entschlüsseln erzeugt man sich am besten eine Tabelle wo key / value vertauscht sind.
 * 
 * @author <bitte eigenen Namen eingeben>
 * @version 2014-11-18
 */
public class Verschluesselung 
{
	Properties dateinamen;		 // Tabelle mit den Programmeinstellungen (Dateinamen), siehe getDateiname(...)
	Properties code;             // Tabelle mit der Buchstabenzuordnung zum Verschlüsseln
	Properties decode;           // Tabelle mit der umgedrehten Buchstabenzuordnung zum Entschlüsseln
	
	/** Initialisiert die Properties-Objekte (Dateinamen, Code-Tabellen) 
	 * @param configuration Name der Datei welche die Dateinamen enthält 
	 */
	public Verschluesselung(String configuration)
	{
		dateinamen = new Properties();
		//...
	}
	
	/** Parameterloser Konstruktor - liest die Einstellungen aus der Datei "verschluesselung.conf" im aktuellen Projektordner */
	public Verschluesselung()
	{
		this("verschluesselung.conf");
	}
	
	/** Liefert die Einsellungen bzw. Dateinamen, eingelesen aus "verschluesselung.conf" 
	 * 
	 * @param typ mögliche Werte: "original", "schluessel", "codiert" und "decodiert"
	 * @return die entsprechenden Dateinamen 
	 */
	public String getDateiname(String typ)
	{
		return this.dateinamen.getProperty(typ);
	}

	
	/** Diese Methode durchläuft alle Kleinbuchstaben (inkl. der Umlaute) und generiert 
	 * entsprechende großgeschriebene key-value-Paare.
	 * 
	 *  Achtung: Leider funktioniert es nicht, mittels Enumerator alle keys zu durchlaufen und 
	 *           gleichzeitig die zusätzlichen Einträge einzufügen. Da es sich im Grunde um eine 
	 *           Hashtabelle handeld, werden die neuen Einträge und die Ursprünglichen durchmischt
	 *           und der Enumerator druchläuft dadurch nicht mehr alle ursprünglichen Einträge!!!
	 *           Erkannbar ist das daran, dass am Ende nicht doppelt soviel Einträge vorhanden sind.
	 * Abhilfe:  Die Paare für die Großbuchstaben werden in einer eigenen Tabelle eingefügt und diese
	 *           erst nach dem Durchlauf in die Tabelle der Kleinbuschstaben hinzugefügt.         
	 */
	private void erweitereCodeTabelle()
	{
		/* Mann kan die Zuordnungen für Großbuchstaben natürlich auch aus der Datei einlesen,
		 * dann entfällt diese Methode. Ich wollte aber nicht die doppelte Einträge in der Datei stehen haben,
		 * wenn man diese auch automatisch generieren kann. D.h. wer's schafft,...
		 */

		//...
	}
	
	/** Erzeugt eine umgekehrte Buchstabenzuordnung zum Entschlüsseln und speichert sie im Attribut "decode" */
	private void tauscheKeyValue()
	{
		/* erzeugt baisiernd auf den Zuordnungen in "code" eine umgedrehte Tabelle "decode" für die Entschlüsselung.
		 * Auch diese könnte man aus einer eigenen Datei einlesen. So ist es aber einfacher und Zuverlässiger.
		 */

		//...
	}

	
	/** Ersetzt jeden Buchstaben im Übergebenen Text durch seinen zugeordneten (Tabelle "code") und gibt den neuen Text zurück.
	 * Zur Optimierung, werden nicht String-Objekte verwendet sondern der Text wird in StringBuilder-Objekten gespeichert, die
	 * im Gegensatz zu String-Objekten veränderbar sind und nicht bei jeder Änderung neu instanziert werden müssen.
	 * 
	 * @param text der zu verschlüsselnde Text
	 * @return der verschlüsselte Text
	 */
	public StringBuilder codieren(StringBuilder text)
	{
		//...
		return new StringBuilder(); // nur eine Hilfslösung, damit das Programm übersetzbar ist, gibt "leeren" Text zurück!
	}


	/** Das Entschlüsseln funktioniert genauso wie das Verschlüsseln, nur statt der Zuordnungstabelle "code" wird die 
	 * umgekehrte Tabelle "decode" verwendet.
	 * 
	 * @param text zu entschlüsselnder Text
	 * @return entschlüsselter Text
	 */
	public StringBuilder decodieren(StringBuilder text)
	{
		//...

		return new StringBuilder(); // Hilfslösug (siehe oben)
	}

	
	/** Schreibt den übergebenen Text in die angegebene Datei - ev. vorhandener Text wird dabei überschrieben 
	 * 
	 * @param dateiname Pfad- / Dateiname zum Schreiben des Textes
	 * @param text zu schreibender Text 
	 */
	  
	public void schreibeText(String dateiname, StringBuilder text) 
	{
		//...
	}
	
	/** Liest einen Text aus der angegebene Datei. 
	 * 
	 * @param dateiname Pfad- / Dateiname zum Lesen des Textes
	 * @return gelesener Text bzw. ein leeres StringBuilderObjekt im Fehlerfall 
	 */
	public StringBuilder leseText(String dateiname)
	{
		//...

		return new StringBuilder(); // Hilfslösug (siehe oben)
	}
	
	/** Diese Methode öffnet gleichzeitig 2 Streams zum Lesen von beiden Dateien und 
	 * vergleicht zeichenweise die eingelesenen Buchstaben.
	 * Sobald ein Unterschied erkannt wird, oder das Dateiende erreicht wird, endet die Leseschleife.
	 *  
	 * @param dateiname1
	 * @param dateiname2
	 *
	 * @return true, wenn die beiden Dateien zeichenweise übereinstimmen, sonst false
	 */
	public boolean vergleich1(String dateiname1, String dateiname2)
	{
		/* Diese Variante ist laut Angabe zu realisieren ! */

		//...
		
		return false; // Hilfslösung
	}
	
	/** Die zweite Methode liest den Text von beiden Dateien ein und führt anschließend einen Vergleich der
	 * Textobjekte durch. Nachteil: auch wenn sich bereits das erste Zeichen unterscheidet, werden beide Texte
	 * vollständig eingelesen. 
	 *  
	 * @param dateiname1
	 * @param dateiname2
	 *
	 * @return true, wenn die Texte beider Dateien übereinstimmen, sonst false
	 */
	public boolean vergleich2(String dateiname1, String dateiname2)
	{
		StringBuilder text1;
		StringBuilder text2;
		
		text1 = leseText(dateiname1);
		text2 = leseText(dateiname2);

		return text1.toString().equals(text2.toString());
		
		// Anmerkung: die equals()-Methode von StringBuilder ist die von Object geerbte, d.h. liefert nur beim selben Objekt true.
		//            Enthalten zwei StringBuilder-Objekte den gleichen Text liefert equals() false!!!
		// Abhilfe: in Strings umwandeln, dessen equals()-Methode hat das gewünschte verhalten (vergleicht die Inhalte, nicht die Referenzen)
	}
}
