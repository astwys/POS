package data;

import java.util.ArrayList;


/**
 * 
 * @author michael
 *
 */
public class MyStack 
{
	public ArrayList<Object> stack;
	
	
	
	/**
	 * @param stack
	 */
	public MyStack() 
	{
		super();
		stack = new ArrayList<Object>();
	}

	/**
	 * 
	 * @param o
	 */
	public void push (Object o)
	{
		if (o!=null) stack.add(o);
		else System.err.println("Object must not be null!");
	}
	
	/**
	 * 
	 * @return
	 */
	public Object pop()
	{
		if (stack.size()>0) return stack.remove(stack.size()-1);
		else System.err.println("There are no objects in the arraylist.");
		return null;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public Object peek()
	{
		if (stack.size()>0) return (stack.get(stack.size()-1));
		else System.err.println("There are no objects in the arraylist.");
		return null;
	}
	
	/**
	 * prints all elements
	 */
	public void printAllElements()
	{
		for (int i=0; i<stack.size(); i++)
		{
			System.out.println(stack.get(i));
		}
	}
}
