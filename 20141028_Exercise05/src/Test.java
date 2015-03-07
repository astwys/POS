
public class Test {
	public static void main(String[] args) {
		testTeam();
		//testTeam();
	}
	
	public static void testTeam(){
		Team team=new Team();
		Player playerTest=new Player("Player4",156);
		team.put(new Player("Player1",132));
		team.put(new Player("Player2",243));
		team.put(new Player("Player3",311));
		team.put(playerTest);
		team.put(new Player("Player5",76));
		team.put(new Player("Player6",293));
		team.put(new Player("Player7",164));
		team.put(new Player("Player8",123));
		team.put(new Player("Player9",113));
		team.put(new Player("Player27",276));
		team.put(playerTest);

		System.out.println("Get Player2: "+team.get("Player2"));
		System.out.println("Get Player18: "+team.get("Player18"));
		System.out.println("Remove Player number 6: "+team.remove(6));
		System.out.println("MinNumber: "+team.minNumber());
		System.out.println("MaxScore: "+team.maxScore());
		System.out.println("SumScores: "+team.sumScores());
		System.out.println("Size: "+team.size());
		System.out.println("AverageScore: "+team.averageScore() + "\n");
		System.out.println("---Print---");
		team.print();
		System.out.println("\n");
		System.out.println("---PrintSortedByName---");
		team.printSortedByName();
		System.out.println("\n");
		System.out.println("---PrintSortedByNumber---");
		team.printSortedByNumber();
		System.out.println("\n");
		System.out.println("--------------------------------------");
		System.out.println("\n");
		System.out.println("FindPlayersWithName plaYER3: "+team.findPlayersWithName("plaYER3"));
		System.out.println("FindPlayersWithScore starting at 100, ending with 400: "+team.findPlayersWithScore(100,400));
	}
}
