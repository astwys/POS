import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.JFrame;


public class SimpleFrame extends JFrame {
	
	public SimpleFrame() {
		setTitle("Currency-Converter");
		setSize(400, 300);
		
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int) ((d.getWidth()/2 - this.getWidth()/2));
		int y=(int) ((d.getHeight()/2 - this.getHeight()/2));
		setLocation(x,y);
		
		SimplePanel panel = new SimplePanel();
		add(panel);
		setVisible(true);
		//pack();
		this.setResizable(false);
		
		
	}

}
