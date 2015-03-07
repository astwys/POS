/**
 * 
 */
package Exercise;

import java.awt.Graphics;

/**
 * @author michael
 *
 */
public class Circle extends GeometricalFigure
{
	private int radius;

	/**
	 * @param radius
	 */
	public Circle(int radius) {
		super();
		setRadius(radius);
	}

	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return Math.PI*(radius*2);
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 2*Math.PI*radius;
	}
}
