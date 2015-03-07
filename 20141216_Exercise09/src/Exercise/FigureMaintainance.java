/**
 * 
 */
package Exercise;

import java.util.ArrayList;

/**
 * @author michael
 *
 */
public abstract class FigureMaintainance 
{
	 protected ArrayList<GeometricalFigure> figures;

	/**
	 * 
	 */
	public FigureMaintainance() {
		super();
		figures=new ArrayList<GeometricalFigure>();
	}
	 
	 public GeometricalFigure addFigure (GeometricalFigure figure)
	 {
		 figures.add(figure);
		 return figure;
	 }
	 
	 public GeometricalFigure removeFigure (GeometricalFigure f)
	 {
		 figures.remove(f);
		 return f;
	 }
	 
	 public void showFigures()
	 {
		 for (int i=0; i<figures.size(); i++)
		 {
			 System.out.println(figures.get(i));
		 }
	 }
	 
	 public GeometricalFigure searchFigure(GeometricalFigure f)
	 {
		 
		 return f;
	 }
}
