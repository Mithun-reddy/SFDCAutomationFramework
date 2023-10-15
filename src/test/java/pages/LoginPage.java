package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.FileUtils;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username")
	public WebElement username;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(id = "Login")
	public WebElement loginButton;

	@FindBy(id = "error")
	public WebElement errorText;
	
	
	public void loginToApp(WebDriver driver) throws IOException {
		CommonUtils.waitForElement(driver, loginButton);
		username.sendKeys(FileUtils.readLoginPropertiesFile("dev.username"));
		password.sendKeys(FileUtils.readLoginPropertiesFile("dev.password"));
		loginButton.click();
	}
	
	
}
