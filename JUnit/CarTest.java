import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.assertEquals;

public class CarTest {

    public void main(String[] args) {
        testMoveRight();
    }

    @Test
    public void testMoveRight()
    {
        int x=2;
        int y=3;
        int width=4;
        int row=1;
        int speed=3;
        Car car = new Car(x,y,width,row,speed,Color.BLACK);
        Car newCar = car.moveRight();
        assertEquals(new Car(x+speed,y,width,row,speed,Color.BLACK),newCar);
    }
}
