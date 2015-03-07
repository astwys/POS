
public class Angestellter extends Mitarbeiter
{
	protected float gehalt;
	
	/**
	 * @param name
	 * @param sozVersNr
	 */
	public Angestellter(String name, String sozVersNr, float gehalt) 
	{
		super(name, sozVersNr);
		setGehalt(gehalt);
		// TODO Auto-generated constructor stub
	}

	public float berechneGehalt()
	{
		return gehalt;
	}

	/**
	 * @return the gehalt
	 */
	public float getGehalt()
	{
		return gehalt;
	}

	/**
	 * @param gehalt the gehalt to set
	 */
	public void setGehalt(float gehalt) 
	{
		this.gehalt = gehalt;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " Angestellter [Gehalt=" + berechneGehalt()
				+ super.toString() + "]";
	}

	public void printInfo()
	{
		super.printInfo();
	}
}