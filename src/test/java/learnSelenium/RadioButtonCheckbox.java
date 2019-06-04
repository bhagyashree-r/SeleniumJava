package learnSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadioButtonCheckbox {
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
	public void test() throws InterruptedException {
		// Finding bmw radio button & clicking it.
		WebElement bmwRadioBtn = driver.findElement(By.id("bmwradio"));
		bmwRadioBtn.click();

		Thread.sleep(2000);
		// Finding benz radio button & clicking it.
		WebElement benzRadioBtn = driver.findElement(By.id("benzradio"));
		benzRadioBtn.click();

		Thread.sleep(2000);

		// Finding bmw checkbox & clicking it.
		WebElement bmwCheckbox = driver.findElement(By.id("bmwcheck"));
		bmwCheckbox.click();

		Thread.sleep(2000);

		// Finding bmw checkbox & clicking it.
		WebElement benzCheckbox = driver.findElement(By.id("benzcheck"));
		benzCheckbox.click();

		// Now we will use isSlelected property of web driver to verify
		// if all those elements are selected or de-selected(also printing result) in console.
		System.out.println("BMW Radio Button selected? " + bmwRadioBtn.isSelected());
		System.out.println("Benz Radio Button selected? " + benzRadioBtn.isSelected());
		System.out.println("BMW Checkbox selected? " + bmwCheckbox.isSelected());
		System.out.println("Benz Checkbox selected? " + benzCheckbox.isSelected());
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}