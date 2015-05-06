package kunstsammlung;
import javax.swing.*;

import java.awt.*;

/** Realisiert das Ankaufen-Fenster der grafischen Oberfl�che 
 */
@SuppressWarnings("serial")
public class ViewAnkaufen extends JFrame
{
	private JTextField jtfBezeichnung;
	private JTextField jtfWert;
	private JCheckBox jcbVerliehen;
	
	/**
	 * @param view ... Referenz auf das Hauptfenster, wird weitergegeben an den Controller f�r's Ankaufen
	 * @param model ... Referenz auf die Kunstsammlung (Model)
	 */
	public ViewAnkaufen(ViewHauptfenster view, Kunstsammlung model)
	{
		setTitle("Ankaufen");
		initComponents(view, model);
		setBounds(view.getLocation().x+10, view.getLocation().y+10, 400, 150); 
		this.setVisible(true);
	}
	
	/**
	 * Initialisiert alle Komponenten des Eingabefensters
	 * @param model ... Refernez auf das Model (die Kunstsammlung)
	 */
	private void initComponents(ViewHauptfenster view, Kunstsammlung model)
	{
		CtrlAnkaufen ctrl = new CtrlAnkaufen(view, this, model);
		
		JButton jbOk = new JButton("OK"); jbOk.addActionListener(ctrl);
		JButton jbAbbr = new JButton("Abbrechen"); jbAbbr.addActionListener(ctrl);
		jtfBezeichnung = new JTextField(10);
		jtfWert = new JTextField(10);
		jcbVerliehen = new JCheckBox("Kunstwerk ist verliehen"); jcbVerliehen.addActionListener(ctrl);
		
		JPanel p = new JPanel(new GridLayout(4, 2));
		p.add(new JLabel("Bezeichnung: "));
		p.add(jtfBezeichnung);
		p.add(new JLabel("Wert: "));
		p.add(jtfWert);
		p.add(new JLabel());
		p.add(jcbVerliehen);
		p.add(jbAbbr);
		p.add(jbOk);
		
		this.add(p);
	}

	/**
	 * @return eingegebene Bezeichnung
	 */
	public String getBezeichnung()
	{
		return jtfBezeichnung.getText();
	}
	
	/**
	 * @return eingegebener Wert (als Text)
	 */
	public String getWert()
	{
		return jtfWert.getText();
	}
	
	/**
	 * @return verliehen ist ausgew�hlt?
	 */
	public boolean getVerliehen()
	{
		return jcbVerliehen.isSelected();
	}
}
