
public class TeilzeitAngestellter extends Angestellter
{
	private float stundenProWoche;

	/**
	 * @param name
	 * @param sozVersNr
	 * @param gehalt
	 */
	public TeilzeitAngestellter(String name, String sozVersNr, float gehalt, float stundenProWoche) throws CompanyException
	{
		super(name, sozVersNr, gehalt);
		setStundenProWoche(stundenProWoche);
		// TODO Auto-generated constructor stub
	}
	
	public float berechneGehalt()
	{
		return (super.getGehalt()*stundenProWoche)/38.5f;
	}

	/**
	 * @return the stundenProWoche
	 */
	public float getStundenProWoche() 
	{
		return stundenProWoche;
	}

	/**
	 * @param stundenProWoche the stundenProWoche to set
	 */
	public void setStundenProWoche(float stundenProWoche) throws CompanyException
	{
		if (stundenProWoche<10 || stundenProWoche>30)
		{
			throw new CompanyException("Wochenstunden müssen mehr als 9 und weniger als 31 sein.");
		}
		else
		{
			this.stundenProWoche = stundenProWoche;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " TeilzeitAngestellter [Stunden pro Woche=" + getStundenProWoche()
				+ super.toString() + "]";
	}
	
	public void printInfo()
	{
		super.printInfo();
	}
}
