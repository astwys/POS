import javax.swing.SwingUtilities;

/** Programmstart
 * 
 * @author Gerald Schildberger
 * @version 2015 (verbesserte Schülerlösung)
 */
public class Start
{
	/*Swing-Anwendungen sollten immer auf diese Art gestartet werden...
	 */
	public static void main(String[] args)
	{
	   	SwingUtilities.invokeLater(new Runnable() 
	   	{   public void run() 
    	    {

    	    	new ViewHauptfenster();
    	    
    	    }
    	});
	}
}
