import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class testingTest {
	@Test
	public void medianTest() {
		double arr[] = new double[3];
		double result = Testing.median(arr);
		assertEquals(Double.NaN, result, 0.0001);
	}
}
