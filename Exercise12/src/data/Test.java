package data;
/*
 * prints könnten auch in der jeweiligen Methode der jeweiligen Klasse stehen
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
	}
	
	public static void init() {
		Firma f=new Firma("TheComp");
		System.out.println("Firmenname: "+f.getName());
		System.out.println("-------------------------\n");

		
		//Stellt einen Abteilungsleiter ein
		try{
			System.out.println("Abteilungsleiter wird eingestellt.");
			f.einstellen(new Abteilungsleiter("Michael", "1234", 2500,39));
			System.out.println("TeilzeitAngestellter wird eingestellt.");
			f.einstellen(new TeilzeitAngestellter("Max", "4321", 1500,20));
			System.out.println("TeilzeitAngestellter wird eingestellt.");
			f.einstellen(new TeilzeitAngestellter("Jonas", "3434", 3700,40));
			System.out.println("TeilzeitAngestellter wird eingestellt.");
			f.einstellen(new TeilzeitAngestellter("Valentin", "2424", 1380,10));
		}
		catch(CompanyExceptions e){
			System.out.println("Fehlerursache: "+e.getMessage()+"\n");
		}
	}
}
