package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ConfirmationPage {
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}
	private By successMessage = By.className("alert-success");
	public boolean isSuccessMessageDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
		if(success.isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}
}

