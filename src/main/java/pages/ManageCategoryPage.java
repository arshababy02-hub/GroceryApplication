package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Contants;
import utilities.FileUploadUtilities;
import utilities.PageUtility;

public class ManageCategoryPage {

	public WebDriver driver;

	//@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']//i[@class='fas fa-arrow-circle-right']")
	//WebElement categoryinfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement category_new;
	@FindBy(xpath = "//input[@name='category']")
	WebElement category_name;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement discount;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement addfile;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement Save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//child::h5")
	WebElement alertmsg;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*public void clickoncategorymoreinfo() {
		//categoryinfo.click();
		PageUtility click = new PageUtility();
		click.click(driver, categoryinfo);
		
		
	}*/

	public ManageCategoryPage clickonnew() {
		category_new.click();
		return this;
	}

	public ManageCategoryPage addfile() {
		FileUploadUtilities fileupload = new FileUploadUtilities();
		fileupload.fileUploadUsingSendkeys(addfile, Contants.IMAGE);
		return this;
	}

	public ManageCategoryPage savedata() {
		PageUtility click = new PageUtility();
		click.click(driver, Save);
		return this;
		
		
	}

	public boolean isAlertDisplayed() {
		return alertmsg.isDisplayed();
	}

	public ManageCategoryPage adddata(String categoryName) {
		category_name.click();
		category_name.sendKeys(categoryName);
		discount.click();
		return this;

	}
}
