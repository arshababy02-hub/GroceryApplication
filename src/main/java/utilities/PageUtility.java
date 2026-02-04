package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void dropdownselectByVisisbleText(WebElement elementname, String value) {
		Select s = new Select(elementname);
		s.selectByVisibleText(value);

	}

	public void dropdownSelectByValue(WebElement elementname, String value) {
		Select s = new Select(elementname);
		s.selectByValue(value);
	}

	public void dropdownSelectByIndex(WebElement elementname, int value) {
		Select s = new Select(elementname);
		s.selectByIndex(value);
	}

	public void actionClassDragAndDrop(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.dragAndDrop(element, element).perform();
	}

	public void actionRightClick(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick().perform();
	}

	public void actionMouseHover(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	public void actionDoubleClick(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}

	public void javaScriptExecutorDisplay() {

	}

	public void javaScriptExecutorScroll() {

	}
}
