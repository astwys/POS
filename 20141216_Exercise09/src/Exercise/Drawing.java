//package zwei_geometricalfigure_frame;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.image.BufferedImage;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
///**
// * 
// * 
// * @author LFanz2010
// *
// */
//public class Drawing extends JFrame {
//
//	// reference to FigurestoDraw
//	private FiguresToDraw figures;
//	
//	// the figures will be drawn in the background
//	private BufferedImage image;
//	
//	/**
//	 * 
//	 * @param figure
//	 * @throws Exception 
//	 */
//	public Drawing(FiguresToDraw figures, Position pos, int width, int height) throws Exception {
//		setTitle("Show figures"); 				// Titelzeile
//		this.setFigures(figures);
//		setLocation(pos.getX(), pos.getY()); 	// Positionieren
//		setSize(width, height); 				// Gr�sse des Frames
//
//		// buffered image to draw
//		image=new BufferedImage(width, height,
//				BufferedImage.TYPE_INT_ARGB_PRE);
//		
//		// draw figures into the bufferedImage
//		drawFigures();
//
//		setVisible(true); 						// sichtbar machen
//
//	}
//
//	/**
//	 * All figures will be drawn. 
//	 */
//	public void paint(Graphics g) {
//		// paint the bufferedimage
//		g.drawImage(image, 0, 0, this);
//    }
//
//	
//	/**
//	 * 
//	 */
//	private void drawFigures(){
//		Graphics2D imageG2D = (Graphics2D) image.createGraphics();
//		figures.drawAllFigures(imageG2D);
//		
//
//	}
//	
//	/**
//	 * @param figures the figures to set
//	 * @throws Exception 
//	 */
//	private void setFigures(FiguresToDraw figures) throws Exception {
//		if (figures==null)
//			throw new Exception("reference must not be null");
//		this.figures = figures;
//	}
//
//	
//
//}
