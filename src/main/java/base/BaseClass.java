package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.PropertyReader;
public class BaseClass {
	protected WebDriver driver=null;
	 static PropertyReader prReader = new PropertyReader();
	private static String appURL = prReader.getApplicationProperty("baseURL");
	 public WebDriver setDriver(String browserType)
		{
			switch (browserType.toLowerCase())
			{
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			if(prReader.getApplicationProperty("maximizeBrowser").equalsIgnoreCase("true")) {
				driver.manage().window().maximize();
			}
			driver.get(appURL);
			return driver;
		}
		public void closeBrowser()
		{
			driver.quit();
		}


}
