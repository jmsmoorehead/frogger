import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class FroggerComponent extends JComponent implements KeyListener, Runnable
{
	private FroggerLevelEngine engine;
	private boolean upPressed, downPressed, leftPressed, rightPressed;
	private Vector<FroggerLevel> levels = new Vector();
	private int level = 0;

	public FroggerComponent()
	{
		super();
		levelInit();
		engine = new FroggerLevelEngine(levels.get(level));
 		setPreferredSize(new Dimension(engine.WIDTH,engine.HEIGHT));

 		addKeyListener(this);
 		Thread run = new Thread(this);
 		run.start();
	}
	
	// the number of ints in the array you pass to level.add will be the number of rows in the level
	// example:
	// new FroggerLevel(new int[]{2,1,1,2})
	// in this example a level is generated with four rows of traffic with speeds 2, 1, 1, and 2
	public void levelInit()
	{
		levels.add(new FroggerLevel(new int[]{2,2,2}));

		levels.add(new FroggerLevel(new int[]{2,1,2,1,2}));

		levels.add(new FroggerLevel(new int[]{1,1,1,1,1,1,1}));

		levels.add(new FroggerLevel(new int[]{1,1,2,2,3,2,1}));

		levels.add(new FroggerLevel(new int[]{1,2,3,4,5}));

		levels.add(new FroggerLevel(new int[]{1,3,4,3,1,2,3,4,5}));
	}

	public void run()
	{
		while(true)
		{
			try
			{
				Thread.sleep(20);
			}
			catch(Exception ex)
			{
			}
			requestFocus();
			update();
			repaint();
		}
	}

	public void paint(Graphics g)
	{
		synchronized(g)
		{
			engine.draw(g);
		}
	}

	public void update()
	{
		if(upPressed)
			engine.moveUp();
		if(downPressed)
			engine.moveDown();
		if(leftPressed)
			engine.moveLeft();
		if(rightPressed)
			engine.moveRight();

		engine.update();

		if(engine.getState() == FroggerState.WON)
		{
			level++;
			if(level >= levels.size())
			{
				JOptionPane.showMessageDialog(this, "You have beaten this game.");
				System.exit(0);
			}
			engine = new FroggerLevelEngine(levels.get(level));
		}
	}

	public void keyPressed(KeyEvent ke)
	{
		if(ke.getKeyCode() == KeyEvent.VK_DOWN)
			downPressed = true;
		else if(ke.getKeyCode() == KeyEvent.VK_UP)
			upPressed = true;
		else if(ke.getKeyCode() == KeyEvent.VK_LEFT)
			leftPressed = true;
		else if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
			rightPressed = true;
		else if(ke.getKeyCode() == KeyEvent.VK_SPACE)
		{
			if(engine.getState() == FroggerState.HIT)
				engine = new FroggerLevelEngine(levels.get(level));
		}
	}

	public void keyReleased(KeyEvent ke)
	{
		if(ke.getKeyCode() == KeyEvent.VK_DOWN)
			downPressed = false;
		else if(ke.getKeyCode() == KeyEvent.VK_UP)
			upPressed = false;
		else if(ke.getKeyCode() == KeyEvent.VK_LEFT)
			leftPressed = false;
		else if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
			rightPressed = false;
	}

	public void keyTyped(KeyEvent ke)
	{
	}
}