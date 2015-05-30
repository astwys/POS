package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.CompanyExceptions;
import data.Firma;

public class ViewEntlassen extends JFrame implements ActionListener {

//	view && model
	private View view;
	private Firma model;
//	number
	private JLabel lbl_number;
	private JTextField txt_number;
//	dismiss
	private JButton btn_dismiss;
//	panel
	private JPanel panel_center;
	private JPanel panel_south;
	
	public ViewEntlassen(View view, Firma model) {
		this.view = view;
		this.model = model;
		setTitle("Entlassen");
		setBounds(300, 300, 450, 150);
		initComps();
		setVisible(true);
	}
	
	public void initComps() {
		//panel_center
		panel_center = new JPanel(new GridLayout(1,2));
		lbl_number = new JLabel("Sozialversicherungsnummer:");
		txt_number = new JTextField();
		panel_center.add(lbl_number);
		panel_center.add(txt_number);
		this.add(panel_center, BorderLayout.CENTER);
		
		//panel_south
		panel_south = new JPanel();
		btn_dismiss = new JButton("Entlassen");
		btn_dismiss.addActionListener(this);
		panel_south.add(btn_dismiss);
		this.add(panel_south, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Entlassen":
			try {
				model.entlassen(this.txt_number.getText());
				view.refreshView();
				this.dispose();
			} catch (Exception e1) {
				view.showErrorMessage("Exception", e1.getMessage());
			}
			break;

		default:
			break;
		}
		
	}
}
