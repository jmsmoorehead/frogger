import java.awt.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class FroggerLevelTest{
	public void main(String[] args){
		testFroggerLevel();
	}
	
	@Test
	public void testFroggerLevel(){
		// set up some simple arrays with which to test
		int[] speed = new int[1];
		String[] pattern = new String[1];
		speed[0]=9;
		pattern[0]="RBLM";
		
		// for the return values
		int[] returnedSpeed;
		String[] returnedPattern;
		
		FroggerLevel fl = new FroggerLevel(speed,pattern);
		
		returnedSpeed = fl.getSpeeds();
		returnedPattern = fl.getPatterns();
		
		assertEquals(9,returnedSpeed[0]);
		assertEquals("RBLM",pattern[0]);
	}
}