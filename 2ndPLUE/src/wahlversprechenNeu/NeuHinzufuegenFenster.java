package wahlversprechenNeu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import wahlversprechenLoesung.Wahlversprechen;

public class NeuHinzufuegenFenster extends JFrame{
	NeuViewMain view;
	NeuControllerHinzufügen ctrl;
	
	private JButton uebernehmen;
	private JButton verwerfen;
	private NeuMVPanel mitte;
	
	public NeuHinzufuegenFenster() {
		// TODO Auto-generated constructor stub
		ctrl=new NeuControllerHinzufügen(this);
		this.setTitle("Neues Wahlversprechen");
		this.setBounds(10,10,370,550);
		this.setLayout(new BorderLayout());
		mitte=new NeuMVPanel(true, true);
		JPanel sued=new JPanel();
		
		verwerfen=new JButton("Verwerfen");
		verwerfen.addActionListener(ctrl);
		
		uebernehmen=new JButton("Übernehmen");
		uebernehmen.addActionListener(ctrl);
		
		sued.add(verwerfen); sued.add(uebernehmen);
		
		this.add(mitte, BorderLayout.CENTER);
		this.add(sued, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
}
