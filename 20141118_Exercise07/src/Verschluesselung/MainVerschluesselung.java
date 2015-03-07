package Verschluesselung;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class MainVerschluesselung 
{
	Properties dateinamen;
	Properties code;
//	Properties decode;
	
	public MainVerschluesselung (String configuration, String verschluesselung) throws Exception
	{
		dateinamen = new Properties();
		code = new Properties();
		
		FileInputStream dn =new FileInputStream(configuration);
		dateinamen.load(dn);
		dn.close();
		
		FileInputStream cd=new FileInputStream(verschluesselung);
		code.load(cd);
		cd.close();
	}
	
	public MainVerschluesselung() throws Exception
	{
		this("verschluesselung.conf", "schluessel.txt");
	}
	
	public StringBuilder leseText(String dateiname) throws VerschluesselungsException
	{
		if (dateiname==null || dateiname=="")
		{
			throw new VerschluesselungsException("leseText: Ein Dateiname muss angegeben werden.");
		}
		
		StringBuilder str=new StringBuilder();
		Leser leser=new Leser();
		leser.open(dateiname);
		String zeile="";
		zeile=leser.read();
		
		while(zeile!=null)
		{
			str.append(zeile);
			zeile=leser.read();
		}
		
		leser.close();
		return str;
	}
	
	public void dateiSchreiben(String file, String dateiname) throws VerschluesselungsException
	{
		if (file==null || file=="")
			throw new VerschluesselungsException("dateiSchreiben: Es muss angegeben werden wie die Datei heißen soll.");
		if (dateiname==null || dateiname=="")
			throw new VerschluesselungsException("dateiSchreiben: Es muss angegeben werden was in die Datei geschieben werden soll.");
		
		try {
			FileWriter fw=new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(dateiname);
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void codieren(String leseVon, String speichernAls) throws VerschluesselungsException
	{
		
		StringBuilder text=leseText(leseVon);
		String str=text.toString();
		String [] array=str.split("(?!X)");
		
		for (int i=0; i<array.length; i++)
		{
			if (code.containsKey(array[i]))
			{
					array[i]=code.getProperty(array[i]);
			}
		}
		
		String codiert="";
		
		for (int i=0; i<array.length; i++)
		{
			codiert+=array[i];
		}
		dateiSchreiben(speichernAls, codiert);
	}
	
	public void decodieren(String leseVon, String speichernAls) throws VerschluesselungsException
	{
		StringBuilder text=leseText(leseVon);
		String str=text.toString();
		String [] array = str.split("(?!X)");
		
		Properties prop=new Properties();
		
		for (String s:code.stringPropertyNames())
		{
			prop.setProperty(code.getProperty(s), s);
		}
		
		for (int i=0; i<array.length; i++)
		{
			if (prop.containsKey(array[i]))
			{
					array[i]=prop.getProperty(array[i]);
			}
		}
		
		String codiert="";
		
		for (int i=0; i<array.length; i++)
		{
			codiert+=array[i];
		}
		dateiSchreiben(speichernAls, codiert);
	}
	
	public void vergleichen(String ersterText, String zweiterText) throws VerschluesselungsException
	{	
		if (ersterText==null || ersterText=="" || zweiterText==null || zweiterText=="")
			throw new VerschluesselungsException("Vergleichen: Es muss angegeben werden welche Dateien verglichen werden sollen.");
		
		StringBuilder text1 = leseText(ersterText);
		StringBuilder text2 = leseText(zweiterText);
		
		String str1=text1.toString();
		String str2=text2.toString();
		
		String [] array1 = str1.split("(?!X)");
		String [] array2 = str2.split("(?!X)");
		
		if (array1.length!=array2.length) 
			throw new VerschluesselungsException("Die beiden Dateien haben nicht die gleiche Länge.");
			
		
		for (int i=0; i<array1.length;i++)
		{
			if (!array1[i].equals(array2[i]))
			{
				System.err.println("The characters " + array1[i] + " and " + array2[i] + " do not match.");
			}
		}
	}
}
