package learnSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KeypressDemo1 {
	private WebDriver driver;
	private String baseURL;

	@BeforeTest
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Bhagya\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@Test
	void test() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='navbar-link fedora-navbar-link']")).click();
		driver.findElement(By.id("user_email")).sendKeys("tester@gmail");
		driver.findElement(By.id("user_password")).sendKeys("test");
		Thread.sleep(2000);
		//Using key in keyboard(ENTER) to click enter.
		driver.findElement(By.name("commit")).sendKeys(Keys.ENTER);
	}

	@AfterTest
	void tearDown() throws Exception {
		driver.close();
	}
}
