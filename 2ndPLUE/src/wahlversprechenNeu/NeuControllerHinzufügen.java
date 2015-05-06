package wahlversprechenNeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NeuControllerHinzufügen implements ActionListener {
	
	private NeuHinzufuegenFenster view;
	private NeuMVPanel mitte;
	private NeuParteiprogramm model;
	private NeuController ctrl;
	
	public NeuControllerHinzufügen(NeuHinzufuegenFenster view) {
		this.view=view;
		mitte=new NeuMVPanel(true, true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "Übernehmen":
			NeuWahlversprechen wv=mitte.erzeugeWahlversprechen();
			try {
				ctrl.hinzufuegen(wv);
			} catch (NeuWahlversprechenException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			view.dispose();
			break;
		case "Verwerfen":
			break;
		default:
			break;
		}
	}
}
