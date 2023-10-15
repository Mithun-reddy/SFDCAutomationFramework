package tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.UserMenuPage;
import utils.CommonUtils;
import utils.FileUtils;

public class LoginTest extends BaseTest{
	
	@Test
	public void login_TC_01() throws IOException, InterruptedException {
		WebDriver driver = getDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		LoginPage lp = new LoginPage(driver);
		driver.get(FileUtils.readLoginPropertiesFile("dev.url"));
		driver.manage().window().maximize();
		CommonUtils.waitForElement(driver, lp.loginButton);
		lp.username.sendKeys(FileUtils.readLoginPropertiesFile("dev.username"));
		lp.password.sendKeys(FileUtils.readLoginPropertiesFile("dev.password"));
		lp.loginButton.click();
		System.out.println("Login clicked");
		
	}
	
	
	@Test
	public void login_TC_02() throws IOException {
		WebDriver driver = getDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		LoginPage lp = new LoginPage(driver);
		driver.get(FileUtils.readLoginPropertiesFile("dev.url"));
		driver.manage().window().maximize();
		CommonUtils.waitForElement(driver, lp.loginButton);
		lp.username.sendKeys(FileUtils.readLoginPropertiesFile("dev.username"));
		lp.password.sendKeys(FileUtils.readLoginPropertiesFile("dev.wrong.password"));
		lp.loginButton.click();
		CommonUtils.waitForElement(driver, lp.errorText);
		Assert.assertEquals(lp.errorText.getText(), FileUtils.readLoginPropertiesFile("login.error.text"));
	}
	
	@Test
	public void login_TC_03() throws IOException {
		WebDriver driver = getDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		LoginPage lp = new LoginPage(driver);
		driver.get(FileUtils.readLoginPropertiesFile("dev.url"));
		driver.manage().window().maximize();
		CommonUtils.waitForElement(driver, lp.loginButton);
		lp.username.sendKeys(FileUtils.readLoginPropertiesFile("dev.wrong.username"));
		lp.password.sendKeys(FileUtils.readLoginPropertiesFile("dev.wrong.password"));
		lp.loginButton.click();
		CommonUtils.waitForElement(driver, lp.errorText);
		Assert.assertEquals(lp.errorText.getText(), FileUtils.readLoginPropertiesFile("login.error.text"));
	}
}
