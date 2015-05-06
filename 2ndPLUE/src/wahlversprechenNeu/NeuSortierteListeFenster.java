package wahlversprechenNeu;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NeuSortierteListeFenster extends JFrame {
	public NeuSortierteListeFenster(String sortiertNach, String text) {
		// TODO Auto-generated constructor stub
		this.setBounds(10, 10, 800, 300);
		this.setTitle("Wahlversprechen " + sortiertNach + " soetiert");
		JTextArea ta=new JTextArea(text);
		JScrollPane sp=new JScrollPane(ta);
		this.add(sp);
		this.setVisible(true);
	}
}
