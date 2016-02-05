import java.awt.*;

public class Car extends Rectangle
{
	public static final int MIN_WIDTH = 100;
	public static final int MIN_HEIGHT = 30;

	private int speed;
	private Color color;
	private int row;

	public Car(int x, int y, int width, int row, int speed, Color color)
	{
		super(x,y,width,MIN_HEIGHT);
		this.speed = speed;
		this.color = color;
		this.row = row;
	}
	
	public static int getYCoordForRow(int row)
	{
		final int TOP_ROW = 0; // y coord for uppermost row
		final int VERTICAL_PADDING = 35; // space between rows
		
		return TOP_ROW + (VERTICAL_PADDING * row);
	}
	
	public int getRow()
	{
		return this.row;
	}

	public Car moveLeft()
	{
		return new Car(x-speed,y,getBounds().width,this.row,speed,color);
	}

	public Car moveRight()
	{
		return new Car(x+speed,y,getBounds().width,row,speed,color);
	}

	public boolean empty()
	{
		return color == null;
	}

	public void draw(Graphics g)
	{
		if(color != null)
		{
			g.setColor(color);
			g.fillRect(x,y,getBounds().width,MIN_HEIGHT);
		}
	}
}