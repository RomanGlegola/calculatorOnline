package pl.home.trainings.test.calc.basic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AdditionTest extends BaseTest {

	@Test
	public void zeroPlusHundredShouldReturnHundred() {
		assertEquals("Optional Message!", "100", calculator.add(0, 100));
	}

	@Test
	public void twoPlusTwoShouldReturn4() {
		assertEquals("4", calculator.add(2, 2));
	}

	@Test
	public void tenPlusHundredShouldReturn110() {
		assertEquals("110", calculator.add(10, 100));
	}

	@Test
	public void ninetyNinePlusOneShouldReturn100() {
		assertEquals("100", calculator.add(99, 1));
	}

	@Test
	public void fivePlusFiveShouldReturnTen() {
		assertEquals("10", calculator.add(5, 5));
	}
}
