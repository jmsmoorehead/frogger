import org.junit.Test;

import java.awt.*;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

/**
 * Created by Amanda on 2/17/2016.
 */


public class isCarRandomTest {
    @Test
    public void isCarRandom() {
        Random random;
        random = new Random();
        Car car1 = new Car(random.nextInt(10), random.nextInt(10) , random.nextInt(10), random.nextInt(10), random.nextInt(10), Color.BLACK);
        Car car2 = new Car(random.nextInt(10), random.nextInt(10) , random.nextInt(10), random.nextInt(10), random.nextInt(10), Color.BLACK);



       //Passing test because they cars are not the same
        assertNotSame(car1, car2);

        //Failing test because they are not the same
        assertSame(car1, car2);
    }
}
