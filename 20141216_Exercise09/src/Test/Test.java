///**
// * 
// */
//package zwei_geometricalfigure_frame;
//
//import java.awt.Color;
//import java.awt.Graphics;
//
///**
// * @author LFanz2010
// *
// */
//public class Test {
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub		
//		
//		// creates a container for figures 
//		FiguresToDraw ftd=new FiguresToDraw();
//		
//		Rectangle r=new Rectangle(new Position(20, 50), Color.green, Color.black, 3, 100, 100);
//		ftd.addFigure(r);
//
//		r=new Rectangle(new Position(60, 90), Color.red, Color.black, 3, 100, 100);
//		ftd.addFigure(r);
//
//		r=new Rectangle(new Position(190, 90), Color.CYAN, Color.black, 3, 200, 70);
//		ftd.addFigure(r);
//
//		int x=300;
//		int y=300;
//		int height=20;
//		int width=20;
//		for (int i=0; i<10; i++){
//			Color c=new Color(i%256,i%256,i%256);
//			r=new Rectangle(new Position(x, y), c, Color.GREEN, 3, width, height);
//			ftd.addFigure(r);
//			x=x+10;
//			y=y+10;
//			width=width+30;
//			height=height+30;
//		}
//		
//		try {
//			Drawing drawing = new Drawing(ftd,new Position(300,0),800,800);
//			System.out.println(ftd.numberFiguresToDraw() + " figures drawn.");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//	}
//
//}
