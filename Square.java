import java.awt.Color;
import java.util.*;

public class Square extends Rectangle {
	
	private double radius;
	
	public Square(){
		super();
		radius = 1;
		setX(radius);
		setY(radius);
	}
	
	public double getRadius(){
		if (radius <= 0){ // error checking, but not handled directly                             
            throw new InputMismatchException("Invaid input " + radius);
		}
		return this.radius;
	}
	public void setRadius(double radius){
		if (radius <= 0){ // error checking, but not handled directly                             
            throw new InputMismatchException("Invaid input " + radius);
		}
		this.radius = radius;
	}
	public void setSize(double multiplier){
		if (multiplier <= 0){ // error checking, but not handled directly                             
            throw new InputMismatchException("Invaid input " + multiplier);
		}
		this.radius *= multiplier;
	}

	public double getArea(){
		return radius*radius*2*2;
	}
	
	public void draw() { // this implements the abstract method of figure
        Color savedColor = StdDraw.getPenColor(); // leave no footprint                         
        StdDraw.setPenColor(theColor);
        if (getFilled())
            StdDraw.filledSquare(super.theX, super.theY, this.radius);
        else
            StdDraw.square(super.theX, super.theY, this.radius);
        StdDraw.setPenColor(savedColor);          // restore the old color                      
    }
}