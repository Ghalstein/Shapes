/*************************************************************************                      
 *  Compilation:  javac Figure.java                                                             
 *  Dependencies: StdDraw.java,                                                                 
 *                                                                                              
 *  This is the super class for all the figures of StdDraw                                      
 *                                                                                              
 *************************************************************************/
import java.awt.Color;
 
// A figure is any type of drawing object.                                                      
// But by itself is meaningless                                                                 
// The keyword "abstract" makes it uninstantiable.                                              
public abstract class Figure {
 
    protected double theX;   // the x-coordinate                                                
    protected double theY;   // the y-coordinate                                                
    protected Color theColor; // the color of the figure  
	private double thickness;	
 
    protected Figure() {
        // default constructor                                                                  
        theX = 0;
        theY = 0;
        theColor = Color.BLACK;
		thickness = 0.005;
    }

    protected double getX() { return theX; }
    protected double getY() { return theY; }
 
    protected void setPosition(double x, double y) {
        theX = x;
        theY = y;
    }
	
	protected void setThickness(double thickness){ // pen thickness
		this.thickness = thickness;
		StdDraw.setPenRadius(thickness);
	}

    protected double getThickness(){
        return thickness;
    }
	
    protected void setColor(Color color) {
        theColor = color;
    }
 
    protected Color getColor() {
        return theColor;
    }
 
    abstract void draw();
	abstract void setSize(double multiplier);
    abstract double getArea();
    abstract void setFilled(boolean f);
}
