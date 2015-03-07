package data;
import java.util.ArrayList;


public class Firma //extends Mitarbeiter
{
	private String name;
	private ArrayList<Mitarbeiter> mitarbeiter;
	
	/**
	 * @param name
	 * @param mitarbeiter
	 */
	public Firma(String name)
	{
		super();
		this.name = name;
		this.mitarbeiter = new ArrayList<Mitarbeiter>();
		System.out.println(name + "wurde erzeugt\n");
	}
	
	public boolean einstellen (Mitarbeiter m) throws CompanyException
	{
		if (m!=null)
		{
			if (!mitarbeiter.contains(m))
			{
				return mitarbeiter.add(m);
			}
			else
			{
				throw new CompanyException("Es gibt diesen Mitarbeiter schon in Ihrer Firma.");
			}
		}
		else
		{
			throw new CompanyException("Diese Person existiert nicht.");
		}
	}
	
	

	public boolean entlassen (String sznvnr) throws CompanyException
	{
		if (mitarbeiter.size()!=0)
		{
			for (Mitarbeiter m:mitarbeiter)
			{
				if (m.getSozVersNr().compareTo(sznvnr)==0)
				{
					System.out.println("\n Mitarbeiter mit der Sozialversicherungsnummer " + sznvnr +" wurde entlassen.\n");
					return mitarbeiter.remove(m);
				}
			}
			
			return false;
		}
		else
		{
			throw new CompanyException("Niemand arbeitet in ihrer Firma.");
		}
	}
	
	public void printMitarbeiter(float gehalt)
	{
		int i=0;
		
		for (Mitarbeiter m:mitarbeiter)
		{
			if (m.berechneGehalt()>=gehalt)
			{
				m.printInfo();
				i++;
			}
		}
		
		if (i==0)
		{
			for (Mitarbeiter m:mitarbeiter)
			{
				m.printInfo();
			}
		}
	}
	
	public void sucheMitarbeiter (String name) throws CompanyException
	{
		System.out.println("\nSuche nach Mitarbeiter " + name + " ...");
		
		if (mitarbeiter.size()!=0)
		{	
			for (Mitarbeiter m:mitarbeiter)
			{
				if (m.getName().compareTo(name)==0)
				{
					m.printInfo();;
				}
			}
		}

		throw new CompanyException("Mitarbeiter" + name + " wurde nicht gefunden");
	}
}
