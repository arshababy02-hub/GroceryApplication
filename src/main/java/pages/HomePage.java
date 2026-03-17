package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {
	public WebDriver driver;
	@FindBy(xpath = "//li[contains(@class,'nav-item dropdown')]/a[contains(@class,'nav-link')]")
	WebElement admin_icon;
	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
	WebElement logoutbutton;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signin;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alert;
	
	
	@FindBy(xpath = "//div[@class='small-box bg-info']//child::a[contains(@href,'admin/list-admin')]")
	WebElement adminmoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']//i[@class='fas fa-arrow-circle-right']")
	WebElement categoryinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact'][normalize-space()='More info']")
	WebElement contactinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'][normalize-space()='More info']")
	WebElement moreFooterInfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'][normalize-space()='More info']")
	WebElement managenewsmoreinfo;
	// Constructor to initialize all web elements on the Logout page
	// PageFactory binds the WebElements with their respective locators
	/*public HomePage(WebDriver driver) {
		
		PageFactory.initElements( driver, this);
	}*/
	public HomePage(WebDriver driver) {
	    this.driver = driver;  
	    PageFactory.initElements(driver, this);
	}
	// Method to perform logout action
	
	public void clickOnLogout() {
		admin_icon.click();//create separate method
		
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
	
	// Click on Admin Users "More Info" link
		public AdminUsersPage clickonadminusers() {
			adminmoreinfo.click();
			return new AdminUsersPage(driver) ;
			
		}
		public ManageCategoryPage clickoncategorymoreinfo() {
			//categoryinfo.click();
			PageUtility click = new PageUtility();
			click.click(driver, categoryinfo);
			return new ManageCategoryPage(driver);
			
			
		}
		public ManageContactPage clickonmanagecontact() {
			contactinfo.click();
			return new ManageContactPage(driver);
		}
		public ManageFooterPage clickonmoreinfofooter() {
			moreFooterInfo.click();
			return new ManageFooterPage(driver);
		}
		public ManageNewsPage clickonmoreinfo() {
			managenewsmoreinfo.click();
			return new ManageNewsPage(driver);
		}

}
