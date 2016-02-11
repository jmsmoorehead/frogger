import java.awt.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class CarTest {

    public void main(String[] args) {
        testMoveRight();
    }

    @Test
    public void testMoveRight()
    {
        Car car = new Car(2,2,4,1, 1,Color.BLACK);
        Car newCar = car.moveRight();
        assertEquals(new Car(6,2,4,1, 1, Color.BLACK),newCar);
    }
}
