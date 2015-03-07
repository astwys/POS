package Exercise;

import java.awt.Color;

public abstract class GeometricalFigure implements DrawInt, CalculationInt
{
	private int figureIdendication;
	private Position position;
	private Color fillColor;
	private Color lineColor;
	private int lineWidth;
	private static int uniqueFigureID=100;
	/**
	 * 
	 */
	public GeometricalFigure() {
		super();
	}
	
	/**
	 * @param position
	 * @param fillColor
	 * @param lineColor
	 * @param lineWidth
	 */
	public GeometricalFigure(Position position, Color fillColor,
			Color lineColor, int lineWidth) {
		super();
		setPosition(position);
		setFillColor(fillColor);
		setLineColor(lineColor);
		setLineWidth(lineWidth);
	}

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	/**
	 * @return the fillColor
	 */
	public Color getFillColor() {
		return fillColor;
	}
	/**
	 * @param fillColor the fillColor to set
	 */
	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}
	/**
	 * @return the lineColor
	 */
	public Color getLineColor() {
		return lineColor;
	}
	/**
	 * @param lineColor the lineColor to set
	 */
	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}
	/**
	 * @return the lineWidth
	 */
	public int getLineWidth() {
		return lineWidth;
	}
	/**
	 * @param lineWidth the lineWidth to set
	 */
	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	//-------------------------------------------------------------------------------TODO add toString in Rectangle, Square, Circle
	public String toString() {
		return "GeometricalFigure [figureIdendication=" + figureIdendication
				+ ", fillColor=" + fillColor + ", lineColor=" + lineColor
				+ ", lineWidth=" + lineWidth + ", uniqueFigureID="
				+ uniqueFigureID + "]";
	}
}
