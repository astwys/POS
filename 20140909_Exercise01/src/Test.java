
public class Test 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String pi[][]={
				{"Van Gogh","Scream","0","true"},
				{"Van Gogh","No Scream","220000","false"},
				{"Van Gogh","Silent","9000","true"},
				{"Van Gogh",null,"120000","true"},
				{"Van Gogh","Sunburst","200000","false"}
		};
		Galerie g = new Galerie("Louvre",3);
		
		for(int a=0; a<pi.length;a++){
			try{
				g.hangUp(new Picture(pi[a][0],pi[a][1],Integer.parseInt(pi[a][2]),Boolean.parseBoolean(pi[a][3])));
			}
			catch(Exception e){
				System.out.println("Fehlerursache: " + e.getMessage());
			}
		}
		
		g.print();
		
		g.removePicOfArtist("Van Gogh");
		g.countPicHigherPrice(100000);
		g.calculateTotalPrice();
		g.print();
	}
}
