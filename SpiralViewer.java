
import javax.swing.JFrame;
import java.util.Scanner;

/**
 class SpiralViewer

 View a "rectangular" spiral, using Java display coordinate system, moving
 outward from the center of the spiral in a counter-clockwise direction.
 That is, it will head rightward on screen, then, upward, then left, then down, etc.

 Length of initial line is unitLength.
 Padding between "layers" of the spiral is also unitLength.

 This is an interactive program requiring the input of
 the length of the initial segment in the spiral (in pixels),
 and the number of line segments in the spiral,
 both of which need to be positive integers.

 */
public class SpiralViewer
{
    public static void main(String[] args)
    {
        int WIDTH = 800;
        int HEIGHT = 500;
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the length of the initial segment in the spiral: ");
        int initialLength = in.nextInt();
        while (initialLength <= 0)
        {
            System.out.println("Please enter a positive number!");
            System.out.print("Please enter the length of the initial segment in the spiral: ");
            initialLength = in.nextInt();
        }
        System.out.print("Please enter the number of line segments in the spiral: ");
        int numberSegment = in.nextInt();
        while(numberSegment <= 0)
        {
            System.out.println("Please enter a positive number!");
            System.out.print("Please enter the number of line segments in the spiral: ");
            numberSegment = in.nextInt();
        }
        JFrame frame = new JFrame();

        frame.setSize(WIDTH,HEIGHT);
        frame.setTitle("Spiral");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SpiralComponent component = new SpiralComponent(initialLength, numberSegment);
        frame.add(component);
        frame.setVisible(true);
    }
}