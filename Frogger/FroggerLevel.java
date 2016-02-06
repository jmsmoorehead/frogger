import java.util.Vector;
import java.util.Random;
import java.awt.*;

public class FroggerLevel implements java.io.Serializable
{

	private int[] speeds;
	private int rowCount;
	private Vector<Car> carVector; //stores all the cars
	private Color[] colors; // colors for each row
	private Random rand; // rng for adding new cars

	public FroggerLevel(int[] speeds)
	{
		this.rand = new Random(System.currentTimeMillis());
		this.speeds = speeds;
		this.rowCount = speeds.length; // number of rows of traffic
		this.carVector = new Vector<Car>(); // this is where cars that are currently on the screen are stored
		this.colors = new Color[this.rowCount];
		this.initColors();
	}
	
	private void initColors()
	{
		for(int i = 0; i < this.rowCount; ++i){
			int c = rand.nextInt(6); // 6 possible colors
			switch (c){
				case 0:
					this.colors[i] = new Color(0, 0, 0); //black
					break;
				case 1:
					this.colors[i] = new Color(100, 100, 100); // gray
					break;
				case 2:
					this.colors[i] = new Color(0, 220, 0); //green
					break;
				case 3:
					this.colors[i] = new Color(220, 0, 0); //red
					break;
				case 4:
					this.colors[i] = new Color(0, 220, 220); //cyan
					break;
				case 5:
					this.colors[i] = new Color(220, 0, 220); // poyple
					break;
			}
		}
	}
	
	// called by FroggerLevelEngine at the start of each level
	public void initCars(FroggerLevelEngine engine, Frog frog)
	{
		// now this right here is very important
		// it 'updates' the cars a bunch of times at the start of the level
		// without this, all of the cars would start at the edge of the screen (where they are generated)
		// then the player could just shoot up the middle really fast
		for(int i = 0; i < 400; ++i)
		{
			this.updateCars(engine,frog);
		}
	}
	
	private boolean isRowMovingLeft(int row)
	{
		return (row % 2) == 0;
	}
	
	// moves cars along the screen and generates new cars at random
	// also deletes cars if they slide offscreen
	public void updateCars(FroggerLevelEngine engine,Frog frog)
	{
		for(int car = 0; car < this.carVector.size(); ++car)
		{
			
			// this chunk o code moves cars along the screen
			Car currentCar = this.carVector.get(car);
			if(this.isRowMovingLeft(currentCar.getRow()))
			{
				this.carVector.add(car,currentCar.moveLeft());
				this.carVector.remove(car + 1);
			} else {
				this.carVector.add(car,currentCar.moveRight());
				this.carVector.remove(car + 1);
			}
			
			// remove car if it slid offscreen
			if(this.isRowMovingLeft(currentCar.getRow()))
			{
				Rectangle rect = currentCar.getBounds();
				if(rect.x + rect.width < 0){
					this.carVector.remove(car);
					--car;
					continue;
				}
			}
			else
			{
				Rectangle rect = currentCar.getBounds();
				if(rect.x > FroggerLevelEngine.WIDTH){
					this.carVector.remove(car);
					--car;
					continue;
				}
			}
			
			// get hit
			if(frog.getBounds().intersects(currentCar.getBounds()))
			{
				engine.setState(FroggerState.HIT);
			}
		}
		
		
		// this chunk o code might generate a new car
		// first a potential car is generated (on a random row), then a
		// test rectangle is created based on the car --
		// but the test rectangle is wider than the car.
		// then the test rectangle is checked against all
		// of the other cars, and if there are no
		// intersections (collisions), then the new car
		// is added to the vector, otherwise the new car is dropped (canceled)
		int row = this.rand.nextInt(this.rowCount); // choose a random row
		int xCoord;
		int width = Car.MIN_WIDTH + this.rand.nextInt(200); // randomly generated width for potential car
		
		if(this.isRowMovingLeft(row))
		{
			xCoord = FroggerLevelEngine.WIDTH + this.rand.nextInt(200); // set to right-ish edge of screen
		} else {
				xCoord = -width - this.rand.nextInt(200);
		}
		
		Car potentialCar = new Car(xCoord,Car.getYCoordForRow(row),width,row,this.speeds[row],this.colors[row]);
		int xPadding = 200+this.rand.nextInt(180); // between 200 and (200+180)
		
		Rectangle potentialCarRect = potentialCar.getBounds();
		// the purpose of the test rect being wider than the car it represents is so the cars
		// don't get generated too close to each other
		Rectangle testRect = new Rectangle(potentialCarRect.x - (xPadding / 2), potentialCarRect.y,
		potentialCarRect.width + xPadding, potentialCarRect.height);
		
		boolean fail = false;
		for(int car = 0; car < this.carVector.size(); ++car)
		{
			if(this.carVector.get(car).intersects(testRect))
			{
				fail = true;
				break;
			}
		}
		if(!fail) this.carVector.add(potentialCar);	
	}
	
	public void drawCars(Graphics g)
	{
		for(int car = 0; car < this.carVector.size(); ++car)
		{
			this.carVector.get(car).draw(g);
		}
	}
}