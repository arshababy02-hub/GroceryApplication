package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContactPage {

	public WebDriver driver;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact'][normalize-space()='More info']")
	WebElement contactinfo;
	@FindBy(xpath = "//i[@class='fas fa-edit']")
	WebElement editicon;
	@FindBy(xpath = "//input[@name='phone']")
	WebElement phone;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//child::h5")
	WebElement alertmsge;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickonmanagecontact() {
		contactinfo.click();
	}

	public void clickonedit() {
		editicon.click();
	}

	public void enterdata() {
		phone.clear();
		phone.sendKeys("9497026565");

	}

	public void updatedata() {
		update.click();
	}

	/*
	 * public boolean isAlertDisplayed() { return alertmsge.isDisplayed(); }
	 */

}
