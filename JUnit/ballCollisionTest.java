import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.*;

public class ballCollisionTest{
    @Test
    public void testCollision() throws Exception{
        Paddle paddle = new Paddle(10,Paddle.HEIGHT/2);
        Ball ball = new Ball(Color.BLACK,10,Paddle.HEIGHT/2);

        assertEquals(true,paddle.contains(ball)); // this should pass

        /*
        the ball.bounceSide() method negates the balls x-velocity (the speed at which it moves
        along the x-axis), thus having the effect of a "bounce". Then, it calls the move method
        twice, (the move method just moves the ball along both axises, according to each velocity
        for that axis). The problem is when the ball is moving slow enough, calling move() twice
        does not un-collide the ball from the paddle, and when the next frame is being prepared,
        the ball is still colliding with the paddle, and this process repeats over and over and
        over. The effect of this is a sort of bouncing glitch where the ball appears to be 'stuck'
        inside the paddle until it eventually breaks free.
         */
        ball.bounceSide(paddle);

        assertEquals(false,paddle.contains(ball)); // this will pass now
    }
}