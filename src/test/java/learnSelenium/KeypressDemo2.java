package learnSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KeypressDemo2 {
	private WebDriver driver;
	private String baseURL;

	@BeforeTest
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Bhagya\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		baseURL="https://letskodeit.teachable.com/p/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@Test
	void test() {
		/*Here we are using three different ways to get 
		 * same functionality (using combination of keys on keyboard). 
		 */
		//first way:
		//driver.findElement(By.id("openwindow")).sendKeys(Keys.CONTROL + "a");
		//second way:
		//driver.findElement(By.id("openwindow")).sendKeys(Keys.chord(Keys.CONTROL,"a"));
		//third way: using string 
		String selectAll=Keys.chord(Keys.CONTROL,"a");
		driver.findElement(By.id("openwindow")).sendKeys(selectAll);

	}

	@AfterTest
	void tearDown() throws Exception {
		driver.close();
	}
}
