package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutor extends Base {
	@Test

	public void test() {
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement msg = driver.findElement(By.xpath("//input[@id='single-input-field']"));
		// msg.sendKeys("hello");
		js.executeScript("arguments[0].value='hello';", msg);
		WebElement testmsg = driver.findElement(By.xpath("//button[@id='button-one']"));
		// testmsg.click();
		js.executeScript("arguments[0].click();", testmsg);

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].value='value';", webelement name);
		// js.executeScript("arguments[0].click();", webelement name);
	}

	@Test
	public void scroll() {
		driver.navigate().to(
				"https://www.amazon.in/s?k=massager+sofa+for+full+body&crid=1THAE4520UHDS&sprefix=massager+sofa%2Caps%2C255&ref=nb_sb_ss_ts-doa-p_1_13");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,2500)","");//forward scroll0 is x axis
		// and 2500y axis
		// js.executeScript("window.scrollBy(0,-2500)","");//back scroll
		// below script automatically calculate the size o page and scroll accordingly
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}

}
