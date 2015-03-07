import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;


public class Test 
{
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		test1();
		test2();
	}
		
	public static void test1()
	{
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
					
			f.printMitarbeiter(1000000);
				
			f.entlassen("gh123");
					
			f.printMitarbeiter(500);
					
			f.sucheMitarbeiter("Inge");
			f.sucheMitarbeiter("Franz");
		}
		catch (CompanyException e)
		{
			System.out.println("\n Fehlerursache: " + e.getMessage());
		}
	}
	
	public static void test2()
	{
		try 
		{
			Mitarbeiter m;
			
			m=new TeilzeitAngestellter("Gunter", "xyz123", 400, 35);
		}
		catch (CompanyException e) 
		{
			// TODO: handle exception
			System.out.println("\n Fehlerursache: " + e.getMessage());
		}	
	}
}

