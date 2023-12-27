package testrunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.ConfirmationPage;
import pages.FormPage;
import utility.PropertyReader;
public class TestRunner extends BaseClass {
	static PropertyReader prreader = new PropertyReader();
	private String browserType = prreader.getApplicationProperty("browser");
	@BeforeMethod
	public void setup(){
		BaseClass.setDriver(browserType);
	}

	@AfterMethod
	public void tearDown(){
		BaseClass.closeBrowser();
	}
	@Test
	public void Test(){
		FormPage formPage = new FormPage(driver);
		formPage.enterInformation();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		confirmationPage.isSuccessMessageDisplayed();
		
		
	}
}
