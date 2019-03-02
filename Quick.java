/******************************************************************************                 
 *  Compilation:  javac Quick.java                                                              
 *  Execution:    java Quick                                                                    
 ******************************************************************************/
import java.awt.Color;
import java.util.Scanner;
 
public class Quick {
 
    public static void sort(Figure[] figs) {
        // might shuffle elements to makes sure T is not sorted                                 
        sort(figs, 0, figs.length - 1);
    }
 
    // quicksort the subarray from a[lo] to a[hi]                                               
    private static void sort(Figure[] figs, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(figs, lo, hi); 
        sort(figs, lo, j-1);
        sort(figs, j+1, hi);
    }
 
    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]                
    // and return the index j.                                                                  
    private static int partition(Figure[] figs, int lo, int hi) {
	    int i = lo;
        int j = hi + 1;
        Figure v = figs[lo]; // use the leftmost element for the pivot
        StdDraw.clear();
        v.setColor(StdDraw.MAGENTA);
        display(figs);
        StdDraw.pause(2000);
        while (true) {
            // find item on lo to swap                                                          
            while (figs[++i].getArea() - v.getArea() < 0) // search lo to hi 
                if (i == hi) break;
            // find item on hi to swap    // search hi to lo
            while (v.getArea() - figs[--j].getArea() < 0) 
                if (j == lo) break;      // redundant; a[lo] acts as a sentinel              
            // check if pointers cross                                                          
            if (i >= j) break;
            StdDraw.clear();
            figs[i].setColor(StdDraw.RED); 
            figs[j].setColor(StdDraw.RED);
            display(figs);
            StdDraw.pause(2000); 
            exch(figs, i, j);
            StdDraw.clear();
            figs[i].setColor(StdDraw.BLACK); 
            figs[j].setColor(StdDraw.BLACK);
            display(figs);
            StdDraw.pause(2000);          
        }
        // put partitioning item v at a[j]                                                
        exch(figs, lo, j);
        StdDraw.clear(); 
        figs[j].setColor(StdDraw.GREEN);
        display(figs);
        StdDraw.pause(2000);
        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]                                            
        return j;
    }
 
   /***************************************************************************                 
    *  Helper functions.                                                                        
    ***************************************************************************/
 
    // exchange a[i] and a[j]                                                                   
    private static <T> void exch(Figure[] figs, int i, int j) {
        Figure swap = figs[i];
        figs[i] = figs[j];
        figs[j] = swap;
    }

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
        Text mag = new Text();
        mag.setSize(.5);
        Text red = new Text();
        red.setSize(.4);
        Text green = new Text();
        green.setSize(.3);
        mag.setColor(StdDraw.MAGENTA);
        red.setColor(StdDraw.RED);
        green.setColor(StdDraw.GREEN);
        mag.setText("Magenta is the pivot");
        mag.setPosition(10.5,18);
        red.setText("Red are shapes being swapped");
        red.setPosition(10.5,16);
        green.setText("Green has been sorted already");
        green.setPosition(10.5,14);
        mag.draw();
        red.draw();
        green.draw();
    }

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
        StdDraw.pause(2000);
        Quick.sort(figures);
        for(Figure test: figures){ // For visual purposes -- makes any leftover shapes that were sorted already green
            if(test.getColor() != Color.GREEN){ 
                test.setColor(Color.GREEN);
                StdDraw.clear(); 
                test.setColor(StdDraw.GREEN);
                display(figures);
                StdDraw.pause(2000);
            }
        }
    }
}
