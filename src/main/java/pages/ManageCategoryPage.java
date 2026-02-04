package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Contants;
import utilities.FileUploadUtilities;

public class ManageCategoryPage {

	public WebDriver driver;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']//i[@class='fas fa-arrow-circle-right']")
	WebElement categoryinfo;
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

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickoncategorymoreinfo() {
		categoryinfo.click();
	}

	public void clickonnew() {
		category_new.click();
	}

	public void adddata() {
		category_name.sendKeys("Hello");
		discount.click();

	}

	public void addfile() {
		FileUploadUtilities fileupload = new FileUploadUtilities();
		fileupload.fileUploadUsingSendkeys(addfile, Contants.IMAGE);
	}

	public void savedata() {
		Save.click();
	}
}
