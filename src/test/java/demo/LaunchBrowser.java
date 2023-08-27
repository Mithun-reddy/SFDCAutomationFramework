package demo;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaunchBrowser {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://selenium-prd.firebaseapp.com/");
		
		WebElement userName = driver.findElement(By.id("email_field"));
		userName.sendKeys("admin123@gmail.com");
		
		WebElement password = driver.findElement(By.id("password_field"));
		password.sendKeys("admin123");
		
		driver.findElement(By.xpath("//*[@id='login_div']/button")).click();
		
//		Thread.sleep(4000);
		//Initialization
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"user_div\"]/div[1]/a[1]"))));
		
		// fluent wait
//		Initialization
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		WebElement home = wait1.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return driver.findElement(By.xpath("//*[@id=\"user_div\"]/div[1]/a[1]"));
			}
		});
		
		//click on home
		driver.findElement(By.xpath("//*[@id=\"user_div\"]/div[1]/a[1]")).click();
		
		driver.findElement(By.id("name")).sendKeys("Tej");
		
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@value='female']"))));
		
		driver.findElement(By.xpath("//input[@value='female']")).click();
		
		
		WebElement cityDropdown = driver.findElement(By.id("city"));
		
		Select s = new Select(cityDropdown);
		s.selectByValue("goa");
		WebElement switchto = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
		Actions action = new Actions(driver);
		
		action.moveToElement(switchto).build().perform();
		
		driver.findElement(By.xpath("//a[text()='Windows']")).click();
		
		String parentWindow = driver.getWindowHandle();
		
		driver.findElement(By.xpath("(//button[@class='bootbutton'])[1]")).click();
		
		
//		driver.findElement(By.xpath("//button[text()='Window Alert']")).click();
//		Thread.sleep(3000);
//		
//		driver.switchTo().alert().accept();
//		
//		driver.switchTo().frame("abcd");
//		driver.findElement(By.xpath("")).click();
//		
//		driver.switchTo().parentFrame();
		
//		Thread.sleep(3000);
		
		driver.quit();
		
		
		
	}

}
