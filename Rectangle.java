import java.awt.Color;
import java.util.InputMismatchException;

public class Rectangle extends Figure {
	
	private double xLength;
	private double yLength;
	private boolean filled;
	
	public Rectangle() {
		super();
		xLength = 2;
		yLength = 1;
	}
	
	public double getX(){
		return this.xLength;
	}
	public void setX(double x){
		if (x <= 0){ // error checking, but not handled directly                             
            throw new InputMismatchException("Invaid input " + x);
		}
		this.xLength = x;
	}
	
	public double getY(){
		return this.yLength;
	}
	public void setY(double y){
		if (y <= 0){ // error checking, but not handled directly                             
            throw new InputMismatchException("Invaid input " + y);
		}
		this.yLength = y;
	}

	public void setSize(double multiplier){//for sorting algo
		if (multiplier <= 0){ // error checking, but not handled directly                             
            throw new InputMismatchException("Invaid input " + multiplier);
		}
		this.yLength *= multiplier;
		this.xLength *= multiplier;
	}
	
	public double getArea(){
		return 2*2*xLength*yLength;
	}
	
	public boolean getFilled(){
		return this.filled;
	}
	public void setFilled(boolean f){
		this.filled = f;
	}
	
	public void draw() { // this implements the abstract method of figure
        Color savedColor = StdDraw.getPenColor(); // leave no footprint                         
        StdDraw.setPenColor(theColor);
        if (filled)
            StdDraw.filledRectangle(super.theX, super.theY, this.xLength, this.yLength);
        else
            StdDraw.rectangle(super.theX, super.theY, this.xLength, this.yLength);
        StdDraw.setPenColor(savedColor);          // restore the old color                      
    }
	
}