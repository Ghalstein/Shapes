/*************************************************************************                      
 *  Compilation:  javac Circle.java                                                             
 *  Dependencies: StdDraw.java, Figure.java                                                        
 *                                                                                              
 *  This inherits from the Figure class.                                                        
 *************************************************************************/
import java.awt.Color;
import java.util.*;
 
// A circle is a particular type of Figure                                                      
public class Circle extends Ellipse {
    // attributes unique to circle
    private double theRadius;  // the radius                                                                                                  
 
    public Circle() { // default constructor                                                    
    super();        // make sure to create the *whole* object                               
	theRadius = 1;  // default radius is 1                                                  
    setFilled(false); // default is not filled    
	setX(theRadius);
	setY(theRadius);
    }
 
    public void setRadius(double radius) {
        if (radius <= 0){ // error checking, but not handled directly                             
            throw new InputMismatchException("Invaid input " + radius);
		}
        theRadius = radius;
    }
 
    public double getArea() {
        return theRadius * theRadius * Math.PI;
    }
	
	public void setSize(double multiplier){//for sorting algo
		if (multiplier <= 0){ // error checking, but not handled directly                             
            throw new InputMismatchException("Invaid input " + multiplier);
		}
		this.theRadius *= multiplier;
	}
 
    public void draw() { // this implements the abstract method of figure
        Color savedColor = StdDraw.getPenColor(); // leave no footprint                         
        StdDraw.setPenColor(theColor);
        if (getFilled())
            StdDraw.filledCircle(super.theX, super.theY, this.theRadius);
        else
            StdDraw.circle(super.theX, super.theY, this.theRadius);
        StdDraw.setPenColor(savedColor);          // restore the old color                      
    }
}
