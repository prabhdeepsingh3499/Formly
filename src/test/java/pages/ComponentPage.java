package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
public class ComponentPage {
	private WebDriver driver;
	public ComponentPage(WebDriver driver) {
		this.driver = driver;
	}
	private By clickComponent(String component) {
		return By.partialLinkText(component);
	}
	public void selectComponent(String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(clickComponent(value)));
		driver.findElement(clickComponent(value)).click();
	}

}
