import java.util.Scanner;
 
public class NV1 {
 
    private static final double KR = 0.01;   // Constants                                       
    private static final double KA = 0.005;
 
    private static int N; // the number of nodes                                                
    private static Node[] nodes;
    private static boolean[][] network;
 
    private static double minX = 0, minY = 0, maxX = 0, maxY = 0; // canvas size            
 
    public static void setup() {
        StdDraw.enableDoubleBuffering();
 
        Scanner input = new Scanner(System.in);
        N = input.nextInt();                         // number of nodes                
        nodes = new Node[N];
        network = new boolean[N][N];                 // 2d array of connections        
 
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(Math.random(), Math.random(), input.next());
            // The line above is equivalent to the next three lines:                            
            // nodes[i] = new Node();                                                           
            // nodes[i].setPosition(Math.random(), Math.random());                              
            // nodes[i].setLabel(input.next());                                                 
        }
 
        while (input.hasNext()) {
            int i = input.nextInt();
            int j = input.nextInt();
            network[i][j] = true;
            network[j][i] = true;
        }
    }
 
   public static void computeForces() {
        for (int i = 0; i < N; i++) {         // each node i                                
            for (int j = i + 1; j < N; j++) { // each node j, avoiding symmetric pairs   
                double x0 = nodes[i].getX();
                double y0 = nodes[i].getY();
                double x1 = nodes[j].getX();
                double y1 = nodes[j].getY();
 
                double delX = 0.0;
                double delY = 0.0;
 
                //distance between points i and j                                               
                double r = Math.sqrt(((x1-x0) * (x1-x0)) + ((y1-y0) * (y1-y0)));
                //angle                                                                         
                double theta = Math.atan2((y1 - y0), (x1 - x0));
                if (network[i][j]) {
                    //change in coordinates due to attractive force                             
                    delX += KA * r * r * Math.cos(theta);
                    delY += KA * r * r * Math.sin(theta);
                }
                if (Math.abs(r) > 0.00001) {
                    //change in coordinates due to repulsive force                              
                    delX += (-1.0) * (KR / r) * Math.cos(theta);
                    delY += (-1.0) * (KR / r) * Math.sin(theta);
                }
                // update the changes in x and y                                                
                nodes[i].setDelta(nodes[i].getDX()+delX, nodes[i].getDY()+delY);
                nodes[j].setDelta(nodes[j].getDX()-delX, nodes[j].getDY()-delY);
            }
        }
    }
 
    public static void updatePositions() {
        // update the position of each node                                                     
        for (int count = 0; count < N; count++) {
            nodes[count].setPosition(nodes[count].getX()+nodes[count].getDX(),
                                     nodes[count].getY()+nodes[count].getDY());
 
            nodes[count].setDelta(0,0);
 
            if (nodes[count].getX() > maxX) maxX = nodes[count].getX();
            if (nodes[count].getX() < minX) minX = nodes[count].getX();
 
            if (nodes[count].getY() > maxY) maxY = nodes[count].getY();
            if (nodes[count].getY() < minY) minY = nodes[count].getY();
        }
    }
 
    public static void redraw() {
        // reset the canvas size to account for the new node positions                          
        StdDraw.setXscale(minX-5,maxX+5);
        StdDraw.setYscale(minY-5,maxY+5);
        StdDraw.clear();
        // draw the nodes                                                                       
        for (int i = 0; i < N; i++) {
            String label = nodes[i].getLabel();
			if (label.equals(".")) { // default to invisible circle                             
                Circle cir = new Circle();
                cir.setColor(StdDraw.WHITE);
                cir.setPosition(nodes[i].getX(),nodes[i].getY());
                cir.setRadius(1);
                cir.draw();
            }
            if (label.equals("el")) { // default to invisible circle                             
                Ellipse el = new Ellipse();
                el.setColor(StdDraw.BLUE);
				el.setMajor(0.5);
				el.setMinor(0.25);
				el.setFilled(true);
                el.setPosition(nodes[i].getX(),nodes[i].getY());
                el.draw();
            }
			else if(label.equals("rec")){ // 2 prints a red rectangle
				Rectangle rec = new Rectangle();
				rec.setColor(StdDraw.RED);
				rec.setFilled(true);
				rec.setX(0.5);
				rec.setY(0.25);
				rec.setPosition(nodes[i].getX(),nodes[i].getY());
				rec.draw();
			}
			else if(label.equals("cir")){ // 3 prints a green circle
				Circle cir = new Circle();
                cir.setColor(StdDraw.GREEN);
				cir.setFilled(true);
                cir.setPosition(nodes[i].getX(),nodes[i].getY());
                cir.setRadius(0.5);
                cir.draw();
			}
			else if(label.equals("sq")){ // 4 prints a yellow square
				Square sq = new Square();
                sq.setColor(StdDraw.MAGENTA);
				sq.setFilled(true);
                sq.setPosition(nodes[i].getX(),nodes[i].getY());
                sq.setRadius(0.5);
                sq.draw();
			}
 
            else { // anything else prints text
                Text item = new Text();
                item.setText(nodes[i].getLabel());
                item.setPosition(nodes[i].getX(),nodes[i].getY());
                item.draw();
            }
        }
 
        // draw the edges -- need the Line class                                                
		for (int i = 0; i < N; i++)                                                          
			for (int j = i + 1; j < N; j++) {                                                
				if (network[i][j]) {                                                            
					Line line = new Line();                                                     
					line.setColor(StdDraw.BLUE);                                                
					line.setPosition(nodes[i].getX(),nodes[i].getY(),                          
										nodes[j].getX(),nodes[j].getY());                         
					line.draw();                                                                
			}                                                                               
		}                                                                                
 
        // display all of the figures                                                        
        StdDraw.show();
    }
 
    public static void main (String args[]) {
        int numIterations = 3000; // default                                                    
        if (args.length >= 1)
            try {
                // number of times to run the force-based algorithm                             
                numIterations = Integer.parseInt(args[0]);
            }
            catch (NumberFormatException e) {}
 
        setup();
        for (int numIndex = 0; numIndex < numIterations; numIndex++) {
            computeForces();
            updatePositions();
            redraw();
            StdDraw.pause(5);
        }
    }
}