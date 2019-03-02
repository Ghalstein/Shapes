// The Node Class for a Network                                                                 
public class Node {
    private double nx;   // x and y coordinate                                                  
    private double ny;
    private double dx;   // x and y adjustments                                                 
    private double dy;
    private String label; // the label to use for display                                       
 
    public Node() {
        // default constructor                                                                  
        nx = 0;
        ny = 0;
        dx = 0;
        dy = 0;
		label = ".";
    }

    public Node(double x, double y, String lab) {
        // initialize the position and label                                                    
        nx = x;
        ny = y;
        dx = 0;
        dy = 0;
        label = lab;
    }
    public double getX() { return nx; }
    public double getY() { return ny; }
    public void setPosition(double x, double y) {
        nx = x;
        ny = y;
    }
 
    public double getDX() { return dx; }
    public double getDY() { return dy; }
    public void setDelta(double x, double y) {
        dx = x;
        dy = y;
    }
 
    public String getLabel() { return label; }
    public void setLabel(String lab) {
        label = lab;
    }
}
