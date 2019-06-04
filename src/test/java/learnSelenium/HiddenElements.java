package learnSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HiddenElements {

	WebDriver driver;
	String baseURL1;
	String baseURL2;

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Bhagya\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		baseURL1 = "https://letskodeit.teachable.com/p/practice";
		baseURL2 = "https://www.expedia.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void testLetsKodeIt() throws InterruptedException {
		driver.get(baseURL1);
		WebElement textBox = driver.findElement(By.id("displayed-text"));
		System.out.println("Text Box Displayed: " + textBox.isDisplayed());

		Thread.sleep(3000);

		WebElement hideBtn = driver.findElement(By.id("hide-textbox"));
		hideBtn.click();
		System.out.println("Clicked on Hide button");
		System.out.println("Text Box Displayed: " + textBox.isDisplayed());

		Thread.sleep(3000);

		WebElement showBtn = driver.findElement(By.id("show-textbox"));
		showBtn.click();
		System.out.println("Clicked on Show button");
		System.out.println("Text Box Displayed: " + textBox.isDisplayed());

	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
}
}
