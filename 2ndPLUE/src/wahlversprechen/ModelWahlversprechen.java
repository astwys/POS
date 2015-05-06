package wahlversprechen;

public class ModelWahlversprechen {
	
	private String schlagwort;
	private String beschreibung;
	private String ausrede;
	
	public ModelWahlversprechen(String schlagwort, String beschreibung, String ausrede) {
		// TODO Auto-generated constructor stub
		setSchlagwort(schlagwort);
		setBeschreibung(beschreibung);
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

	public String getAusrede() {
		return ausrede;
	}

	public void setAusrede(String ausrede) {
		this.ausrede = ausrede;
	}
}
