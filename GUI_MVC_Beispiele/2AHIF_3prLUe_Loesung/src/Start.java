
import javax.swing.SwingUtilities;

/** Lösunng zur 3. praktische Leistungsüberprüfung
 * 
 * @author Gerald Schildberger
 * @version 2015 
 */
public class Start
{
	public static void main(String[] args)
	{
	   	SwingUtilities.invokeLater(new Runnable() 
	   	{   public void run() 
    	    {

    	    	new Hauptfenster("<Parteiname>", 25);
    	    
    	    }
    	});

/*	   	
	   	// ein kleines Beispiel zur Verwendung der Klasse Wahlversprechen:
		try
		{
			Wahlversprechen w = new Wahlversprechen("Mehrwertsteuersenkung", "Mehrwertsteuer von 20% auf 15% senken", 
			        								30, 1000000000000f, Wahlversprechen.SOFORT, false, "Finanzminister lehnt das strikt ab!");
			System.out.println("Wahlversprecehen: " + w.toString());
			
			// nur die Ausrede soll geändert	werden
			w.setGueltig(w.isGueltig(), "Am Widerstand des Koalitonspartners gescheitert!"); 
			System.out.println("Wahlversprechen: " + w.toString());
			
		} catch (WahlversprechenException e)
		{
			System.out.println("Exception: " + e.getMessage());
		}
*/
	
	}
	
	
}
