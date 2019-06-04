package learnSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class LearnCalender1 {

	WebDriver driver;
	String baseURL;

	@BeforeTest
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Bhagya\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		baseURL="https://www.expedia.com/";
		
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test
	void test() throws InterruptedException {
		driver.get(baseURL);
		
		// Finding flight tab & click on it.
		driver.findElement(By.id("tab-flight-tab-hp")).click();
		Thread.sleep(3000);
		
		// Finding departure element and click on it.
		WebElement departureField= driver.findElement(By.xpath("//input[@id='flight-departing-hp-flight']"));
		departureField.click();
		
		// Finding date (of choice) element & Clicking it.
		WebElement dateElement=driver.findElement(By.cssSelector(".datepicker-cal .datepicker-cal-month:nth-child(4) tr:nth-of-type(2) .notranslate:nth-of-type(5) [type]"));
		dateElement.click();
		
		
	}

	@AfterTest
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
