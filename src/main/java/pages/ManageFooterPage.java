package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterPage {

	public WebDriver driver;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'][normalize-space()='More info']")
	WebElement moreFooterInfo;
	@FindBy(xpath = "//a[contains(@href,'admin/Footertext/edit?edit=1')]//child::i[@class='fas fa-edit']")
	WebElement editicon;
	@FindBy(xpath = "//textarea[@placeholder='Enter the Address']")
	WebElement address;
	@FindBy(xpath = "//input[@name='email']")
	WebElement email;
	@FindBy(xpath = "//input[@name='phone']")
	WebElement phonenum;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updatebttn;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//child::h5")
	WebElement alertmsge;

	public ManageFooterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickonmoreinfofooter() {
		moreFooterInfo.click();
	}

	public void clickonediticon() {
		editicon.click();
	}

	public void editdatafields(String address1, String emailid, String phonenumber) {
		address.clear();
		address.sendKeys(address1);
		email.clear();
		email.sendKeys(emailid);
		phonenum.clear();
		phonenum.sendKeys(phonenumber);

	}

	public void clickonupdatebtn() {
		updatebttn.click();
	}

	public boolean isFooterUpdatedSuccessfully() {
		return alertmsge.isDisplayed();
	}
}
