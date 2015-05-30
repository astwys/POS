package data;
/**
 * 
 */

/**
 * @author Jonas Neumair
 *
 */
public class TeilzeitAngestellter extends Angestellter {

	private float stundenProWoche;

	/**
	 * @param name
	 * @param gehalt
	 * @param sozVersNr
	 */
	public TeilzeitAngestellter(String name, String sozVersNr, float gehalt, float stundenProWoche) {
		super(name, sozVersNr, gehalt);
		setStundenProWoche(stundenProWoche);
		// TODO Auto-generated constructor stub
	}
	
	public float berechneGehalt(){
		return (super.getGehalt()*stundenProWoche)/38.5f;
	}
	
	/**
	 * @return the stundenProWoche
	 */
	public float getStundenProWoche() {
		return stundenProWoche;
	}

	/**
	 * @param stundenProWoche the stundenProWoche to set
	 */
	public void setStundenProWoche(float stundenProWoche) {
		if(stundenProWoche>=10 && stundenProWoche<=30){
			this.stundenProWoche = stundenProWoche;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TeilzeitAngestellter [stundenProWoche=" + stundenProWoche + "]"+super.toString();
	}
	
	
}


