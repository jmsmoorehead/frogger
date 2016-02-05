import java.awt.*;
import java.util.Vector;

import org.junit.Test;
import static org.junit.Assert.*;

public class trafficPatternTest {
	private int speed;
	private boolean left;
	private Rectangle bounds;
	private Vector<Car> cars;
	private int y;

	 @Test
	 public void testaddCar(){
		 Car car = new Car(2,4,5,Color.MAGENTA);
		 equals(new Car((left?(int)bounds.getWidth():0), y, speed, Color.MAGENTA));
	 }

}