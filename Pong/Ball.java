import java.awt.*;

public class Ball
{
	public static final int RADIUS = 10;

	private int x, y;
	private int dx, dy;
	private Color color;
	private int speed;
	private int speedUpDelay = 25;
	private int delay = 0;

	public Ball(Color c, int x, int y)
	{
		color = c;
		this.x = x;
		this.y = y;e
		dx = (Math.random() < .5)?1:-1;
		dy = (Math.random() < .5)?1:-1;
		speed = 4;
	}

	public void move()
	{
		delay = (delay+1)%speedUpDelay;
		if(delay == 0)
			speed++;
		x+=(int)(getUnitDX()*speed);
		y+=(int)(getUnitDY()*speed);
	}

	public Point getLocation()
	{
		return new Point(x,y);
	}

	private double getUnitDX()
	{
		return ((double)dx/(double)(Math.sqrt(dx*dx + dy*dy)));
	}

	private double getUnitDY()
	{
		return ((double)dy/(double)(Math.sqrt(dx*dx + dy*dy)));
	}

	public void bounceSide(Paddle paddle)
	{
		dx = -dx;
		dy = (int)(Math.random()*8)-4;

		if(dx > 0) { // if the ball is now moving to the right (hit the left paddle)
			x = paddle.getX() + Paddle.WIDTH + Ball.RADIUS;
		}
		else { // hit the right paddle
			x = paddle.getX() - Ball.RADIUS*2;
		}
	}

	public void bounceTop()
	{
		dy = -dy;
		move();
	}

	public void draw(Graphics g)
	{
		g.setColor(color);
		g.fillOval(x-RADIUS, y-RADIUS, RADIUS*2, RADIUS*2);
	}
}