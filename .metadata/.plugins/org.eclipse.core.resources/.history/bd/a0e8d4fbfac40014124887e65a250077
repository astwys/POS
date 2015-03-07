
public class Abteilungsleiter extends Angestellter
{
	private int anzahlMitarbeiter;


	/**
	 * @param name
	 * @param sozVersNr
	 * @param gehalt
	 */
	public Abteilungsleiter(String name, String sozVersNr, float gehalt, int anzahlMitarbeiter) {
		super(name, sozVersNr, gehalt);
		setAnzahlMitarbeiter(anzahlMitarbeiter);
		// TODO Auto-generated constructor stub
	}

	public float berechneGehalt()
	{
		return super.getGehalt()+(anzahlMitarbeiter*100);
	}
	
	/**
	 * @return the anzahlMitarbeiter
	 */
	public int getAnzahlMitarbeiter() {
		return anzahlMitarbeiter;
	}

	/**
	 * @param anzahlMitarbeiter the anzahlMitarbeiter to set
	 */
	public void setAnzahlMitarbeiter(int anzahlMitarbeiter) {
		this.anzahlMitarbeiter = anzahlMitarbeiter;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " Abteilungsleiter [Anzahl Mitarbeiter=" + getAnzahlMitarbeiter()
				+ super.toString() + "]";
	}
	
	public void printInfo()
	{
		super.printInfo();
	}
}
