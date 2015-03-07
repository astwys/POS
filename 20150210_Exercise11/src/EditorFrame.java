import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class EditorFrame extends JFrame {
	
	private EditorPanel panel;
	
	public EditorFrame() {
		setTitle("Editor");
		setSize(650, 500);
		
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int) (d.getWidth()/2-this.getWidth()/2);
		int y=(int) (d.getHeight()/2-this.getHeight()/2);
		setLocation(x,y);
		
		panel = new EditorPanel();
		add(panel);
		setVisible(true);
		this.setResizable(true);
	}

	/**
	 * @return the panel
	 */
	public EditorPanel getPanel() {
		return panel;
	}

	/**
	 * @param panel the panel to set
	 */
	public void setPanel(EditorPanel panel) {
		this.panel = panel;
	}

}
