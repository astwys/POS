import java.util.Arrays;


public class Galerie 
{

	private String name;
	private Picture [] pictures;
	private int count; //first free array index
	
	/*public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
	}*/

	
	
	/**
	 * @param name
	 */
	public Galerie(String name, int size) 
	{
		super();
		this.setName(name);
		pictures=new Picture [size];
	}
	
	public Galerie()
	{
		super();
		this.setName("Louvre");
		pictures=new Picture[3];
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	
	public boolean hangUp (Picture p)
	{
		if (exists(p)) return false;
		if (count>=0 && count < pictures.length)
		{
			if (p.calculateRetailPrice()>100000)
			{
				pictures[count]=p;
				count++;
				return true;
			}
			
			return false;
		}
		
		return false;
	}
	
/*	{
			if (p.calculateRetailPrice()>100000)
			{
				for (int i=0; i<pictures.length; i++)
				{
					if (pictures[i]==null)
					{
						pictures[i]=p;
						return true;
					}
				}
		
				System.err.println("Retail price must be over 100.000€");
			}
		
		return false;
	}*/
	
	public boolean exists (Picture p)
	{
		for (int i=0; i<pictures.length; i++)
		{
			if (pictures[i]!=null && pictures[i].equals(p)) return true;
		}
		
		return false;
	}
	
	
	public float calculateTotalPrice()
	{
		float total = 0;
		
		for (int i=0; i<pictures.length; i++)
		{
			if (pictures[i]!=null)
			{
				total+=pictures[i].calculateRetailPrice();
			}
		}
		
		return total;
	}
	
	
	public int countPicHigherPrice (float value)
	{
		int total=0;
		
		for (int i=0; i<count; i++)
		{
			if (pictures[i].calculateRetailPrice()>value)
			{
				total++;
			}
		}
		
		if (total<=0)
		{
			System.err.println("There are no pictures pricier than " + value);
			return 0;
		}
		
		return total;
	}
	
	public int removePicOfArtist (String artist)
	{
		int numArtists=0;
		
		if (count >=0)
		{
			for (int i=0; i<count; i++)
			{
				if (pictures[i].getArtist()==artist)
				{
					count--;
					
					for (int j=i; j<=count; j++)
					{
						pictures[j]=pictures[j+1];
					}
					
					pictures[count]=null;
					numArtists++;
				}
			}
			System.out.println("Pictures of artist removed removed.\n");
			return numArtists;
		}
		return 0;
	}
	
	
	public String toString()
	{
		String str=null;
		
		str="\n----- Gallery: " + name + " -----\n\n";
		
		for (int i=0; i<count; i++)
		{
			str+="" + pictures[i].toString() + "\n";
		}
		
		return str;
	}
	
	
	public void print()
	{
		System.out.println(this);
	}
}
