
public class WerksvertragsAngestellter extends Mitarbeiter 
{
	private float stunden;
	private float stundenlohn;
	
	/**
	 * @param name
	 * @param sozVersNr
	 */
	public WerksvertragsAngestellter(String name, String sozVersNr, float stunden, float stundenlohn) 
	{
		super(name, sozVersNr);
		setStunden(stunden);
		setStundenlohn(stundenlohn);
		// TODO Auto-generated constructor stub
	}
	
	public float berechneGehalt()
	{
		return getStunden()*getStundenlohn();
	}
	
	/**
	 * @return the stunden
	 */
	public float getStunden() {
		return stunden;
	}
	/**
	 * @param stunden the stunden to set
	 */
	public void setStunden(float stunden) {
		this.stunden = stunden;
	}
	/**
	 * @return the stundenlohn
	 */
	public float getStundenlohn() {
		return stundenlohn;
	}
	/**
	 * @param stundenlohn the stundenlohn to set
	 */
	public void setStundenlohn(float stundenlohn) {
		this.stundenlohn = stundenlohn;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " WerktvertragsAngestellter [Stunden=" + getStunden()
				+ ", Stundenlohn=" + getStundenlohn()
				+ super.toString() + "]";
	}
	
	public void printInfo()
	{
		super.printInfo();
	}
}
