import static org.junit.Assert.*;
import org.junit.Test;

import java.awt.*;

/**
 * Created by george.carter on 2/3/2016.
 */
public class FrogTest {
    @Test
    public void testGetBounds(){
        Frog f = new Frog(125, 125, new Rectangle(113, 113, 24, 24));
        Rectangle b = f.getBounds();
        assertEquals(new Rectangle(113, 113, 24, 24), b);
    }
}
