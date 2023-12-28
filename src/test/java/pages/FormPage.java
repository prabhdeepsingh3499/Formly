package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utility.RandomData;
public class FormPage {
	private WebDriver driver;
	public FormPage(WebDriver driver) {
		this.driver = driver;
	}
	RandomData random = new RandomData();
	private By firstName = By.id("first-name");
	private By lastName = By.id("last-name");
	private By jobTitle = By.id("job-title");
	private By radios = By.xpath("//input[@type='radio']");
	private By checkBox = By.xpath("//input[@type='checkbox']");
	private By selectOptions = By.xpath("//option");
	private By selectJob(int i) {
		return By.xpath("(//input[@type='radio'])["+i+"]");
	}
	private By selectGender(int i) {
		return By.xpath("(//input[@type='checkbox'])["+i+"]");
	}
	private By enterDate = By.id("datepicker");
	private By submit = By.linkText("Submit");
	public void enterInformation() {
		driver.findElement(firstName).sendKeys(random.getFirstName());
		driver.findElement(lastName).sendKeys(random.getLastName());
		driver.findElement(jobTitle).sendKeys(random.getJobTitle());
		int randomJob = random.getRandomNumber(driver.findElements(radios).size());
		int randomGender = random.getRandomNumber(driver.findElements(checkBox).size());
		driver.findElement(selectJob(randomJob)).click();
		driver.findElement(selectGender(randomGender)).click();
		Select selectMenu = new Select(driver.findElement(By.id("select-menu")));
		int randomExperience= random.getRandomNumber(driver.findElements(selectOptions).size());
		selectMenu.selectByIndex(randomExperience);
		driver.findElement(enterDate).sendKeys(random.createRandomDate());
		driver.findElement(submit).click();
	}
	
}
