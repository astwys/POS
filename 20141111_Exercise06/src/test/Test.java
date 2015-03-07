package test;

import ioClasses.Haeuhigkeit;

public class Test {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		test();
	}

	public static void test()
	{
		Haeuhigkeit haeuf=new Haeuhigkeit();
		
		haeuf.analysieren();
		haeuf.dateiAusgebenByKey();
		haeuf.dateiAusgebenByValue();
	}
}
