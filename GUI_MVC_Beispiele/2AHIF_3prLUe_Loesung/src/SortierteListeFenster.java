import javax.swing.*;

public class SortierteListeFenster extends JFrame
{
	public SortierteListeFenster(String sortiertNach, String text)
	{
		this.setBounds(10,10,800,300);
		this.setTitle("Wahlversprechen " + sortiertNach +" sortiert:");
		JTextArea ta = new JTextArea(text);
		JScrollPane sp = new JScrollPane(ta);
		this.add(sp);
		this.setVisible(true);
	}
}
