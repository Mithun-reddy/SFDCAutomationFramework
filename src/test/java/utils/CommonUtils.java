package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {

	public static boolean waitForElement(WebDriver driver, WebElement element) {
		boolean isElementFound = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			isElementFound = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isElementFound;
	}
	
	public static boolean waitForInvisibilityOfElement(WebDriver driver, WebElement element) {
		boolean isElementFound = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
			isElementFound = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isElementFound;
	}

}
