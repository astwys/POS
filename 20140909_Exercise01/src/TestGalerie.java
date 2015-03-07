
public class TestGalerie {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Galerie g = new Galerie("Louvre",3);
		
		try {
			g.hangUp(new Picture("Van Gogh", "Scream", 0, true));
		} catch (ExceptionForgotAttribute e) {
			// TODO Auto-generated catch block
			System.out.println("Fehlerursache: " + e.getMessage());
		}
		try {
			g.hangUp(new Picture("Gogh Van", "No Scream", 220000, false));
		} catch (ExceptionForgotAttribute e) {
			// TODO Auto-generated catch block
			System.out.println("Fehlerursache: " + e.getMessage());
		}
		try {
			g.hangUp(new Picture("Gan Vogh", "Silent", 9000, true));
		} catch (ExceptionForgotAttribute e) {
			// TODO Auto-generated catch block
			System.out.println("Fehlerursache: " + e.getMessage());
		}
		try {
			g.hangUp(new Picture("Van Gogh", null, 120000, true));
		} catch (ExceptionForgotAttribute e) {
			// TODO Auto-generated catch block
			System.out.println("Fehlerursache: " + e.getMessage());
		}
		try {
			g.hangUp(new Picture("Van Gogh", "Sunburst", 200000, false));
		} catch (ExceptionForgotAttribute e) {
			System.out.println("Fehlerursache: " + e.getMessage());
		}
		finally
		{
			System.out.println("Wird auf jede Fälle ausgeführt!");
		}
		
		g.removePicOfArtist("Van Gogh");
		g.countPicHigherPrice(100000);
		g.calculateTotalPrice();
		g.print();
	}
}
