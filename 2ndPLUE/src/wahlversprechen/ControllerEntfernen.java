package wahlversprechen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerEntfernen implements ActionListener {

	private ViewEntfernen viewE;
	
	public ControllerEntfernen(ViewEntfernen viewE) {
		// TODO Auto-generated constructor stub
		this.viewE=viewE;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "Abbrechen":
			viewE.dispose();
			break;

		default:
			break;
		}
	}

}
