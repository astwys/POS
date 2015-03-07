import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SimplePanel extends JPanel{
	private JTextField moneyFrom_TF;
	private JTextField moneyTo_TF;
	private JTextField currencyFrom_TF;
	private JTextField currencyTo_TF;
	private JLabel exchangeRate;
	private JLabel error;
	
	private JButton calculate_BTN;
	
	private JPanel textfieldPanel1_PNL;
	private JPanel textfieldPanel2_PNL;
	
	private SimpleListener listener;
	
	public SimplePanel() {
		listener=new SimpleListener(this);
		
		moneyFrom_TF=new JTextField();
		moneyFrom_TF.setPreferredSize(new Dimension(70,20));
		
		moneyTo_TF=new JTextField();
		moneyTo_TF.setPreferredSize(new Dimension(70,20));
		moneyTo_TF.setEditable(false);
		
		currencyFrom_TF=new JTextField();
		currencyFrom_TF.setPreferredSize(new Dimension(70,20));
		
		currencyTo_TF=new JTextField();
		currencyTo_TF.setPreferredSize(new Dimension(70,20));
		
		exchangeRate=new JLabel("exchange rate:");
		error=new JLabel();
		
		textfieldPanel1_PNL=new JPanel();
		
		textfieldPanel2_PNL=new JPanel();
		
		
		textfieldPanel1_PNL.add(new JLabel("currency have: "));
		textfieldPanel1_PNL.add(currencyFrom_TF);
		
		textfieldPanel1_PNL.add(new JLabel("currency want: "));
		textfieldPanel1_PNL.add(currencyTo_TF);
		
		textfieldPanel2_PNL.add(moneyFrom_TF);
		textfieldPanel2_PNL.add(moneyTo_TF);
		textfieldPanel2_PNL.add(exchangeRate);
		
		calculate_BTN=new JButton("calculate");
		calculate_BTN.addActionListener(listener);
		
		this.setLayout(new GridLayout(3,4,10,10));
		this.add(textfieldPanel1_PNL);
		this.add(textfieldPanel2_PNL);
		this.add(calculate_BTN);
		this.add(error);
	}

	/**
	 * @return the error
	 */
	public JLabel getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(JLabel error) {
		this.error = error;
	}

	/**
	 * @return the exchangeRate
	 */
	public JLabel getExchangeRate() {
		return exchangeRate;
	}

	/**
	 * @param exchangeRate the exchangeRate to set
	 */
	public void setExchangeRate(JLabel exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	/**
	 * @return the textfieldPanel1_PNL
	 */
	public JPanel getTextfieldPanel1_PNL() {
		return textfieldPanel1_PNL;
	}

	/**
	 * @param textfieldPanel1_PNL the textfieldPanel1_PNL to set
	 */
	public void setTextfieldPanel1_PNL(JPanel textfieldPanel1_PNL) {
		this.textfieldPanel1_PNL = textfieldPanel1_PNL;
	}

	/**
	 * @return the textfieldPanel2_PNL
	 */
	public JPanel getTextfieldPanel2_PNL() {
		return textfieldPanel2_PNL;
	}

	/**
	 * @param textfieldPanel2_PNL the textfieldPanel2_PNL to set
	 */
	public void setTextfieldPanel2_PNL(JPanel textfieldPanel2_PNL) {
		this.textfieldPanel2_PNL = textfieldPanel2_PNL;
	}

	/**
	 * @return the moneyFrom_TF
	 */
	public JTextField getMoneyFrom_TF() {
		return moneyFrom_TF;
	}

	/**
	 * @param moneyFrom_TF the moneyFrom_TF to set
	 */
	public void setMoneyFrom_TF(JTextField moneyFrom_TF) {
		this.moneyFrom_TF = moneyFrom_TF;
	}

	/**
	 * @return the moneyTo_TF
	 */
	public JTextField getMoneyTo_TF() {
		return moneyTo_TF;
	}

	/**
	 * @param moneyTo_TF the moneyTo_TF to set
	 */
	public void setMoneyTo_TF(JTextField moneyTo_TF) {
		this.moneyTo_TF = moneyTo_TF;
	}

	/**
	 * @return the currencyFrom_TF
	 */
	public JTextField getCurrencyFrom_TF() {
		return currencyFrom_TF;
	}

	/**
	 * @param currencyFrom_TF the currencyFrom_TF to set
	 */
	public void setCurrencyFrom_TF(JTextField currencyFrom_TF) {
		this.currencyFrom_TF = currencyFrom_TF;
	}

	/**
	 * @return the currencyTo_TF
	 */
	public JTextField getCurrencyTo_TF() {
		return currencyTo_TF;
	}

	/**
	 * @param currencyTo_TF the currencyTo_TF to set
	 */
	public void setCurrencyTo_TF(JTextField currencyTo_TF) {
		this.currencyTo_TF = currencyTo_TF;
	}

	/**
	 * @return the calculate_BTN
	 */
	public JButton getCalculate_BTN() {
		return calculate_BTN;
	}

	/**
	 * @param calculate_BTN the calculate_BTN to set
	 */
	public void setCalculate_BTN(JButton calculate_BTN) {
		this.calculate_BTN = calculate_BTN;
	}
}
