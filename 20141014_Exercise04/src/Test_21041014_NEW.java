/**
 * tests the new methods sortieren...()
 * @author michael
 *
 */
public class Test_21041014_NEW {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		testSortieren();
		testSortierenAufteigend();
		testSortierenComparable();
		testSortierenAufsteigendComparable();
	}

	public static void testSortieren()
	{
		
		Firma f = new Firma("Test-Firma");
		
		System.out.println("Absteigendes Sortieren mit BubbleSort wird getestet...");
		
		
		Mitarbeiter m1,m2,m3,m4,m5;
			
		try 
		{
			m1= new Angestellter("Franz Josef", "qwertz123", 1000);
			m2= new TeilzeitAngestellter("Herbert", "asdf123", 500, 20);
			m3= new WerksvertragsAngestellter("Udo", "jklö123", 38, 20);
			m4= new Abteilungsleiter("Hans", "gh123", 1999, 20);
			m5= new Angestellter("Inge", "uiop123", 1100);
					
			f.einstellen(m1);
			f.einstellen(m2);
			f.einstellen(m3);
			f.einstellen(m4);
			f.einstellen(m5);

			System.out.println("\n");
			f.sortieren();
			
			f.printMitarbeiter(0);
			System.out.println("\n");
			
		}
		catch (CompanyException e)
		{
			System.out.println("\n Fehlerursache: " + e.getMessage());
		}
	}
	
	public static void testSortierenAufteigend ()
	{
		System.out.println("Aufteigendes Sortieren mit BubbleSort wird getestet...");
		Firma f = new Firma("Test-Firma");
		
		Mitarbeiter m1,m2,m3,m4,m5;
			
		try 
		{
			m1= new Angestellter("Franz Josef", "qwertz123", 1000);
			m2= new TeilzeitAngestellter("Herbert", "asdf123", 500, 20);
			m3= new WerksvertragsAngestellter("Udo", "jklö123", 38, 20);
			m4= new Abteilungsleiter("Hans", "gh123", 1999, 20);
			m5= new Angestellter("Inge", "uiop123", 1100);
					
			f.einstellen(m1);
			f.einstellen(m2);
			f.einstellen(m3);
			f.einstellen(m4);
			f.einstellen(m5);
			
			System.out.println("\n");
			f.sortieren(true);
			
			f.printMitarbeiter(0);
			System.out.println("\n");
			
		}
		catch (CompanyException e)
		{
			System.out.println("\n Fehlerursache: " + e.getMessage());
		}
	}
	
	public static void testSortierenComparable()
	{
		System.out.println("Absteigendes Sortieren mit compareTo wird getestet...");
		Firma f = new Firma("Test-Firma");
		
		Mitarbeiter m1,m2,m3,m4,m5;
			
		try 
		{
			m1= new Angestellter("Franz Josef", "qwertz123", 1000);
			m2= new TeilzeitAngestellter("Herbert", "asdf123", 500, 20);
			m3= new WerksvertragsAngestellter("Udo", "jklö123", 38, 20);
			m4= new Abteilungsleiter("Hans", "gh123", 1999, 20);
			m5= new Angestellter("Inge", "uiop123", 1100);
					
			f.einstellen(m1);
			f.einstellen(m2);
			f.einstellen(m3);
			f.einstellen(m4);
			f.einstellen(m5);
			
			System.out.println("\n");
			f.sortierenComparable();
			
			f.printMitarbeiter(0);
			System.out.println("\n");
			
		}
		catch (CompanyException e)
		{
			System.out.println("\n Fehlerursache: " + e.getMessage());
		}
	}
	
	public static void testSortierenAufsteigendComparable()
	{
		System.out.println("Aufsteigendes Sortieren mit compareTo wird getestet...");
		Firma f = new Firma("Test-Firma");
		
		Mitarbeiter m1,m2,m3,m4,m5;
			
		try 
		{
			m1= new Angestellter("Franz Josef", "qwertz123", 1000);
			m2= new TeilzeitAngestellter("Herbert", "asdf123", 500, 20);
			m3= new WerksvertragsAngestellter("Udo", "jklö123", 38, 20);
			m4= new Abteilungsleiter("Hans", "gh123", 1999, 20);
			m5= new Angestellter("Inge", "uiop123", 1100);
					
			f.einstellen(m1);
			f.einstellen(m2);
			f.einstellen(m3);
			f.einstellen(m4);
			f.einstellen(m5);

			System.out.println("\n");
			f.sortierenComporable(true);
			
			f.printMitarbeiter(0);
			System.out.println("\n");
			
		}
		catch (CompanyException e)
		{
			System.out.println("\n Fehlerursache: " + e.getMessage());
		}
	}

}