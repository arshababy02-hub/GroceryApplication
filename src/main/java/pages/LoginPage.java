package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	@FindBy(name = "username")
	WebElement uname;// Page factory is providing FindBy annotation to locate Webelemnts
	@FindBy(name = "password")
	WebElement pwd;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signin;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboard;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alert;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void enterusername(String username) {
		uname.sendKeys(username);
	}

	public void enterpassword(String password) {
		pwd.sendKeys(password);
	}

	public void clicksignin() {
		signin.click();
	}

	public boolean isHomePageDisplayed() {
		return dashboard.isDisplayed();

	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}