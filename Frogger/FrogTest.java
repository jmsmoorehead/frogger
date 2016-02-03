import static org.junit.Assert.*;
import org.junit.Test;

import java.awt.*;

/**
 * Created by george.carter on 2/3/2016.
 */
public class FrogTest {
    @Test
    public void testGetBounds(){
        Frog f = new Frog(125, 125, new Rectangle(120, 120, 10, 10));
        Rectangle b = f.getBounds();
        assertEquals(new Rectangle(120, 120, 10, 10), b);
    }
}