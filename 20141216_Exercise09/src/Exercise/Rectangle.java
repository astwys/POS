/**
 * 
 */
package Exercise;

import java.awt.Graphics;

/**
 * @author michael
 *
 */
public class Rectangle extends GeometricalFigure
{
	private int a;
	private int b;
	
	/**
	 * @param a
	 * @param b
	 */
	public Rectangle(int a, int b) {
		super();
		setA(a);
		setB(b);
	}
	
	/**
	 * @return the a
	 */
	public int getA() {
		return a;
	}
	/**
	 * @param a the a to set
	 */
	public void setA(int a) {
		this.a = a;
	}
	/**
	 * @return the b
	 */
	public int getB() {
		return b;
	}
	/**
	 * @param b the b to set
	 */
	public void setB(int b) {
		this.b = b;
	}

	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 2*a+2*b;
	}
	
	
}
