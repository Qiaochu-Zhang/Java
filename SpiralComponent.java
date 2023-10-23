import java.awt.*;
import javax.swing.JComponent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * This Class extends JComponent.
 This component utilize a for loop to draws spirals through SpiralGenerator.

 */
public class SpiralComponent extends JComponent
{

    private int callCount;
    private int length;
    private int number;
    // This is a constructor class for SpiralComponent.
    /**
     Creates a SpiralComponent with length of first segment as length and the
     number of segments as number.  Both values are assuming the Java
     graphics coordinate system.
     @param number must be integer >0
     @param length in pixels, must be integer> 0
     */
    public SpiralComponent(int length, int number) {
        callCount = 0;
        this.length = length;
        this.number = number;
    }
    /**
     This method override former method to draw spirals.
     @param g must be Graphics type
     */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;


        // the following two lines are for instrumentation
        callCount++;
        System.out.println("Called paintComponent(" + callCount + ")");

        Point2D point1 = new Point2D.Double((double)(getWidth())/2,((double) getHeight())/2);
        SpiralGenerator spiral1 = new SpiralGenerator(point1, length);
        for(int i = 0; i < number; i++){
            //spiral1.draw(g2);
            Line2D line = spiral1.nextSegment();
            g2.draw(line);
        }
    }
}
