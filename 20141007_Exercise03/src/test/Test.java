package test;

import java.util.ArrayList;

import data.*;


/**
 * 
 * @author michael
 *
 */
public class Test 
{
	private static ArrayList<Object> objects;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		objects = new ArrayList<Object>();
		MyStackTest();
		System.out.println("\n\n");
		MyQueueTest();
	}

	/**
	 * test method for stack
	 */
	private static void MyStackTest()
	{
		String s1 = "Element1";
		String s2 = "Element2";
		String s3 = "Element3";
		int i1= 1;
		int i2=2;
		MyStack st = new MyStack();
		System.out.println("Elemente werden hinzugefügt.\n");
		st.push(s1);
		st.push(s2);
		st.push(s3);
		st.push(i1);
		st.push(i2);
		st.printAllElements();
		System.out.println("\nOberstes Element: " + st.peek());
		System.out.println("Entferntes Element: " + st.pop());
		System.out.println("\nAlle verbleibenden Elemente werden ausgegeben.\n");
		st.printAllElements();
	}
	
	/**
	 * test method for queue
	 */
	private static void MyQueueTest()
	{
		String s1="Element1";
		String s2="Element2";
		String s3="Element3";
		int i1=1;
		int i2=2;
		MyQueue qu=new MyQueue();
		System.out.println("Elemente werden hinzugefügt.\n");
		qu.put(s1);
		qu.put(s2);
		qu.put(s3);
		qu.put(i1);
		qu.put(i2);
		qu.printAllElements();
		System.out.println("\nEntfernetes Element: " + qu.get());
		System.out.println("\nAlle verbleibenden Elemente werden ausgegeben.\n");
		qu.printAllElements();
	}
}
