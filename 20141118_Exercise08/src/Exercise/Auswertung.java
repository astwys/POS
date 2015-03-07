package Exercise;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 */

/**
 * @author michael
 *
 */
public class Auswertung 
{
	private StringBuilder stringb=new StringBuilder();

	/**
	 * @throws IOException 
	 * 
	 */
	public Auswertung(String fstart) throws IOException 
	{
		File [] file = File.listRoots();
		listFiles(file);
		// TODO Auto-generated constructor stub
	}

	public void listFiles(File [] fstart) throws IOException
	{
		BufferedWriter bw= new BufferedWriter(new FileWriter("AllFiles.txt"));
		
		if (fstart==null) return;
				
		for (File f:fstart)
		{	
			try {
				bw.write(f.getAbsolutePath());
				bw.write("\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (f.isDirectory())
			{
				listFiles(f.listFiles());
			}
		}
		
		bw.close();
	}
	
	public void write(StringBuilder strb)
	{
		String str=strb.toString();
		try 
		{
			FileWriter fw=new FileWriter("AllFiles.txt");
			BufferedWriter bw= new BufferedWriter(fw);
			
			bw.write(str);
			bw.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}