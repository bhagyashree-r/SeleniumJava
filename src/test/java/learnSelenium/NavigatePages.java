package learnSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class NavigatePages {
		// This script is for navigating between different web pages,getting current
		// URL,using links,
		// getting title,open specific pages and using back/forward arrow to get
		// different pages etc.
		WebDriver driver;
		String baseURL;

		@BeforeTest
		public void setUp() throws Exception {
			System.setProperty("webdriver.chrome.driver","C:\\Bhagya\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			baseURL = "https://letskodeit.teachable.com/p/practice";
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		}
		@Test
		public void test() throws InterruptedException {
			driver.get(baseURL);

			// Getting title of page by saving it in the form of string and getting it using
			// get method.
			String title = driver.getTitle();
			System.out.println("The title of page is: " + title);

			// Getting current URL using getCurrentURL method by saving URL as string
			// variable.
			String currentURL = driver.getCurrentUrl();
			System.out.println("The current url is : " + currentURL);

			// Getting login page using link/url of that page & navigate method (not
			// clicking login button).
			String loginURL = "https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1";
			driver.navigate().to(loginURL);

			// Confirm URL.
			currentURL = driver.getCurrentUrl();
			System.out.println("The current url is : " + currentURL);

			Thread.sleep(2000);
			// Back to main page using backward arrow.
			driver.navigate().back();
			System.out.println("Navigating back");
			currentURL = driver.getCurrentUrl();
			System.out.println("The current url is : " + currentURL);

			Thread.sleep(2000);

			// Back to login page using forward arrow.
			driver.navigate().forward();
			System.out.println("Navigating forward");
			currentURL = driver.getCurrentUrl();
			System.out.println("The current url is : " + currentURL);

			Thread.sleep(2000);
			// Back to main page using backward arrow.
			driver.navigate().back();
			System.out.println("Navigating back");
			currentURL = driver.getCurrentUrl();
			System.out.println("The current url is : " + currentURL);

			Thread.sleep(2000);
			// Refreshing the main page TWO TIMES
			driver.navigate().refresh();
			System.out.println("Refreshing page");
			currentURL = driver.getCurrentUrl();

			Thread.sleep(2000);
			driver.navigate().refresh();
			System.out.println("Refreshing page");
		}

		@AfterTest
		public void tearDown() throws Exception {
			driver.quit();
	}
}
