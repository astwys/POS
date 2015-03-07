/**
 * 
 */
package Exercise;

import java.awt.Graphics;

/**
 * @author michael
 *
 */
public class Square extends GeometricalFigure 
{
	private int a;

	/**
	 * @param a
	 */
	public Square(int a) {
		super();
		setA(a);
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

	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return a*a;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return a*4;
	}
	
	
}
