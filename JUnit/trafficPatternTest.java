import java.awt.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class trafficPatternTest {
	public int speed;
	public boolean left;
	public Rectangle bounds;
	public int y;

	 @Test
	 public void testAddCar(){
		 Car car = new Car(2,4,5,Color.MAGENTA);
		 assertEquals(car, new Car((left?(int)bounds.getWidth():0), y, speed, Color.MAGENTA));
	 }

}