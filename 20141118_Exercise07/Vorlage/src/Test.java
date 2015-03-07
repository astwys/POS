public class Test 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Verschluesselung v = new Verschluesselung();
		
		/*
		// simpler Text zum Ver- und Entschlüsseln
		StringBuilder codiert = v.codieren(new StringBuilder("abcd ß. Hallo!"));
		StringBuilder decodiert = v.decodieren(codiert);
		
		System.out.println( codiert );
		System.out.println( decodiert );
		*/
		
		// Kompletter Test:
		StringBuilder text;
		
		// originalen Text einlesen
		text = v.leseText(v.getDateiname("original"));
		System.out.println("Eingelesener Text:\n" + text + "\n");
		
		// Text verschlüsseln und schreiben
		text = v.codieren(text);
		System.out.println("Verschlüsselter Text:\n" + text + "\n");
		v.schreibeText(v.getDateiname("codiert"), text);
		
		// Verschlüsselten Text lesen, entschlüsseln und wieder schreiben
		text = v.leseText(v.getDateiname("codiert"));  // nicht unbedingt erforderlich (zur Kontrolle der Schreib-/Lesefunktion)
		text = v.decodieren(text);
		v.schreibeText(v.getDateiname("decodiert"), text);
	
		// Test ob der Vergleich funktioniert (mit 2x der selben Datei)
		System.out.println(v.vergleich1(v.getDateiname("original"), v.getDateiname("original")) ? "Dateien stimmen überein." : "Dateien stimmen NICHT überein!");
		System.out.println(v.vergleich2(v.getDateiname("original"), v.getDateiname("original")) ? "Dateien stimmen überein." : "Dateien stimmen NICHT überein!");
		
		// Vergleich der originalen Textdatei mir der ver- und entschlüsselten Variante
		System.out.println(v.vergleich1(v.getDateiname("original"), v.getDateiname("deodiert")) ? "Dateien stimmen überein." : "Dateien stimmen NICHT überein!");
		
		// Wem die vorhergehenden 3 Zeilen/Vergleiche ein Rätsel aufgeben, das waren die Kurzformen der folgenden Anweisung:
		if ( v.vergleich1( v.getDateiname("original"), v.getDateiname("deodiert") ) )
		{
			System.out.println("Dateien stimmen überein.");
		}
		else
		{
			System.out.println("Dateien stimmen NICHT überein.");
		}
	}

}
