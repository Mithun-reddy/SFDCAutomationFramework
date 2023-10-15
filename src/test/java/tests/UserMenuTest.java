package tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.UserMenuPage;
import utils.FileUtils;

public class UserMenuTest  extends BaseTest{
	
	@Test
	public void userMenuTest_TC06() throws IOException, InterruptedException {
		
		WebDriver driver = getDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		driver.get(FileUtils.readLoginPropertiesFile("dev.url"));
		driver.manage().window().maximize();
		lp.loginToApp(driver);
		ump.selectUserMenu();
		Assert.assertTrue(ump.verifyUserMenuOptions());
		ump.myProfile.click();
		Assert.assertTrue(ump.isProfilePageSeen(driver));
		ump.editProfileIcon.click();
		Assert.assertTrue(ump.verifyLastNameChangeInAboutTab(driver));
		Assert.assertTrue(ump.verifyCreateAPost(driver, "Hello JAVA"));
		Thread.sleep(3000);
		Assert.assertTrue(ump.verifyFileUpload(driver, "/Users/mithun/Downloads/March23_MockFeedback.pages"));
		Assert.assertTrue(ump.verifyUploadPhoto(driver, "/Users/mithun/Downloads/image.png"));
		
	}
	
	

}
