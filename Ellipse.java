import java.awt.Color;
import java.util.*;

public class Ellipse extends Figure{
	
	private double major;
	private double minor;
	private boolean filled;
	
	public Ellipse(){ //default constructor
		super();
		major = 2;
		minor = 1;
	}
	
	public double getX(){
		return this.major;
	}
	public void setX(double major){//
		if (major <= 0){ // error checking, but not handled directly                             
            throw new InputMismatchException("Invaid input " + major);
		}
		this.major = major;
	}
	
	public double getY(){
		return this.minor;
	}
	public void setY(double minor){
		if (minor <= 0){ // error checking, but not handled directly                             
            throw new InputMismatchException("Invaid input " + minor);
		}
		this.minor = minor;
	}
	public void setSize(double multiplier){
		if (multiplier <= 0){ // error checking, but not handled directly                             
            throw new InputMismatchException("Invaid input " + multiplier);
		}
		this.major *= multiplier;
		this.minor *= multiplier;
	}
	
	public boolean getFilled(){
		return this.filled;
	}
	public void setFilled(boolean f){
		this.filled = f;
	}
	
	public double getArea() {
        return major * minor * Math.PI;
    }
	
	public void draw() { // this implements the abstract method of figure
        Color savedColor = StdDraw.getPenColor(); // leave no footprint                         
        StdDraw.setPenColor(theColor);
        if (filled)
            StdDraw.filledEllipse(super.theX, super.theY, this.major, this.minor);
        else
            StdDraw.ellipse(super.theX, super.theY, this.major, this.minor);
        StdDraw.setPenColor(savedColor);          // restore the old color                      
    }
}