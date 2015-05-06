package wahlversprechenNeu;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NeuViewMain extends JFrame {
	
	NeuParteiprogramm model;
	NeuController ctrl;
	
	NeuMVPanel mitte;
	JLabel indikator;
	
	public NeuViewMain(String parteiname, float prozenStammwaehler) throws NeuWahlversprechenException {
		// TODO Auto-generated constructor stub
		model=new NeuParteiprogramm(parteiname, prozenStammwaehler);
		ctrl=new NeuController(this, model);
		
		setTitle("Partei"+model.getParteiname());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 370, 550);
		components();
		setVisible(true);
	}

	public void components() {
		JPanel haupt=new JPanel(); 
		haupt.setLayout(new BorderLayout());
		JPanel nord=new JPanel();
		mitte=new NeuMVPanel(false, false);
		JPanel sued=new JPanel();
		
		indikator=new JLabel();
		nord.add(indikator);
		
		JButton button;
		button=new JButton("<"); 
		button.addActionListener(ctrl);
		sued.add(button);
		
		button=new JButton(">");
		button.addActionListener(ctrl);
		sued.add(button);
		
		haupt.add(nord, BorderLayout.NORTH);
		haupt.add(mitte, BorderLayout.CENTER);
		haupt.add(sued, BorderLayout.SOUTH);
		
		JMenuBar menuB=new JMenuBar();
		JMenu menu;
		menu=new JMenu("Wahlversprechen");
		menuB.add(menu);
		
		JMenuItem menuI;
		menuI=new JMenuItem("Hinzufügen");
		menuI.addActionListener(ctrl);
		menu.add(menuI);

		menuI=new JMenuItem("Löschen");
		menuI.addActionListener(ctrl);
		menu.add(menuI);
		
		JMenu menu2=new JMenu("Übersicht sortiert");
		menu.add(menu2);
		
		menuI=new JMenuItem("alphabetisch");
		menuI.addActionListener(ctrl);
		menu2.add(menuI);
		
		menuI=new JMenuItem("nach Stimmen");
		menuI.addActionListener(ctrl);
		menu2.add(menuI);
		
		
		menu=new JMenu("Datei");
		menuB.add(menu);
		
		menuI=new JMenuItem("Laden");
		menuI.addActionListener(ctrl);
		menu.add(menuI);
		
		menuI=new JMenuItem("Speichern");
		menuI.addActionListener(ctrl);
		menu.add(menuI);
		
		
		this.add(haupt);
		this.setJMenuBar(menuB);
	}
	
	public void aktualisiereAnzeige(NeuWahlversprechen wahlversprechen) {
		mitte.aktualisiereAnzeige(wahlversprechen);
		
		float prozent=model.getProzentStammwaehler()+model.berechneSummeStimmenzuwachs();
		indikator.setText("Wählerstimmen: " + prozent+"%");
		if (prozent>50) {
			indikator.setForeground(Color.GREEN);
		}
		else {
			indikator.setForeground(Color.RED);
		}
	}
	
	public void zeigeFehlermeldung(String meldung) {
		if (meldung!=null) {
			JOptionPane.showMessageDialog(this, meldung, "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(this, "Diese Funktion funktioniert nicht", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
	}
}
