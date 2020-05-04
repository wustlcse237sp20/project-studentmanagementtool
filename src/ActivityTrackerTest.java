import static org.junit.Assert.*;

import org.junit.Test;

public class ActivityTrackerTest {

	ActivityTracker a = new ActivityTracker();

	 @Test
	 public void testCalculate() {
		 System.out.println(a.trackActivities(3)); 
	 } 
}
