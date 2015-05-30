/**
 * 
 */
package gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author Jonas Neumair
 *
 */
public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				View h = new View();
				h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//h.setVisible(true);
			}
		});
	}

}
