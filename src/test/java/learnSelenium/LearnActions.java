package learnSelenium;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LearnActions {
	WebDriver driver;
	String baseURL;
	
	@BeforeTest
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver","C:\\Bhagya\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		baseURL="https://letskodeit.teachable.com/p/practice";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
			
	}
	
	@Test
	public void test() {
		driver.get(baseURL);
		driver.findElement(By.xpath("//a[@class='navbar-link fedora-navbar-link']")).click();
		System.out.println("Clicking login button");
		
		driver.findElement(By.id("user_email")).sendKeys("test@email.com");
		System.out.println("Clicking on user email & sending keys as email address");
		
		driver.findElement(By.id("user_password")).sendKeys("tester");
		System.out.println("Clicking password & sending keys or typing password");
		
		driver.findElement(By.id("user_email")).clear();
		System.out.println("Clicking user email & clearing"); 
		
	    // Here, user name/password are not valid so nothing will happen!!
	
	}
	@AfterTest
	void tearDown() throws Exception {
		driver.quit();
}
}
