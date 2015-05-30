
public class Test {
	public static void main(String[] args) {
		testRekursionen();
		//testTeam();
	}
	public static void testRekursionen(){
		Rekursionen rek=new Rekursionen();
		System.out.println(rek.fakultaet(0));
		System.out.println(rek.fakultaet(5));
		System.out.println(rek.fakultaet(6));
		System.out.println(rek.fakultaet(10));
		System.out.println(rek.berechneIntegerWert("123"));
		System.out.println(rek.berechneIntegerWert("547349"));
		System.out.println(rek.berechneIntegerWert("1010101010"));
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
		team.put(new Player("Player91",276));
		team.put(playerTest);

		System.out.println("Get Player2: "+team.get("Player2"));
		System.out.println("Get Player17: "+team.get("Player17"));
		System.out.println("Remove Player with number 6: "+team.remove(6));
		System.out.println("MinNumber: "+team.minNumber());
		System.out.println("MaxScore: "+team.maxScore());
		System.out.println("SumScores: "+team.sumScores());
		System.out.println("Size: "+team.size());
		System.out.println("AverageScore: "+team.averageScore());
		System.out.println("---Print------------------------------");
		team.print();
		System.out.println("---PrintSortedByName------------------");
		team.printSortedByName();
		System.out.println("---PrintSortedByNumber----------------");
		team.printSortedByNumber();
		System.out.println("--------------------------------------");
		System.out.println("FindPlayersWithName pLAYER2: "+team.findPlayersWithName("pLAYER2"));
		System.out.println("FindPlayersWithScore Start:200 End:300 : "+team.findPlayersWithScore(200,300));
	}
}
