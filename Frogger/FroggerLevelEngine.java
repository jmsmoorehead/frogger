import java.awt.*;

public class FroggerLevelEngine
{
	public static final int WIDTH = 550;
	public static final int HEIGHT = 350;

	//private TrafficPattern[] traffic;
	private Frog frog;
	private FroggerState state = FroggerState.MOVING;
	private FroggerLevel level;

	public FroggerLevelEngine(FroggerLevel level)
	{
		frog = new Frog(WIDTH/2, HEIGHT-Frog.RADIUS, getBounds());
		this.level = level;
		level.initCars(); // generate intial cars for this level
	}

	public Rectangle getBounds()
	{
		return new Rectangle(0,0,WIDTH,HEIGHT);
	}

	public void update()
	{
		/*for(int i = 0; i < traffic.length; i++)
		{
			traffic[i].update();
			if(traffic[i].intersects(frog))
				state = FroggerState.HIT;
		}*/
		
		this.level.updateCars();
		if(getWinBounds().contains(frog.getBounds()))
			state = FroggerState.WON;
	}

	public Rectangle getWinBounds()
	{
		return new Rectangle(0,0,WIDTH, Car.HEIGHT);
	}

	public FroggerState getState()
	{
		return state;
	}

	public void moveUp()
	{
		if(state == FroggerState.MOVING)
			frog = frog.moveUp();
	}

	public void moveDown()
	{
		if(state == FroggerState.MOVING)
			frog = frog.moveDown();
	}

	public void moveLeft()
	{
		if(state == FroggerState.MOVING)
			frog = frog.moveLeft();
	}

	public void moveRight()
	{
		if(state == FroggerState.MOVING)
			frog = frog.moveRight();
	}

	public void draw(Graphics g)
	{
		frog.draw(g);
		/*for(int i = 0; i < traffic.length; i++)
		{
			traffic[i].draw(g);
		}*/
		
		this.level.drawCars(g);

		if(state == FroggerState.HIT)
		{
			g.setColor(Color.BLACK);
			g.drawString("YOU GOT HIT! Hit the spacebar to restart.", WIDTH/2-50, HEIGHT/2);
		}
	}
}