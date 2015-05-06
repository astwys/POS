package wahlversprechenNeu;

public class NeuWahlversprechen {

	public static final String SOFORT="sofort";
	public static final String IN_1_WOCHE="in einer Woche";
	public static final String IN_1_MONAT="in einem Monat";
	public static final String IN_1_JAHR="in einem Jahr";
	
	private String schlagwort;
	private String beschreibung;
	private float stimmenzuwachs;
	private String wirdVerworfen;
	private boolean gueltig;
	private String ausrede;
	
	public NeuWahlversprechen(String schlagwort, String beschreibung, float stimmenzuwachs, String wirdVerworfen, boolean gueltig, String ausrede) {
		// TODO Auto-generated constructor stub
		setSchlagwort(schlagwort);
		setBeschreibung(beschreibung);
		setStimmenzuwachs(stimmenzuwachs);
		setWirdVerworfen(wirdVerworfen);
		setGueltig(gueltig);
		setAusrede(ausrede);
	}

	public String getSchlagwort() {
		return schlagwort;
	}

	public void setSchlagwort(String schlagwort) {
		this.schlagwort = schlagwort;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public float getStimmenzuwachs() {
		return stimmenzuwachs;
	}

	public void setStimmenzuwachs(float stimmenzuwachs) {
		this.stimmenzuwachs = stimmenzuwachs;
	}

	public String getWirdVerworfen() {
		return wirdVerworfen;
	}

	public void setWirdVerworfen(String wirdVerworfen) {
		this.wirdVerworfen = wirdVerworfen;
	}

	public boolean isGueltig() {
		return gueltig;
	}

	public void setGueltig(boolean gueltig) {
		this.gueltig = gueltig;
	}

	public String getAusrede() {
		return ausrede;
	}

	public void setAusrede(String ausrede) {
		this.ausrede = ausrede;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
