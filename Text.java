/*************************************************************************                      
 *  Compilation:  javac Text.java                                                               
 *  Dependencies: Draw.java, Figure.java                                                        
 *                                                                                              
 *  This inherits from the Figure class.                                                        
 *************************************************************************/
import java.awt.Color;
import java.awt.Font;
 
// A Text is a type of Figure                                                                   
public class Text extends Figure {
    // attributes unique to circle                                                              
    private String theText;
    private String fontName;
    private int fontStyle;
    private int fontSize;
    private boolean filled;
 
    public Text() { // default constructor                                                      
        super();        // make sure to create the *whole* object                               
        theText = "";
        fontName = "Arial";
        fontStyle = Font.BOLD;
        fontSize = 30;
    }

    public void setSize(double multiplier){
        fontSize *= multiplier;
    }
 
    public void setText(String text) {
        theText = text;
    }
 
    public void setFont(String name, int style, int size) {
        fontName = name;
        fontStyle = style;
        fontSize = size;
    }
 
    public String getText() { 
        return theText; 
    }

    public void setFilled(boolean f){
        this.filled = f;
    }

    public double getArea(){
        return 0;
    }
 
    public void draw() { // this implements the abstract method of figure                       
        Color savedColor = StdDraw.getPenColor(); // leave no footprint                         
        Font savedFont = StdDraw.getFont();
        StdDraw.setPenColor(theColor);
        StdDraw.setFont(new Font(fontName, fontStyle, fontSize));
        StdDraw.text(theX, theY, theText);
        StdDraw.setFont(savedFont);          // restore the old color and font                  
        StdDraw.setPenColor(savedColor);
    }
}
