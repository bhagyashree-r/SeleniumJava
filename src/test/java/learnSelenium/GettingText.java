package learnSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GettingText {

	WebDriver driver;
	String baseURL;
	
	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Bhagya\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void testGettingText() {
		driver.get(baseURL);
		WebElement btnElement = driver.findElement(By.id("opentab"));
		String elementText = btnElement.getText();
		System.out.println("The text is : " + elementText);
	}

	@AfterTest
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
