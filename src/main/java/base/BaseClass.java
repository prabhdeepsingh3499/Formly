package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.PropertyReader;
public class BaseClass {
	protected static WebDriver driver;
	 static PropertyReader prReader = new PropertyReader();
	private static String appURL = prReader.getApplicationProperty("baseURL");
	 public static void setDriver(String browserType)
		{
			switch (browserType.toLowerCase())
			{
			case "chrome":
				driver = initChromeDriver();
				break;
			case "firefox":
				driver = initFirefoxDriver();
				break;
			default:
				System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
				driver = initFirefoxDriver();
			}
		}
	 private static WebDriver initChromeDriver()
		{
			System.out.println("Launching google chrome with new profile..");
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			if(prReader.getApplicationProperty("maximizeBrowser").equalsIgnoreCase("true")) {
				driver.manage().window().maximize();
			}
			driver.get(appURL);
			return driver;
		}

		private static WebDriver initFirefoxDriver()
		{
			System.out.println("Launching Firefox browser..");
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
			if(prReader.getApplicationProperty("maximizeBrowser").equalsIgnoreCase("true")) {
				driver.manage().window().maximize();
			}
			driver.get(appURL);
			return driver;
		}
		public static void closeBrowser()
		{
			driver.quit();
		}

		public static WebDriver getDriver()
		{
			// TODO Auto-generated method stub
			return driver;
		}


}
