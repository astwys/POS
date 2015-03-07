import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class EditorPanel extends JPanel {
	private JTextField filename;
	private JTextField words;
	
	private JTextArea text;
	private JScrollPane scroll;
	
	private JButton laden;
	private JButton speichern;

	private JCheckBox txt;
	
	private EditorListener listener;
	
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	
	
	public EditorPanel() {
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		
		listener=new EditorListener(this);
		
		filename=new JTextField(); filename.setPreferredSize(new Dimension(100, 20));
		
		words=new JTextField(); words.setPreferredSize(new Dimension(250, 20));
		words.setEditable(false);
		
		text=new JTextArea(20,50); text.setLineWrap(true);

		scroll=new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		laden=new JButton("laden"); laden.addActionListener(listener);
		
		speichern=new JButton("speichern"); speichern.addActionListener(listener);
		
		txt=new JCheckBox();
		txt.setSelected(true);
		
		
		panel1.add(new JLabel("Dateiname:"));
		panel1.add(filename);
		panel1.add(new JLabel(".txt"));
		panel1.add(txt);
		panel1.add(laden);
		panel1.add(speichern);
		panel2.add(scroll);
		panel3.add(new JLabel("Status:"));
		panel3.add(words);
		
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
	}


	/**
	 * @return the filename
	 */
	public JTextField getFilename() {
		return filename;
	}


	/**
	 * @param filename the filename to set
	 */
	public void setFilename(JTextField filename) {
		this.filename = filename;
	}


	/**
	 * @return the words
	 */
	public JTextField getWords() {
		return words;
	}


	/**
	 * @param words the words to set
	 */
	public void setWords(JTextField words) {
		this.words = words;
	}


	/**
	 * @return the text
	 */
	public JTextArea getText() {
		return text;
	}


	/**
	 * @param text the text to set
	 */
	public void setText(JTextArea text) {
		this.text = text;
	}


	/**
	 * @return the scroll
	 */
	public JScrollPane getScroll() {
		return scroll;
	}


	/**
	 * @param scroll the scroll to set
	 */
	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}


	/**
	 * @return the laden
	 */
	public JButton getLaden() {
		return laden;
	}


	/**
	 * @param laden the laden to set
	 */
	public void setLaden(JButton laden) {
		this.laden = laden;
	}


	/**
	 * @return the speichern
	 */
	public JButton getSpeichern() {
		return speichern;
	}


	/**
	 * @param speichern the speichern to set
	 */
	public void setSpeichern(JButton speichern) {
		this.speichern = speichern;
	}


	/**
	 * @return the txt
	 */
	public JCheckBox getTxt() {
		return txt;
	}


	/**
	 * @param txt the txt to set
	 */
	public void setTxt(JCheckBox txt) {
		this.txt = txt;
	}


	/**
	 * @return the listener
	 */
	public EditorListener getListener() {
		return listener;
	}


	/**
	 * @param listener the listener to set
	 */
	public void setListener(EditorListener listener) {
		this.listener = listener;
	}


	/**
	 * @return the panel1
	 */
	public JPanel getPanel1() {
		return panel1;
	}


	/**
	 * @param panel1 the panel1 to set
	 */
	public void setPanel1(JPanel panel1) {
		this.panel1 = panel1;
	}


	/**
	 * @return the panel2
	 */
	public JPanel getPanel2() {
		return panel2;
	}


	/**
	 * @param panel2 the panel2 to set
	 */
	public void setPanel2(JPanel panel2) {
		this.panel2 = panel2;
	}


	/**
	 * @return the panel3
	 */
	public JPanel getPanel3() {
		return panel3;
	}


	/**
	 * @param panel3 the panel3 to set
	 */
	public void setPanel3(JPanel panel3) {
		this.panel3 = panel3;
	}
}
