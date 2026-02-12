package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUsersPage {

	public WebDriver driver;// WebDriver reference

	@FindBy(xpath = "//div[@class='small-box bg-info']//child::a[contains(@href,'admin/list-admin')]")
	WebElement adminmoreinfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement admin_new;
	@FindBy(xpath = "//input[@id='username']")
	WebElement admin_uname;
	@FindBy(xpath = "//input[@name='password']")
	WebElement admin_passwd;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement admin_save;
	@FindBy(xpath = "//select[@name='user_type']")
	WebElement dropdwn_type;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//child::h5")
	WebElement alertmsg;
	// Constructor to initialize page elements
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// Click on Admin Users "More Info" link
	public void clickonadminusers() {
		adminmoreinfo.click();
	}
	// Click on New button to add admin user
	public void clickonNew() {
		admin_new.click();
	}
	 // Enter username and password for new admin user
	public void enterdata() {
		admin_uname.sendKeys("users");
		admin_passwd.sendKeys("users");

	}
	// Select user type from dropdown
	public void performdropdown() {
		PageUtility pageutility = new PageUtility();
		pageutility.dropdownselectByVisisbleText(dropdwn_type, "Admin");

	}
	 // Click on Save / Create button
	public void savedata() {

		admin_save.click();
	}
	// Validation: Check if success alert is displayed
	public boolean isAlertDisplayed() {
		return alertmsg.isDisplayed();

	}
}
