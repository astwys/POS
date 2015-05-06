package wahlversprechen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerNeu implements ActionListener{

	private ViewMid viewN;
	private ModelPartei modelP;
	
	public ControllerNeu(ViewMid viewMid) {
		// TODO Auto-generated constructor stub
		this.viewN=viewMid;
		modelP = new ModelPartei();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "Abbrechen":
			viewN.dispose();
			break;
		case "Speichern":
			modelP.add();
			modelP.set();
			viewN.dispose();
		default:
			break;
		}
	}

}
