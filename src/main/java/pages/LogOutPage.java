package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
	public WebDriver driver;
	@FindBy(xpath = "//li[contains(@class,'nav-item dropdown')]/a[contains(@class,'nav-link')]")
	WebElement admin_icon;
	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
	WebElement logoutbutton;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signin;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alert;
	// Constructor to initialize all web elements on the Logout page
	// PageFactory binds the WebElements with their respective locators
	public LogOutPage(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}
	// Method to perform logout action
	public void clickOnLogout() {
		admin_icon.click();
		logoutbutton.click();
	}
	// Used after logout to confirm that user is successfully logged out
	// Returns true if Sign In button is visible
	public boolean isloginPageDisplayed() {
		return signin.isDisplayed();

	}
	/*public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}*/

}
