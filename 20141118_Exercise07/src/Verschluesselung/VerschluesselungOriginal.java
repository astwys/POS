package Verschluesselung;
import Verschluesselung.Leser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**Klasse welche alle wesentlichen Methoden zur Verschl�sselung, Entschl�ssungen und
 * f�r den Vergleich der Ergebnisse enth�lt. Zus�tzlich werden auch alle Einstellungen, 
 * sowie die Buchstabenzuordnung (der eigentliche Schl�ssel) in Properties-Objekten gehalten.
 * 
 * Zum Entschl�sseln erzeugt man sich am besten eine Tabelle wo key / value vertauscht sind.
 * 
 * @author <bitte eigenen Namen eingeben>
 * @version 2014-11-18
 */
public class VerschluesselungOriginal 
{
	Properties dateinamen;		 // Tabelle mit den Programmeinstellungen (Dateinamen), siehe getDateiname(...)
	Properties code;             // Tabelle mit der Buchstabenzuordnung zum Verschl�sseln
	Properties decode;           // Tabelle mit der umgedrehten Buchstabenzuordnung zum Entschl�sseln
	
	/** Initialisiert die Properties-Objekte (Dateinamen, Code-Tabellen) 
	 * @param configuration Name der Datei welche die Dateinamen enth�lt 
	 */
	public VerschluesselungOriginal(String configuration)
	{
		dateinamen = new Properties();
		code = new Properties();
		decode = new Properties();
		//...
	}
	
	/** Parameterloser Konstruktor - liest die Einstellungen aus der Datei "verschluesselung.conf" im aktuellen Projektordner 
	 * @throws Exception */
	public VerschluesselungOriginal() throws Exception
	{
		this("verschluesselung.conf");
		FileInputStream in=new FileInputStream("verschluesselung.conf");
		dateinamen.load(in);
		in.close();
	}
	
	/** Liefert die Einsellungen bzw. Dateinamen, eingelesen aus "verschluesselung.conf" 
	 * 
	 * @param typ m�gliche Werte: "original", "schluessel", "codiert" und "decodiert"
	 * @return die entsprechenden Dateinamen 
	 */
	public String getDateiname(String typ)
	{
		return this.dateinamen.getProperty(typ);
	}

	
	/** Diese Methode durchl�uft alle Kleinbuchstaben (inkl. der Umlaute) und generiert 
	 * entsprechende gro�geschriebene key-value-Paare.
	 * 
	 *  Achtung: Leider funktioniert es nicht, mittels Enumerator alle keys zu durchlaufen und 
	 *           gleichzeitig die zus�tzlichen Eintr�ge einzuf�gen. Da es sich im Grunde um eine 
	 *           Hashtabelle handeld, werden die neuen Eintr�ge und die Urspr�nglichen durchmischt
	 *           und der Enumerator druchl�uft dadurch nicht mehr alle urspr�nglichen Eintr�ge!!!
	 *           Erkannbar ist das daran, dass am Ende nicht doppelt soviel Eintr�ge vorhanden sind.
	 * Abhilfe:  Die Paare f�r die Gro�buchstaben werden in einer eigenen Tabelle eingef�gt und diese
	 *           erst nach dem Durchlauf in die Tabelle der Kleinbuschstaben hinzugef�gt.         
	 */
	private void erweitereCodeTabelle()
	{
		/* Mann kan die Zuordnungen f�r Gro�buchstaben nat�rlich auch aus der Datei einlesen,
		 * dann entf�llt diese Methode. Ich wollte aber nicht die doppelte Eintr�ge in der Datei stehen haben,
		 * wenn man diese auch automatisch generieren kann. D.h. wer's schafft,...
		 */

		//...
	}
	
	/** Erzeugt eine umgekehrte Buchstabenzuordnung zum Entschl�sseln und speichert sie im Attribut "decode" */
	private void tauscheKeyValue()
	{
		/* erzeugt baisiernd auf den Zuordnungen in "code" eine umgedrehte Tabelle "decode" f�r die Entschl�sselung.
		 * Auch diese k�nnte man aus einer eigenen Datei einlesen. So ist es aber einfacher und Zuverl�ssiger.
		 */

		//...
	}

	
	/** Ersetzt jeden Buchstaben im �bergebenen Text durch seinen zugeordneten (Tabelle "code") und gibt den neuen Text zur�ck.
	 * Zur Optimierung, werden nicht String-Objekte verwendet sondern der Text wird in StringBuilder-Objekten gespeichert, die
	 * im Gegensatz zu String-Objekten ver�nderbar sind und nicht bei jeder �nderung neu instanziert werden m�ssen.
	 * 
	 * @param text der zu verschl�sselnde Text
	 * @return der verschl�sselte Text
	 */
	public StringBuilder codieren(StringBuilder text)
	{
		//...
		return new StringBuilder(); // nur eine Hilfsl�sung, damit das Programm �bersetzbar ist, gibt "leeren" Text zur�ck!
	}


	/** Das Entschl�sseln funktioniert genauso wie das Verschl�sseln, nur statt der Zuordnungstabelle "code" wird die 
	 * umgekehrte Tabelle "decode" verwendet.
	 * 
	 * @param text zu entschl�sselnder Text
	 * @return entschl�sselter Text
	 */
	public StringBuilder decodieren(StringBuilder text)
	{
		//...

		return new StringBuilder(); // Hilfsl�sug (siehe oben)
	}

	
	/** Schreibt den �bergebenen Text in die angegebene Datei - ev. vorhandener Text wird dabei �berschrieben 
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
		Leser leser=new Leser();
		leser.open(dateiname);
		String zeile="";
		zeile=leser.read();

		return new StringBuilder(); // Hilfsl�sug (siehe oben)
	}
	
	/** Diese Methode �ffnet gleichzeitig 2 Streams zum Lesen von beiden Dateien und 
	 * vergleicht zeichenweise die eingelesenen Buchstaben.
	 * Sobald ein Unterschied erkannt wird, oder das Dateiende erreicht wird, endet die Leseschleife.
	 *  
	 * @param dateiname1
	 * @param dateiname2
	 *
	 * @return true, wenn die beiden Dateien zeichenweise �bereinstimmen, sonst false
	 */
	public boolean vergleich1(String dateiname1, String dateiname2)
	{
		/* Diese Variante ist laut Angabe zu realisieren ! */

		//...
		
		return false; // Hilfsl�sung
	}
	
	/** Die zweite Methode liest den Text von beiden Dateien ein und f�hrt anschlie�end einen Vergleich der
	 * Textobjekte durch. Nachteil: auch wenn sich bereits das erste Zeichen unterscheidet, werden beide Texte
	 * vollst�ndig eingelesen. 
	 *  
	 * @param dateiname1
	 * @param dateiname2
	 *
	 * @return true, wenn die Texte beider Dateien �bereinstimmen, sonst false
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
		// Abhilfe: in Strings umwandeln, dessen equals()-Methode hat das gew�nschte verhalten (vergleicht die Inhalte, nicht die Referenzen)
	}
}
