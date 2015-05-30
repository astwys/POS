public class Rekursionen {
	public int fakultaet(int n){
		if(n>1)
			n*=fakultaet(n-1);
		return n;
	}
	public int  berechneIntegerWert(String txt){
		try{
			int a=0;
			if(txt.length()>0&&Character.isDigit(txt.charAt(txt.length()-1))){
				a=(txt.charAt(txt.length()-1)-48)+(berechneIntegerWert(txt.substring(0,txt.length()-1))*10);
			}
			return a;
		}
		catch(Exception e){
			System.out.println("Ungültige Zahl!!!");
			return 0; 
		}
	}
}
