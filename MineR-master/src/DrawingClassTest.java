import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;
import java.awt.event.InputEvent;
import javax.swing.JButton;

/**
 * Created by george.carter on 2/15/2016.
 */

public class DrawingClassTest {
    @Test
    public void testRightClickButtonEnabled() throws Exception
    {
        DrawingClass drw = new DrawingClass();
        drw.setAll();

        Robot robot = new Robot();
        robot.mouseMove(30, 50);
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
        robot.mouseMove(80, 0);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        try { Thread.sleep(50); } catch(InterruptedException ex) { Thread.currentThread().interrupt(); }

        JButton b[] = drw.getClicks();
        assertEquals(false, b[0].isEnabled());
    }
    @Test
    public void testRightClickButtonColor() throws Exception
    {
        DrawingClass drw = new DrawingClass();
        drw.setAll();

        Robot robot = new Robot();
        robot.mouseMove(30, 50);
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
        robot.mouseMove(80, 0);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        try { Thread.sleep(50); } catch(InterruptedException ex) { Thread.currentThread().interrupt(); }

        JButton b[] = drw.getClicks();
        assertEquals(Color.GREEN, b[0].getBackground());
    }
}
