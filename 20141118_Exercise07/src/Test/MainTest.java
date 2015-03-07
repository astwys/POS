/**
 * 
 */
package Test;

import Verschluesselung.MainVerschluesselung;

/**
 * @author michael
 *
 */
public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}
	
	public static void test()
	{
		try {
			MainVerschluesselung verschl = new MainVerschluesselung();
			verschl.codieren("text.txt", "verschlüsselt.txt");
			verschl.decodieren("verschlüsselt.txt", "entschlüsselt.txt");
			verschl.vergleichen("text.txt", "entschlüsselt.txt");
			System.out.println("Fertig!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Fehlerursache: " + e.getMessage());
		}
	}

}
