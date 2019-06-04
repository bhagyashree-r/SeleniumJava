package learnSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DragNDrop {
	
	private WebDriver driver;
	private String baseURL;

	@BeforeTest
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Bhagya\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		baseURL = "https://jqueryui.com/droppable/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get(baseURL);
	}

	@Test
	void testDragAndDrop() throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		WebElement fromElement = driver.findElement(By.id("draggable"));
		WebElement ToElement = driver.findElement(By.id("droppable"));

		Actions action = new Actions(driver);
		// There are two methods for drag & drop action.
		// 1. Drag&Drop
		// action.dragAndDrop(fromElement, ToElement).build().perform();

		// 2 click & hold/ move to the element/release/build & perform.
		action.clickAndHold(fromElement).release(ToElement).build().perform();

	}

	@AfterTest
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}


}
