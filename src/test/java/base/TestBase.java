package base;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import pages.HomePageObjects;
import pages.RegistrationPageObjects;
import utilities.ReadConfiguration;


public class TestBase {
	public static ReadConfiguration readConfig;
	public static WebDriver driver;
	public HomePageObjects hp;
	public RegistrationPageObjects rp;
	
	public static void selectBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
	}

	@BeforeTest
	public void setUpBrowser() throws FileNotFoundException {
		
		readConfig = new ReadConfiguration();
		System.out.println("==> SetUpBrowser");
		selectBrowser(readConfig.getBrowserOption());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		System.out.println("Navigated to the application : " + readConfig.getQAUrl());
		driver.get(readConfig.getQAUrl());
		
		hp = new HomePageObjects(driver);
	    rp = new RegistrationPageObjects(driver);
		
	}

	@AfterTest
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("==> close Browser");
		driver.close();
	}

}
