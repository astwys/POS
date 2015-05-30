package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.CompanyExceptions;
import data.Firma;
import gui.View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ViewSuchen extends JFrame implements ActionListener {

	//view && model
	private View view;
	private Firma model;
	//panel
	private JPanel panel_north;
	private JPanel panel_center;
	private JPanel panel_south;
	//fields
	private JLabel lbl_name;
	private JTextField txt_name;
	private JTextArea area;
	private JButton btn_search;

	public ViewSuchen(View view, Firma model) {
		this.view = view;
		this.model = model;
		setTitle("Suchen");
		setBounds(400, 400, 300, 300);
		initComps();
		setVisible(true);
	}
	
	public void initComps() {
		panel_north = new JPanel(new GridLayout(1,2));
		lbl_name = new JLabel("Name:");
		panel_north.add(lbl_name);
		txt_name = new JTextField();
		panel_north.add(txt_name);
		this.add(panel_north, BorderLayout.NORTH);
		
		panel_center = new JPanel(new GridLayout(1,1));
		area = new JTextArea();
		JScrollPane sp = new JScrollPane(area);
		panel_center.add(sp);
		this.add(panel_center);
		
		panel_south = new JPanel();
		btn_search = new JButton("Suchen");
		btn_search.addActionListener(this);
		panel_south.add(btn_search);
		this.add(panel_south, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Suchen":
			try {
				area.setText(model.sucheMitarbeiter(txt_name.getText()));
			} catch (CompanyExceptions e1) {
				view.showErrorMessage("CompanyExceptions", e1.getMessage());
			}
			break;

		default:
			break;
		}
	}
}
