package Verschluesselung;
import java.io.*;

/** * Klasse liest einen Text aus der Datei shakespear.txt. * */
public class Leser {
	BufferedReader reader;

	/**
	 * * �ffnet die Datei shakespear.txt. Falls die Datei nicht gefunden wird,
	 * wird eine Exception gewrofen.
	 */
	public void open(String datei) {
		try {
			FileReader file = new FileReader(datei);
			reader = new BufferedReader(file);
		} catch (Exception e) {
			System.out.println("Fehler: " + e.getMessage());
		}
	}

	/**
	 * * Liest die Datei zeilenweise. Bei Dateiende wird null zur�ck geliefert.
	 * * @return
	 */
	public String read() {
		String zeile = null;
		if (reader == null)
			System.out.println("Fehler: Datei nicht ge�ffnet!");
		try {
			zeile = reader.readLine();
		} catch (Exception e) {
			System.out.println("Fehler: " + e.getMessage());
		} finally {
			return zeile;
		}
	}

	public void close() {
		if (reader == null)
			System.out.println("Fehler: Datei nicht ge�ffnet!");
		try {
			reader.close();
		} catch (Exception e) {
			System.out.println("Fehler: " + e.getMessage());
			System.exit(-13);
		}
	}

	/**
	 * * Testet die Klasse Leser. Der Text wird gelesen und ausgegeben. * * @param
	 * args
	 */
	
	/*
	public static void main(String[] args)
	{
		Leser l = new Leser();
		String line = ""; // Datei �ffnen 
		l.open(); // lesen und in der Konsole
		// ausgeben 
		line = l.read(); 
		while (line != null) 
		{
			System.out.println(line); 
			line = l.read(); 
		}
		// datei schliessen 
		l.close(); 
	}
	*/
	
	//optimiert
	/*
	public void main (String [] args)
	{
		Leser l=new Leser();
		String line="";
		l.open();
		
		while((line=l.read()) !=null)
		{
			System.out.println(line);
		}
	}
	*/
}