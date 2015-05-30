import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Team {

	private HashMap<String,Player>team;
	private int number;

	public Team()
	{
		super();
		team=new HashMap<String,Player>();
	}

	public void put(Player player)
	{
		if(!team.containsKey(player.getName()))
		{
			number++;
			player.setNumber(number);
			team.put(player.getName(),player);
		}
	}

	public Player get(String name)
	{
		return team.get(name);
	}

	private Player findPlayerByNumber(int number)
	{
		if(team.isEmpty())
		{
			return null;
		}

		for(Player player:team.values())
		{
			if(player.getNumber()==number)
			{
				return player;
			}
		}
		return null;
	}

	public Player remove(int number)

	{
		Player player=findPlayerByNumber(number);
		team.remove(player.getName());
		return player;
	}

	public Player minNumber()
	{
		int number =0;
		boolean a=true;

		for(Player player:team.values())
		{
			if(a)
			{
				number=player.getNumber();
				a=false;
			}

			if(player.getNumber()<number)
			{
				number=player.getNumber();
			}
		}
		return (findPlayerByNumber(number));
	}

	public Player maxScore()
	{
		Player player=null;
		int maxScore=0;
		boolean a=true;
		for(Player playerND:team.values())
		{
			if(a)
			{
				player=playerND;
				maxScore=playerND.getScore();
				a=false;
			}

			if(playerND.getScore()<maxScore)
			{
				player=playerND;
				maxScore=playerND.getScore();
			}
		}
		return player;
	}

	public int sumScores()
	{
		int score=0;
		for(Player player:team.values())
		{
			score+=player.getScore();
		}
		return score;
	}

	public int size()
	{
		if(team.isEmpty())
		{
			return 0;
		}
		return team.size()+1;
	}

	public double averageScore()
	{
		return sumScores()/size();
	}

	public void print()
	{
		for(Player player:team.values())
		{
			System.out.println(player);
		}
	}

	public void printSortedByNumber()
	{
		HashMap<Integer,Player>teamND=new HashMap<Integer,Player>();
		for(Player player:team.values())
		{
			teamND.put(player.getNumber(), player);
		}

		SortedSet<Integer> numbers = new TreeSet<Integer>(teamND.keySet());

		for (int number : numbers)
		{
		   System.out.println(findPlayerByNumber(number));
		}
	}

	public void printSortedByName()
	{
		SortedSet<String> keys = new TreeSet<String>(team.keySet());
		for (String key : keys)
		{
		   System.out.println(team.get(key));
		}
	}

	public Set<Player> findPlayersWithName(String name){
		Set<Player> set=new HashSet<Player>();
		for(Player player:team.values())
		{
			if(player.getName().equalsIgnoreCase(name))
			{
				set.add(player);
			}
		}
		return set;
	}

	public Set<Player> findPlayersWithScore(int start, int end)
	{
		Set<Player> set=new HashSet<Player>();
		if(end<start)
			start=end;
		for(Player player:team.values())
		{
			if(player.getScore()>=start&&player.getScore()<=end)
			{
				set.add(player);
			}
		}
		return set;
	}
}