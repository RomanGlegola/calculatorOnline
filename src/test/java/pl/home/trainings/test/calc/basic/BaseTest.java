package pl.home.trainings.test.calc.basic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pl.home.trainings.calc.main.OnlineCalculator;

public abstract class BaseTest {
	protected static WebDriver driver;
	protected OnlineCalculator calculator;

	@BeforeClass
	public static void browserSetup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.theonlinecalculator.com/");
	}

	@Before
	public void testSetup() {
		calculator = new OnlineCalculator(driver);
	}

	@After
	public void clearResults() {
		calculator.clear();
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
