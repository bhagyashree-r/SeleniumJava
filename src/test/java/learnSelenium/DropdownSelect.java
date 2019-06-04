package learnSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropdownSelect {

	WebDriver driver;
	String baseURL;

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Bhagya\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
	}

	@Test
	public void testDropDown() throws InterruptedException {
		WebElement element1=driver.findElement(By.id("carselect"));//Finding elements of drop down and storing in valiable element1
		Select  sel1=new Select(element1);//using Select object
		
		Thread.sleep(2000);
		System.out.println("Select BENZ by value =>");
		sel1.selectByValue("benz");
		
		Thread.sleep(2000);
		System.out.println("Select BMW by index =>");
		sel1.selectByIndex(0);
		
		Thread.sleep(2000);
		System.out.println("Select HONDA by visible text =>");
		sel1.selectByVisibleText("Honda");
		
		Thread.sleep(2000);
		System.out.println("Print the list of all options");
		List<WebElement> options= sel1.getOptions();
		int size=options.size();
		
		for (int i=0; i<size; i++) {
		String optionName=options.get(i).getText();
		System.out.println(optionName);
		
		}	
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
}
}
