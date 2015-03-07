package Test;
import Verschluesselung.VerschluesselungOriginal;

public class Test 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try{
		VerschluesselungOriginal v = new VerschluesselungOriginal();
		
		/*
		// simpler Text zum Ver- und Entschl�sseln
		StringBuilder codiert = v.codieren(new StringBuilder("abcd �. Hallo!"));
		StringBuilder decodiert = v.decodieren(codiert);
		
		System.out.println( codiert );
		System.out.println( decodiert );
		*/
		
		// Kompletter Test:
		StringBuilder text;
		
		// originalen Text einlesen
		text = v.leseText(v.getDateiname("original"));
		System.out.println("Eingelesener Text:\n" + text + "\n");
		
		// Text verschl�sseln und schreiben
		text = v.codieren(text);
		System.out.println("Verschl�sselter Text:\n" + text + "\n");
		v.schreibeText(v.getDateiname("codiert"), text);
		
		// Verschl�sselten Text lesen, entschl�sseln und wieder schreiben
		text = v.leseText(v.getDateiname("codiert"));  // nicht unbedingt erforderlich (zur Kontrolle der Schreib-/Lesefunktion)
		text = v.decodieren(text);
		v.schreibeText(v.getDateiname("decodiert"), text);
	
		// Test ob der Vergleich funktioniert (mit 2x der selben Datei)
		System.out.println(v.vergleich1(v.getDateiname("original"), v.getDateiname("original")) ? "Dateien stimmen �berein." : "Dateien stimmen NICHT �berein!");
		System.out.println(v.vergleich2(v.getDateiname("original"), v.getDateiname("original")) ? "Dateien stimmen �berein." : "Dateien stimmen NICHT �berein!");
		
		// Vergleich der originalen Textdatei mir der ver- und entschl�sselten Variante
		System.out.println(v.vergleich1(v.getDateiname("original"), v.getDateiname("deodiert")) ? "Dateien stimmen �berein." : "Dateien stimmen NICHT �berein!");
		
		// Wem die vorhergehenden 3 Zeilen/Vergleiche ein R�tsel aufgeben, das waren die Kurzformen der folgenden Anweisung:
		if ( v.vergleich1( v.getDateiname("original"), v.getDateiname("deodiert") ) )
		{
			System.out.println("Dateien stimmen �berein.");
		}
		else
		{
			System.out.println("Dateien stimmen NICHT �berein.");
		}
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

}
