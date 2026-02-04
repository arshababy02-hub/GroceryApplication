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

	public void editdatafields() {
		address.clear();
		address.sendKeys("Tharayil");
		email.clear();
		email.sendKeys("arsha@gmail.com");
		phonenum.clear();
		phonenum.sendKeys("9775590000");

	}

	public void clickonupdatebtn() {
		updatebttn.click();
	}

}
