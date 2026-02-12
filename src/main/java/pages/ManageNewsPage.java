package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	public WebDriver driver;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'][normalize-space()='More info']")
	WebElement morenews;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement New;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement message;
	@FindBy(xpath = "//button[@name='create']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement newsalert;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement profile;
	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
	WebElement logoutbtn;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickonmoreinfo() {
		morenews.click();
	}

	public void clickonnews() {
		New.click();
	}

	public void entermessage(String msg) {
		message.sendKeys(msg);
	}

	public void save() {
		save.click();
	}

	public boolean isAlertmessageDisplayed() {
		return newsalert.isDisplayed();
	}

	public void clickonlogout() {

		profile.click();

		logoutbtn.click();
	}

}