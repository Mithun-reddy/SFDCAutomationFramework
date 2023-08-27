package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserMenuPage {
	
	public UserMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "userNavLabel")
	public WebElement usermenu;
	
	@FindBy(xpath = "//*[@title='My Settings']")
	public WebElement mySettings;
	
	@FindBy(xpath = "//*[@title='My Profile']")
	public WebElement myProfile;
	
	@FindBy(id="CalendarAndReminders_font")
	public WebElement calenderAndReminders;
	
	@FindBy(id="Reminders_font")
	public WebElement activityReminder;
	
	@FindBy(id="testbtn")
	public WebElement openTestReminder;
	
	
}
