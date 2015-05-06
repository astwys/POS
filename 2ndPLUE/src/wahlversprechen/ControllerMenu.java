package wahlversprechen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerMenu implements ActionListener {

	private ViewMain viewM;
	private ViewNeu viewN;
	private ViewEntfernen viewE;

	public ControllerMenu(ViewMain view) {
		// TODO Auto-generated constructor stub
		this.viewM=view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "Hinzufügen": 
			viewM.getSchlagwort().setText("funktioniert");
			viewN=new ViewNeu();
			
			break;
		case "Entfernen":
			viewM.getBeschreibung().setText("funktioniert auch");
			viewE=new ViewEntfernen();
			break;
		case "<":
			//
			break;
		case ">":
			//
			break;
		}
	}
	
}
