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
	// Constructor to initialize all web elements using PageFactory
	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	// Method to enter username into username field
	public void enterusername(String username) {
		uname.sendKeys(username);
	}
	// Method to enter password into password field
	public void enterpassword(String password) {
		pwd.sendKeys(password);
	}
	 // Method to click on Sign In button
	public void clicksignin() {
		signin.click();
	}

    // Validation method to verify if Dashboard (Home page) is displayed
    // Used to confirm successful login
	public boolean isHomePageDisplayed() {
		return dashboard.isDisplayed();

	}
	// Validation method to verify if error alert is displayed
    // Used to confirm invalid login scenario
	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}