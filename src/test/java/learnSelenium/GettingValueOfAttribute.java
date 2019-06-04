package learnSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GettingValueOfAttribute {
	
	WebDriver driver;
	String baseURL;
	
	@BeforeTest
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Bhagya\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		baseURL="https://letskodeit.teachable.com/p/practice";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	void testGettingValue() {
		driver.get(baseURL);
		
		WebElement element =driver.findElement(By.id("name"));
		String attrValue=element.getAttribute("class");
		
		System.out.println("Value of attribute is  :" + attrValue);
	}

	@AfterTest
	void tearDown() throws Exception {
		Thread.sleep(2000);
}
}
