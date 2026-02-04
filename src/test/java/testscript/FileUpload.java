package testscript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FileUpload extends Base {
	@Test
	public void fileUploadUsingSendkeys() {
		driver.navigate().to("https://the-internet.herokuapp.com/upload");
		WebElement choosefile = driver.findElement(By.xpath("//input[@id='file-upload']"));
		choosefile.sendKeys("C:\\Users\\Admin\\Downloads\\Homekeyy Adminpanel UserManual.pdf");
		WebElement upload = driver.findElement(By.xpath("//input[@id='file-submit']"));
		upload.click();
	}

	@Test
	public void FileUploadUsingRobotclass() throws AWTException {
		driver.navigate().to("https://www.ilovepdf.com/pdf_to_word");
		WebElement selectpdf = driver.findElement(By.xpath("//span[text()='Select PDF file']"));
		selectpdf.click();
		// StringSelection -cls to transfer data
		StringSelection obj = new StringSelection("C:\\Users\\Admin\\Downloads\\UserManual-Electricity bill.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(obj, null);// pass object of string selection and
																				// null
		Robot r = new Robot();
		r.delay(2500);
		r.keyPress(KeyEvent.VK_CONTROL);// keyevent is a classin robot class,VK is virtual key
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

}
