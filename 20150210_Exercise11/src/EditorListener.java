import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class EditorListener implements ActionListener {

	private EditorPanel panel;
	
	public EditorListener(EditorPanel p) {
		// TODO Auto-generated constructor stub
		panel=p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == panel.getLaden()) {
			load(panel.getFilename().getText());
		}
		else if (e.getSource() == panel.getSpeichern()) {
			save(panel.getFilename().getText());
		}
	}
	
	public void save(String name) {
		if (panel.getText().getText().equalsIgnoreCase("")) {
			panel.getWords().setText("Please write something into the file.");
			return;
		}
		
		FileWriter fw;
		
		try {
			if (panel.getTxt().isSelected()) {
				fw = new FileWriter(name+".txt");
			}
			else {
				fw=new FileWriter(name);
			}
			
			BufferedWriter bw=new BufferedWriter(fw);
			
			bw.write(panel.getText().getText());
			panel.getWords().setText(wordcount(panel.getText().getText())+" Wörter gespeichert.");
			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void load(String name) {
		if (name.equalsIgnoreCase("")) {
			panel.getWords().setText("Please choose a filename.");
			return;
		}

		FileReader fr;
		
		StringBuilder sb=new StringBuilder();
		
		try {
			if (panel.getTxt().isSelected()) {
				fr=new FileReader(name+".txt");
			}
			else {
				fr=new FileReader(name);
			}
			
			BufferedReader br=new BufferedReader(fr);
			String test=br.readLine();
			while(test!=null) {
				sb.append(test+"\n");
				test=br.readLine();
			}
			panel.getText().setText(sb.toString());
			panel.getWords().setText(wordcount(sb.toString())+" Wörter eingelesen.");
			br.close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				panel.getWords().setText("This file doesn't exist.");
			}		
	}
	
	public int wordcount(String words) {
		String [] arr=words.split(" ");
		return arr.length;
	}
}
