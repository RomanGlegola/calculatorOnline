package pl.home.trainings.calc.main;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OnlineCalculator {
	private static final String NINE_BUTTON_XPATH = ".//*[@id='calculator']/div[4]/input[3]";
	private static final String EIGHT_BUTTON_XPATH = ".//*[@id='calculator']/div[4]/input[2]";
	private static final String SEVEN_BUTTON_XPATH = ".//*[@id='calculator']/div[4]/input[1]";
	private static final String SIX_BUTTON_XPATH = ".//*[@id='calculator']/div[5]/input[3]";
	private static final String FIVE_BUTTON_XPATH = ".//*[@id='calculator']/div[5]/input[2]";
	private static final String FOUR_BUTTON_XPATH = ".//*[@id='calculator']/div[5]/input[1]";
	private static final String THREE_BUTTON_XPATH = ".//*[@id='calculator']/div[6]/input[3]";
	private static final String TWO_BUTTON_XPATH = ".//*[@id='calculator']/div[6]/input[2]";
	private static final String ONE_BUTTON_XPATH = ".//*[@id='calculator']/div[6]/input[1]";
	private static final String ZERO_BUTTON_XPATH = ".//*[@id='calculator']/div[7]/input[1]";

	@FindBy(xpath = ".//*[@id='calculator']/div[6]/input[4]")
	private WebElement addButton;

	@FindBy(xpath = ".//*[@id='calculator']/div[5]/input[4]")
	private WebElement subtractButton;

	@FindBy(xpath = ".//*[@id='calculator']/div[4]/input[4]")
	private WebElement multiplyButton;

	@FindBy(xpath = ".//*[@id='calculator']/div[7]/input[4]")
	private WebElement calculateButton;

	@FindBy(xpath = ".//*[@id='display']")
	private WebElement resultScreenTextBox;

	@FindBy(xpath = ".//*[@id='calculator']/div[3]/input[1]")
	private WebElement clearResultsButton;

	private WebDriver driver;
	private static Map<Character, String> buttonsMap;

	static {
		buttonsMap = new HashMap<>();
		buttonsMap.put('0', ZERO_BUTTON_XPATH);
		buttonsMap.put('1', ONE_BUTTON_XPATH);
		buttonsMap.put('2', TWO_BUTTON_XPATH);
		buttonsMap.put('3', THREE_BUTTON_XPATH);
		buttonsMap.put('4', FOUR_BUTTON_XPATH);
		buttonsMap.put('5', FIVE_BUTTON_XPATH);
		buttonsMap.put('6', SIX_BUTTON_XPATH);
		buttonsMap.put('7', SEVEN_BUTTON_XPATH);
		buttonsMap.put('8', EIGHT_BUTTON_XPATH);
		buttonsMap.put('9', NINE_BUTTON_XPATH);
	}

	public OnlineCalculator(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String add(int a, int b) {
		typeNumber(a);
		addButton.click();
		typeNumber(b);
		calculateButton.click();
		return getScreenContent();
	}

	public String multiply(int a, int b) {
		typeNumber(a);
		multiplyButton.click();
		typeNumber(b);
		calculateButton.click();
		return getScreenContent();
	}

	public String subtract(int a, int b) {
		typeNumber(a);
		subtractButton.click();
		typeNumber(b);
		calculateButton.click();
		return getScreenContent();
	}

	private void typeNumber(int number) {
		String numberAsString = String.valueOf(number);
		for (int i = 0; i < numberAsString.length(); i++) {
			WebElement numberToSelect = driver.findElement(By.xpath(buttonsMap.get(numberAsString.charAt(i))));
			numberToSelect.click();
		}
	}

	public String getScreenContent() {
		return resultScreenTextBox.getAttribute("value");
	}

	public void clear() {
		clearResultsButton.click();
	}
}
