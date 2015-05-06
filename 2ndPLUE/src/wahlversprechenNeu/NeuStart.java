package wahlversprechenNeu;

public class NeuStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			NeuViewMain main=new NeuViewMain("SVG", 30);
		} catch (NeuWahlversprechenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
