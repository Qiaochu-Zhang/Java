import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 This class tests the SpiralGenerator class.
 Test 1 is a spiral starting from (200, 300) with first-segment length as 5
 and total number of segments as 10.
 Test 1 is a spiral starting from (250, 400) with first-segment length as 20
 and total number of segments as 30.
 This tester also test whether two adjacent segments are connected or perpendicular, and
 whether segment is not horizontal or vertical.
 */
public class SpiralGeneratorTester {
    public static void main(String[] args)
    {
        //Test 1
        System.out.println("Making a spiral starting from java.awt.Point[x=200,y=300]");
        System.out.println("with a unit length of 5, and made up of 10 segments:");
        int number1 = 10;
        int length = 5;
        Point2D point1 =  new Point2D.Double(200,300);
        SpiralGenerator spiral1 = new SpiralGenerator(point1, length);
        Line2D line1 = spiral1.nextSegment();
        System.out.println("Segment #1: "+line1.getP1() + " " + line1.getP2());
        for(int i = 1; i < number1; i++){
            Point2D pointl11 = line1.getP1();
            Point2D pointl12 = line1.getP2();
            double x11=pointl11.getX();
            double y11=pointl11.getY();
            double x12=pointl12.getX();
            double y12=pointl12.getY();
            Line2D line2=spiral1.nextSegment();
            Point2D pointl22 = line2.getP2();
            Point2D pointl21 = line2.getP1();
            double x21=pointl21.getX();
            double y21=pointl21.getY();
            double x22=pointl22.getX();
            double y22=pointl22.getY();
            System.out.println("Segment #"+i+": "+pointl21 + " " + pointl22);
            if((x21!=x12)&&(y21!=y12)){
                System.out.println("FAILED: last two segments are not connected");
                break;
            }
            else if(((x22-x21)*(y21-y22)*(x22-x21)*(y21-y22))>0.001)
            {
                System.out.println("FAILED: segment is not horizontal or vertical.  Skipping pair tests.");
                break;
            }else if(((x12-x11)*(x22-x21)+(y12-y11)*(y22-y21))*((x12-x11)*(x22-x21)+(y12-y11)*(y22-y21))>0.001) {
                System.out.println("FAILED: last two segments are not perpendicular");
                break;
            }
            line1 = line2;
        }
        //Test 2
        System.out.println("Making a spiral starting from java.awt.Point[x=250,y=400]");
        System.out.println("with a unit length of 20, and made up of 30 segments:");
        int number2 = 30;
        int length2 = 20;
        Point2D point1x =  new Point2D.Double(250,400);
        SpiralGenerator spiral2 = new SpiralGenerator(point1x, length2);
        Line2D line1x = spiral2.nextSegment();
        System.out.println("Segment #1: "+line1x.getP1() + " " + line1x.getP2());
        for(int i = 1; i < number2; i++){
            Point2D pointl11 = line1x.getP1();
            Point2D pointl12 = line1x.getP2();
            double x11=pointl11.getX();
            double y11=pointl11.getY();
            double x12=pointl12.getX();
            double y12=pointl12.getY();
            Line2D line2x = spiral2.nextSegment();
            Point2D pointl22 = line2x.getP2();
            Point2D pointl21 = line2x.getP1();
            double x21=pointl21.getX();
            double y21=pointl21.getY();
            double x22=pointl22.getX();
            double y22=pointl22.getY();
            System.out.println("Segment #"+i+": "+pointl21 + " " + pointl22);
            if((x21!=x12)&&(y21!=y12)){
                System.out.println("FAILED: last two segments are not connected");
                break;
            }
            else if(((x22-x21)*(y21-y22)*(x22-x21)*(y21-y22))>0.001)
            {
                System.out.println("FAILED: segment is not horizontal or vertical.  Skipping pair tests.");
                break;
            }else if(((x12-x11)*(x22-x21)+(y12-y11)*(y22-y21))*((x12-x11)*(x22-x21)+(y12-y11)*(y22-y21))>0.001) {
                System.out.println("FAILED: last two segments are not perpendicular");
                break;
            }
            line1x = line2x;
        }

    }
}