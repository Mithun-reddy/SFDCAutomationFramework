package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.FileUtils;

public class UserMenuPage {

	public UserMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userNavLabel")
	public WebElement userMenu;

	@FindBy(xpath = "//*[@title='My Settings']")
	public WebElement mySettings;

	@FindBy(xpath = "//*[@title='My Profile']")
	public WebElement myProfile;

	@FindBy(id = "CalendarAndReminders_font")
	public WebElement calenderAndReminders;

	@FindBy(id = "Reminders_font")
	public WebElement activityReminder;

	@FindBy(id = "testbtn")
	public WebElement openTestReminder;

	@FindBy(xpath = "//div[@id='userNav-menuItems']/a")
	public List<WebElement> userMenuOptions;

	@FindBy(xpath = "//a[@data-id='sfdc.ProfilePlatformFeed']")
	public WebElement feed;

	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
	public WebElement editProfileIcon;

	@FindBy(id = "contactInfoContentId")
	public WebElement iFrameProfileWindow;

	@FindBy(id = "aboutTab")
	public WebElement aboutTab;

	@FindBy(id = "lastName")
	public WebElement aboutTabLastName;

	@FindBy(xpath = "//*[@value='Save All']")
	public WebElement saveAllProfileWindow;

	@FindBy(id = "tailBreadcrumbNode")
	public WebElement updatedName;

	// Postlink
	@FindBy(css = "#publishereditablearea")
	public WebElement postLink;

	@FindBy(xpath = "/html/body")
	public WebElement postTextArea;

	@FindBy(xpath = "//input[@id='publishersharebutton']")
	public WebElement shareButton;

	// filelink

	@FindBy(xpath = "//*[@id='publisherAttachContentPost']")
	public WebElement filelink;

	@FindBy(xpath = "//a[@id='publisherAttachContentPost']/span[1]")
	public WebElement contentpost;

	@FindBy(css = "#chatterUploadFileAction")
	public WebElement Uploadfile;

	@FindBy(css = "#chatterFile")
	public WebElement Fileopen;

	@FindBy(css = "#publishersharebutton")
	public WebElement publish;

	@FindBy(xpath = "//input[@value='Cancel Upload']")
	public WebElement cancelUpload;

	@FindBy(id = "uploadLink")
	public WebElement updateButton;
	// Photo link

	@FindBy(xpath = "//*[@id='publisherAttachLinkPost']/span[1]")
	public WebElement photolink;

	@FindBy(id = "j_id0:uploadFileForm:uploadInputFile")
	public WebElement uploadphoto;

	@FindBy(name = "j_id0:uploadFileForm:uploadBtn")
	public WebElement uploadbutton;

	@FindBy(id = "publishersharebutton")
	public WebElement photosharebutton;

	@FindBy(id = "uploadPhotoContentId")
	public WebElement photoUploadIframe;

	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadBtn']")
	public WebElement photoSaveButton;

	@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
	public WebElement photoSaveButton2;
	// My Settings
	// personallink

	@FindBy(xpath = "//*[@id=\'PersonalInfo_font\']")
	public WebElement personallink;

	@FindBy(xpath = "//*[@id=\"LoginHistory_font\"]")
	public WebElement loginHistorylink;

	@FindBy(xpath = "//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")
	public WebElement logindisplay;

	@FindBy(id = "contactInfoContentId")
	public WebElement iframeAboutTab;
	// Display&layoutlink

	@FindBy(xpath = "//*[@id=\"DisplayAndLayout_font\"]")
	public WebElement DisplayLayoutlink;

	@FindBy(id = "CustomizeTabs_font")
	public WebElement CustomizedTab;

	@FindBy(xpath = "//*[@id=\"p4\"]/option[9]")
	public WebElement customApp;

	@FindBy(xpath = "//*[@id=\"duel_select_0\"]/option[73]")
	public WebElement Availabletab;

	@FindBy(xpath = "//*[@id=\"duel_select_0_right\"]/img")
	public WebElement Add;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement save;

	@FindBy(id = "tabBar")
	public WebElement tabList;

	// Emaillink

	@FindBy(xpath = "//*[@id=\"EmailSetup_font\"]")
	public WebElement Emaillink;

	@FindBy(id = "EmailSettings_font")
	public WebElement MyEmailSettings;

	@FindBy(id = "sender_name")
	public WebElement Emailname;

	@FindBy(xpath = "//*[@id=\"sender_email\"]")
	public WebElement Emailaddress;

	@FindBy(xpath = "//*[@id=\"useremailSection\"]/table/tbody/tr[7]/td[2]/div")
	public WebElement BCCradiobutton;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement Saveonemail;

	// Calendar and Remainders
	@FindBy(id = "CalendarAndReminders_font")
	public WebElement CalendarAndReminders;

	@FindBy(xpath = "//*[@id=\"Reminders_font\"]")
	public WebElement ActivityRemainder;

	@FindBy(id = "testbtn")
	public WebElement OpenaTestRemainder;

	@FindBy(xpath = "//*[@id=\"summary\"]")
	public WebElement SampleEventPopup;

	@FindBy(css = "#displayBadge")
	public WebElement moderatorButton;

	@FindBy(id = "profileTab_sfdc.ProfilePlatformFeed")
	public WebElement profilePage;

	@FindBy(id = "contactTab")
	public WebElement contactTab;

	@FindBy(xpath = "//div[@class='cxfeeditem feeditem'][1]//p")
	public WebElement firstPostText;

	@FindBy(xpath = "(//*[@class='contentFileTitle'])[1]")
	public WebElement verifyFilePostElement;

	public void selectUserMenu() {
		if (userMenu.isDisplayed()) {
			userMenu.click();
		} else {
			System.out.println("User menu button is not visible");
		}
	}

	public boolean verifyUserMenuOptions() throws IOException {

		boolean isAllOptionsVerified = true;
		String[] expectedUserMenuItem = FileUtils.readLoginPropertiesFile("usermenu.items").split(",");
		for (int i = 0; i < userMenuOptions.size(); i++) {

			String actualUserMenuItem = userMenuOptions.get(i).getText();
			if (actualUserMenuItem.equals(expectedUserMenuItem[i])) {
				System.out.println("Validate option " + actualUserMenuItem);
			} else {
				isAllOptionsVerified = false;
				System.out.println("Failed to validate option " + actualUserMenuItem);
			}
		}
		return isAllOptionsVerified;
	}

	public boolean isProfilePageSeen(WebDriver driver) {
		CommonUtils.waitForElement(driver, feed);
		return feed.isDisplayed();
	}

	public boolean verifyLastNameChangeInAboutTab(WebDriver driver) throws IOException, InterruptedException {
		boolean isLastNameChangeVerified = false;

		String lastName = FileUtils.readLoginPropertiesFile("lastName");
		driver.switchTo().frame(iFrameProfileWindow);
		if (aboutTab.isDisplayed()) {
			aboutTab.click();
//			Thread.sleep(1000);
			CommonUtils.waitForElement(driver, aboutTabLastName);
			aboutTabLastName.clear();
			aboutTabLastName.sendKeys(lastName);
			saveAllProfileWindow.click();
			CommonUtils.waitForInvisibilityOfElement(driver, saveAllProfileWindow);
			driver.switchTo().parentFrame();
			if (updatedName.isDisplayed()) {
				String actualLastName = updatedName.getText();
				if (actualLastName.contains(lastName)) {
					isLastNameChangeVerified = true;
				}
			} else {

			}
		}
		return isLastNameChangeVerified;
	}

	public boolean verifyCreateAPost(WebDriver driver, String post) {
		boolean isPostCreated = false;
		if (postLink.isDisplayed()) {
			postLink.click();
			driver.switchTo().frame(0);
			postTextArea.sendKeys(post);
			driver.switchTo().parentFrame();
			shareButton.click();
			isPostCreated = true;
		}
		return isPostCreated;
	}

	public boolean verifyFileUpload(WebDriver driver, String sFilePath) {
		boolean isFileUploadSuccess = false;
		if (CommonUtils.waitForElement(driver, filelink)) {
			filelink.click();
			if (CommonUtils.waitForElement(driver, Uploadfile)) {
				Uploadfile.click();
				if (CommonUtils.waitForElement(driver, Fileopen)) {
					Fileopen.sendKeys(sFilePath);
					shareButton.click();
					if (CommonUtils.waitForInvisibilityOfElement(driver, cancelUpload)) {
						if (verifyFilePostElement.isDisplayed()) {
							isFileUploadSuccess = true;
						}
					}
				}
			}
		}
		return isFileUploadSuccess;
	}

	public void clickOnUpdatePhoto(WebDriver driver) {
		CommonUtils.moveToElement(driver, moderatorButton);
		if (updateButton.isDisplayed()) {
			updateButton.click();
		}
	}

	public boolean verifyUploadPhoto(WebDriver driver, String sPhotoPath) throws InterruptedException {
		boolean isPhotoUploadSuccess = false;
		clickOnUpdatePhoto(driver);
		driver.switchTo().frame(photoUploadIframe);
		if (CommonUtils.waitForElement(driver, uploadphoto)) {
			uploadphoto.sendKeys(sPhotoPath);
			photoSaveButton.click();
			if (CommonUtils.waitForElement(driver, photoSaveButton2)) {
				photoSaveButton2.click();
				Thread.sleep(4000);
				isPhotoUploadSuccess = true;
			}
		}
		driver.switchTo().parentFrame();
		return isPhotoUploadSuccess;

	}

}
