// Name: Qiaochu Zhang
// USC NetID: 9111547240
// CS 455 PA1
// Fall 2023


import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;


/**
 class SpiralGenerator

 Generates a "rectangular" spiral, using Java display coordinate system, moving
 outward from the center of the spiral in a counter-clockwise direction.
 That is, it will head rightward on screen, then, upward, then left, then down, etc.

 Length of initial line is unitLength.
 Padding between "layers" of the spiral is also unitLength.

 NOTE: we have provided the public interface for this class.  Do not change
 the public interface.  You can add private instance variables, constants,
 and private methods to the class.  You will also be completing the
 implementation of the methods given.

 */
public class SpiralGenerator {

   private double xStart;
   private double yStart;
   private int length;
   private int count;
   private int delta;
   /**
    Creates a SpiralGenerator starting at startPosition, with length of first segnment and
    distance between "layers" both given as unitLength.  Both values are assuming the Java
    graphics coordinate system.
    @param startPosition starting point of the first segment in the spiral
    @param unitLength in pixels, must be > 0
    */
   public SpiralGenerator(Point2D startPosition, int unitLength) {
      xStart = startPosition.getX();
      yStart = startPosition.getY();
      length = unitLength;
      count = 0;
      delta = 0;
   }

   /**
    Return the coordinates of the next line segment in the spiral.

    */
   public Line2D nextSegment() {
      if(count%4==0) {
         delta=((int)((count+2)/2))*length;
         Line2D.Double segment = new Line2D.Double(xStart, yStart, xStart + delta, yStart);
         count++;
         xStart=xStart+delta;
         return segment;
      }
      else if(count%4==1){
         delta=((int)((count+2)/2))*length;
         Line2D.Double segment = new Line2D.Double(xStart, yStart, xStart, yStart -delta);
         count++;
         yStart=yStart-delta;
         return segment;
      }
      else if(count%4==2) {
         delta=((int)((count+2)/2))*length;
         Line2D.Double segment = new Line2D.Double(xStart, yStart, xStart - delta, yStart);
         count++;
         xStart=xStart-delta;
         return segment;
      }
      else {
         delta=((int)((count+2)/2))*length;
         Line2D.Double segment = new Line2D.Double(xStart, yStart, xStart, yStart + delta);
         count++;
         yStart=yStart+delta;
         return segment;
      }

   }

}
