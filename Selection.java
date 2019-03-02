/******************************************************************************                 
 *  Compilation:  javac Selection.java                                                          
 *  Execution:    java Selection                                                                
 *                                                                                              
 *  Selection sort.                                                                             
 ******************************************************************************/
import java.util.Scanner;
 
public class Selection {
    public static void sort(Figure[] figs) {
        int n = figs.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            figs[min].setColor(StdDraw.RED);
            display(figs);
            StdDraw.pause(3000);
            for (int j = i+1; j < n; j++){
	            if (figs[j].getArea() - figs[min].getArea() < 0){
                    min = j;   
                }
            }
            figs[min].setColor(StdDraw.BLUE);
            display(figs);
            StdDraw.pause(3000);
            // swap                                                                             
            Figure temp = figs[i];
            figs[i] = figs[min];
            figs[min] = temp;
            figs[min].setColor(StdDraw.BLACK);
            figs[i].setColor(StdDraw.GREEN);
            StdDraw.clear();
            display(figs);
            StdDraw.pause(3000);
	   }
    }

    // draws the figures in order
    private static void display(Figure[] figs){
        for(int i = 0; i < figs.length; i++){
            figs[i].setPosition(1.5 + 2*i, 10);
            figs[i].setFilled(true);
            figs[i].draw();
            setup();
            StdDraw.show();
        }
    }

    private static void setup(){
        Text red = new Text();
        red.setSize(.5);
        Text blue = new Text();
        blue.setSize(.4);
        Text green = new Text();
        green.setSize(.3);
        red.setColor(StdDraw.RED);
        blue.setColor(StdDraw.BLUE);
        green.setColor(StdDraw.GREEN);
        red.setText("Red is currently being sorted");
        red.setPosition(10.5,18);
        blue.setText("Blue is the smallest shape found");
        blue.setPosition(10.5,16);
        green.setText("Green has been been sorted already");
        green.setPosition(10.5,14);
        red.draw();
        blue.draw();
        green.draw();
    }
 
    /* Unit Test */
    public static void main(String[] args) {
        StdDraw.setXscale(0, 21);
        StdDraw.setYscale(0, 20);
        StdDraw.enableDoubleBuffering();
        Figure[] figures = new Figure[10];
        for (int i = 0; i < 10; i++) {
            int shape = (int) (Math.random() * 2);
            if (shape == 0)
            figures[i] = new Square();
            else
                figures[i] = new Circle();
            figures[i].setSize(Math.random());
        }
        display(figures);
        StdDraw.pause(1000);
        sort(figures);
    }
}
