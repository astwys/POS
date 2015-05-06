package data;

import java.io.Serializable;

public abstract class Mitarbeiter implements Serializable
{
	protected String name;
	protected String sozVersNr;
	
	/**
	 * @param name
	 * @param sozVersNr
	 */
	public Mitarbeiter(String name, String sozVersNr) 
	{
		super();
		setName(name);
		setSozVersNr(sozVersNr);
	}
	
	public float berechneGehalt()
	{
		return 0;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the sozVersNr
	 */
	public String getSozVersNr() {
		return sozVersNr;
	}
	/**
	 * @param sozVersNr the sozVersNr to set
	 */
	public void setSozVersNr(String sozVersNr) {
		this.sozVersNr = sozVersNr;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " Mitarbeiter [name=" + name + ", Sozialversicherungsnummer=" + sozVersNr
				+ ", Gehalt=" + berechneGehalt() +"]";
	}
	
	public String printInfo()
	{
		return this.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sozVersNr == null) ? 0 : sozVersNr.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mitarbeiter other = (Mitarbeiter) obj;
		if (sozVersNr == null) {
			if (other.sozVersNr != null)
				return false;
		} else if (!sozVersNr.equals(other.sozVersNr))
			return false;
		return true;
	}
	
}
