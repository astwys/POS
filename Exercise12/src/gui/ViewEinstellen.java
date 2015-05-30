package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.modelmbean.ModelMBean;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.Abteilungsleiter;
import data.CompanyExceptions;
import data.Firma;
import data.Mitarbeiter;
import data.TeilzeitAngestellter;

public class ViewEinstellen extends JFrame implements ActionListener {

//	panel
	private JPanel panel_center;
	private JPanel panel_south;
//	controller && model
	private View view;
	private Firma model;
//	name
	private JLabel lb_name;
	private JTextField txt_name;
//	number
	private JLabel lb_number;
	private JTextField txt_number;
//	type
	private JLabel lb_type;
	private JComboBox cbo_type;
//	employ
	private JButton btn_employ;
	
	
	public ViewEinstellen(View view, Firma model) {
		setTitle("Anstellen");
		setBounds(300, 300, 450, 250);
		this.view = view;
		this.model = model;
		initComps();
		setVisible(true);
	}
	
	public void initComps() {
		panel_center = new JPanel(new GridLayout(3,2));
		panel_south = new JPanel();
		
		//name
		lb_name = new JLabel();
		lb_name.setText("Name: ");
		txt_name = new JTextField();
		panel_center.add(lb_name);
		panel_center.add(txt_name);		
		
		//number
		lb_number = new JLabel();
		lb_number.setText("Sozialversicherungsnummer: ");
		txt_number = new JTextField();
		panel_center.add(lb_number);
		panel_center.add(txt_number);
		
		//type
		lb_type = new JLabel();
		lb_type.setText("Type: ");
		String[] types = {Firma.ABTEILUNGSLEITER, Firma.TEILZEITANGESTELLTER};
		cbo_type = new JComboBox(types);
		panel_center.add(lb_type);
		panel_center.add(cbo_type);
		
		btn_employ = new JButton("Hinzufügen");
		btn_employ.setSize(100, 100);
		btn_employ.addActionListener(this);
		panel_south.add(btn_employ);
		
		this.add(panel_center, BorderLayout.CENTER);
		this.add(panel_south, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Hinzufügen":
			if(cbo_type.getSelectedItem().equals(Firma.ABTEILUNGSLEITER)) {
				try {
					model.einstellen(new Abteilungsleiter(this.txt_name.getText(), this.txt_number.getText(), 2000, 22));
					view.refreshView();
					this.dispose();
				} catch (CompanyExceptions e1) {
					view.showErrorMessage("CompanyExceptions", e1.getMessage());
				}
				//gehalt und mitarbeiter sollten mit implementiert werden
			}
			else if(cbo_type.getSelectedItem().equals(Firma.TEILZEITANGESTELLTER)){
				try {
					model.einstellen(new TeilzeitAngestellter(this.txt_name.getText(), this.txt_number.getText(), 2000, 30));
					view.refreshView();
					this.dispose();
				} catch (CompanyExceptions e1) {
					view.showErrorMessage("CompanyExceptions", e1.getMessage());
				}
				//gehalt und stundenProWoche sollte mit implementiert werden
			}
			break;

		default:
			break;
		}
		
	}
}
