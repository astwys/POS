package ioClasses;
//import java.awt.List;
import java.io.*;
import java.util.*;

import javax.swing.JComboBox.KeySelectionManager;


public class Haeuhigkeit 
{
	HashMap<String, Integer>words;
	char [] wordSeperators ={',','.',';',':','(',')','"','&','?','!','<','>','-','`','_','|','[',']','\'','}','0','1','2','3','4','5','6','7','8','9'};
	
	/**
	 * @param words
	 */
	public Haeuhigkeit()
	{
		super();
		words=new HashMap<String, Integer>();
	}
	
	public void analysieren()
	{
		Leser leser=new Leser();
		leser.open();
		String zeile="";
		zeile=leser.read();
		
		while (zeile!=null)
		{
			zeile.toLowerCase();
			for (char ch:wordSeperators)
			{
				zeile=zeile.replace(ch, ' ');
			}
			
			String [] wordline=zeile.split(" ");
			
			for (int i=0; i<wordline.length; i++)
			{
				if (wordline[i].length()>0 && words.containsKey(wordline[i])) 
				{	
					int temp=words.get(wordline[i]);
					words.remove(wordline[i]);
					words.put(wordline[i], (temp+1));
				}
				else words.put(wordline[i], 1);
			}

			zeile=leser.read();
		}
		
		leser.close();	
	}
	
	public void ausgeben()
	{
		for (String key:words.keySet())
		{
			System.out.println(key + ": " +  words.get(key));
		}
	}
	
	public String ausgebenByKey()
	{
		Map<String, Integer> sortedMap=new TreeMap<String, Integer>(words);
		String temp="";
		for (String key:sortedMap.keySet())
			temp=temp+(key + ": " + sortedMap.get(key) + "\n");
		return temp;
	}
	
	public String ausgebenByValue()
	{		
		Map<Integer, String> sortedMap = new TreeMap <Integer,String>(new Comparator<Integer>() 
					{
						@Override
						public int compare(Integer o1, Integer o2) 
						{
							// TODO Auto-generated method stub
							return o2-o1;
						}
					});
		for(String s:words.keySet())
		{
			sortedMap.put(words.get(s), s);
		}
		
		String temp="";
		for (Integer key:sortedMap.keySet())
			temp=temp+(sortedMap.get(key) + ": " + key + "\n");
		return temp;
		
	}
	
	public void dateiAusgebenByKey()
	{
		try {
			FileWriter fw=new FileWriter("ShakespeareSortiertByKey.txt");
			
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write(ausgebenByKey());
			bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public void dateiAusgebenByValue()
	{
		try {
			FileWriter fw=new FileWriter("ShakespeareSortiertByValue.txt");
			
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write(ausgebenByValue());
			bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
