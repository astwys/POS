import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;


public class SimpleListener implements ActionListener {

	private SimplePanel panel;
	Properties prop=new Properties();
	
	public SimpleListener(SimplePanel p) {
		// TODO Auto-generated constructor stub
		panel=p;
		try {
			FileInputStream in=new FileInputStream("exchangerates.conf");
			prop.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String currency=panel.getCurrencyFrom_TF().getText().toUpperCase()+"-"+panel.getCurrencyTo_TF().getText().toUpperCase();
		float money=Float.parseFloat(panel.getMoneyFrom_TF().getText());
		if (prop.containsKey(currency)) {
			float exc=Float.parseFloat(prop.getProperty(currency));
			float result=money*exc;
			panel.getExchangeRate().setText(currency+": " + exc);
			panel.getMoneyTo_TF().setText(result+"");
			panel.getError().setText("");
		}
		else {
			panel.getError().setText("Please use valid currencies!");
		}
	}

}
