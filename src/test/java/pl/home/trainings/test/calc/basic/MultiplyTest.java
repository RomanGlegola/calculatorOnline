package pl.home.trainings.test.calc.basic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MultiplyTest extends BaseTest {

	@Test
	public void ten_times_ten_should_return_hundred() {
		assertEquals("100", calculator.multiply(10, 10));
	}

	@Test
	public void zero_times_ten_should_return_0() {
		assertEquals("0", calculator.multiply(0, 10));
	}

	@Test
	public void one_times_ten_should_return_10() {
		assertEquals("10", calculator.multiply(1, 10));
	}

}
