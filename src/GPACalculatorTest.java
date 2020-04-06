import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class GPACalculatorTest {
	
	GPACalculator c = new GPACalculator();
	
	@Test
	public void testCalculate() {
		System.out.println(c.calculateGPA(3));
		
	}

}
