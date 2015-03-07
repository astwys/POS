public class Player {

	private String name;
	private int number;
	private int score;

	public Player(String name, int score) 
	{
		super();
		setName(name);
		setScore(score);
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public int getNumber() 
	{
		return number;
	}
	
	public void setNumber(int number) 
	{
		this.number = number;
	}
	
	public int getScore() 
	{
		return score;
	}
	
	public void setScore(int score) 
	{
		this.score = score;
	}
	
	@Override
	public String toString() 
	{
		return "Player [name= " + name + ", number= " + number + ", score= "
				+ score + "]";
	}
}