package tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.UserMenuPage;
import utils.CommonUtils;
import utils.FileUtils;

public class LoginTest extends BaseTest{
	
	@Test
	public void login_TC_01() throws IOException, InterruptedException {
//		SoftAssert sAssert = new SoftAssert();
		WebDriver driver = getDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		
		
		driver.get(FileUtils.readLoginPropertiesFile("dev.url"));
		driver.manage().window().maximize();
//		Thread.sleep(7000);
		
		CommonUtils.waitForElement(driver, lp.loginButton);
		lp.username.sendKeys(FileUtils.readLoginPropertiesFile("dev.username"));
		
		lp.password.sendKeys(FileUtils.readLoginPropertiesFile("dev.password"));
//		String passwordFieldText =lp.password.getText();
		
//		Assert.assertEquals(passwordFieldText, "");
		lp.loginButton.click();
		System.out.println("Login clicked");
		
//		String actualText = lp.errorText.getText();
		
//		Assert.assertEquals(actualText, FileUtils.readLoginPropertiesFile("login.error.text"));
		CommonUtils.waitForElement(driver, ump.usermenu);
		
		ump.usermenu.click();
		CommonUtils.waitForElement(driver, ump.mySettings);
		ump.mySettings.click();
		CommonUtils.waitForElement(driver, ump.calenderAndReminders);
		ump.calenderAndReminders.click();
		CommonUtils.waitForElement(driver, ump.activityReminder);
		ump.activityReminder.click();
		CommonUtils.waitForElement(driver, ump.openTestReminder);
		ump.openTestReminder.click();
		
		Thread.sleep(7000);
		String currentWindow = driver.getWindowHandle();
		
		Set<String> windowIDs = driver.getWindowHandles();
		
		windowIDs.remove(currentWindow);
		String newWindow = "";
		
		for (String id : windowIDs) {
			newWindow = id;
		}
		
		driver.switchTo().window(newWindow);
		
		driver.close();
		
		driver.switchTo().window(currentWindow);
		
		Thread.sleep(5000);
		
		driver.switchTo().frame("contactInfoContentId");
		driver.switchTo().parentFrame();
//		
		
		
		
		
		
	}
}
