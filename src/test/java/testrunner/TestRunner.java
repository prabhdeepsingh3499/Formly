package testrunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.ConfirmationPage;
import pages.FormPage;
import utility.PropertyReader;
public class TestRunner extends BaseClass {
    PropertyReader prreader = new PropertyReader();
	private String browserType = prreader.getApplicationProperty("browser");
	private WebDriver driver;
	@BeforeMethod
	public void setup(){
		driver = setDriver(browserType);
	}

	@AfterMethod
	public void tearDown(){
		closeBrowser();
	}
	@Test
	public void Test(){
		FormPage formPage = new FormPage(driver);
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		formPage.enterInformation();
		confirmationPage.isSuccessMessageDisplayed();
		
		
	}
}
