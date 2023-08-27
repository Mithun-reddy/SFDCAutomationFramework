package testng.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	@BeforeClass //1 //4
	public void beforeHW() {
		System.out.println("Before HW .. ");
	}
	
	@AfterClass //3 
	public void afterHW() {
		System.out.println("After Hello world .. ");
	}
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/mithun/Downloads/chromedriver-mac-arm64/chromedriver");
//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
	}

}
