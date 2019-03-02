import java.awt.Color;
import java.util.InputMismatchException;
 
public class Line extends Figure {
	
	// attributes of a line
	private double x1;
	private double y1;
	private double x2;
	private double y2;
	
	public Line(){
		super();
		x1 = 0;
		x2 = 1;
		y1 = 0;
		y2 = 0;
	}
	
	public void setPosition(double x1, double y1, double x2, double y2) {
		if (x1 == x2 && y1 == y2){ // error checking, but not handled directly                             
            throw new InputMismatchException("Invaid input");
		}else{
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
    }

    public double getArea() {
    	double length = Math.sqrt(Math.abs(Math.pow(x1,2)-Math.pow(x2,2)) + Math.abs(Math.pow(y1,2)-Math.pow(y2,2)));
    	return length*getThickness();
    }

    public void setSize(double multiplier){
		if (multiplier <= 0){ // error checking, but not handled directly                             
            throw new InputMismatchException("Invaid input " + multiplier);
		}
		this.x1 *= multiplier;
		this.x2 *= multiplier;
		this.y1 *= multiplier;
		this.y2 *= multiplier;
	}
	
	public void draw(){
		Color savedColor = StdDraw.getPenColor();
		StdDraw.setPenColor(theColor);
		StdDraw.line(x1, y1, x2, y2);
	}
	
	
}