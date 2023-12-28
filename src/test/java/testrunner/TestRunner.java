package testrunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.ComponentPage;
import pages.ConfirmationPage;
import pages.FormPage;
import utility.PropertyReader;
public class TestRunner extends BaseClass {
    PropertyReader prreader = new PropertyReader();
	private String browserType = prreader.getApplicationProperty("browser");
	private String component = prreader.getApplicationProperty("component");
	private WebDriver driver;
	@BeforeMethod
	public void setup(){
		driver = setDriver(browserType);
	}

	@AfterMethod
	public void tearDown(){
		closeBrowser();
	}
	@Test(description="Test with Form",groups="Form")
	public void Test_Form(){
		ComponentPage componentPage = new ComponentPage(driver);
		FormPage formPage = new FormPage(driver);
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		componentPage.selectComponent(component);
		formPage.enterInformation();
		confirmationPage.isSuccessMessageDisplayed();
	}
}
