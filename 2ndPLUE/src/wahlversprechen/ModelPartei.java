package wahlversprechen;

import java.util.ArrayList;

public class ModelPartei {
	
	private ArrayList<ModelWahlversprechen> wahlversprechenArr;
	private ModelWahlversprechen wahlversprechen;
	
	private ViewNeu viewN;
	private ViewMain viewM;
	
	public ModelPartei() {
		// TODO Auto-generated constructor stub
		wahlversprechenArr=new ArrayList<ModelWahlversprechen>();
	}
	
	public void add() {
		wahlversprechen=new ModelWahlversprechen(viewN.getSchlagwort().getText(), viewN.getBeschreibung().getText(), viewN.getAusrede().getText());
		wahlversprechenArr.add(0,wahlversprechen);
	}
	
	public void set() {
		viewM.getSchlagwort().setText(wahlversprechenArr.get(0).getSchlagwort());
		viewM.getBeschreibung().setText(wahlversprechenArr.get(0).getBeschreibung());
		viewM.getAusrede().setText(wahlversprechenArr.get(0).getAusrede());
	}
}
