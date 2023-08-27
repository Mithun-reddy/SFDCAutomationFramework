package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	
	@BeforeMethod
	public void setDriver() {
//		WebDriver driver = ;
		
		threadLocalDriver.set(getBrowserType("chrome"));
	}
	
	@AfterMethod
	public void closeDriver() {
		getDriver().close();
	}
	
	
	public WebDriver getDriver() {
		return threadLocalDriver.get();
	}
	
	public void removeDriver() {
		threadLocalDriver.remove();
	}
	
	
	
	public WebDriver getBrowserType(String browserName) {
		
		WebDriver driver = null;
		
		String browser = browserName.toLowerCase();
		
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "/Users/mithun/Downloads/chromedriver-mac-arm64/chromedriver");
			driver = new ChromeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;
			
		case "safari":
			driver = new SafariDriver();
			break;
			
		case "edge":
			driver = new EdgeDriver();
			break;
			
		default:
			driver = null;;
		}
		return driver;
	}
	
	

}
