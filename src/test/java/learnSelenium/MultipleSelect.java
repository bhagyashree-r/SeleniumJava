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

public class MultipleSelect {
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
	public void testMultiSelect() throws InterruptedException {
		WebElement element2 = driver.findElement(By.id("multiple-select-example"));
		Select sel2 = new Select(element2);

		Thread.sleep(2000);
		System.out.println("Select Orange by value");
		sel2.selectByValue("orange");

		Thread.sleep(2000);
		System.out.println("De-Select Orange by value");
		sel2.deselectByValue("orange");

		Thread.sleep(2000);
		System.out.println("Select Peach by index");
		sel2.selectByIndex(2);

		Thread.sleep(2000);
		System.out.println("Select Apple by visible text");
		sel2.selectByVisibleText("Apple");

		Thread.sleep(2000);
		System.out.println("Print all selected option");
		// Selected options are more than one so getting them as list
		List<WebElement> selectedOptions = sel2.getAllSelectedOptions();

		for (WebElement options : selectedOptions) {
			System.out.println(options.getText());
		}

		Thread.sleep(2000);
		System.out.println("De-Select all selected options");
		sel2.deselectAll();
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
}
}
