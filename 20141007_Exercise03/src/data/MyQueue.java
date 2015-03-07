package data;

import java.util.ArrayList;


/**
 * 
 * @author michael
 *
 */
public class MyQueue 
{
	public ArrayList<Object> queue;

	/**
	 * 
	 */
	public MyQueue() 
	{
		super();
		queue= new ArrayList<Object>();
	}
	
	/**
	 * 
	 * @param o
	 */
	public void put (Object o)
	{
		if (o!=null) queue.add(0, o);
		else System.err.println("The object must not be null!");
	}
	
	/**
	 * 
	 * @return
	 */
	public Object get()
	{
		if (queue.size()>0) return queue.remove(queue.size()-1);
		else System.err.println("There are no objects in the arraylist.");
		return null;
	}
	
	/**
	 * prints all elements
	 */
	public void printAllElements()
	{
		for (int i=0; i<queue.size(); i++)
		{
			System.out.println(queue.get(i));
		}
	}
}
