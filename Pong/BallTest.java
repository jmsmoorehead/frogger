import java.awt.*;
import org.junit.Test;
import static org.junit.Assert.*;


public class BallTest
{

    @Test
    public void testGetLocation() throws Exception
    {
        Ball ball = new Ball(Color.BLACK, 2, 2);
        Point point = ball.getLocation();
        assertEquals(new Point(2, 2), point);
    }
}