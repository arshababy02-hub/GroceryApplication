package utilities;

import org.openqa.selenium.WebElement;

public class FileUploadUtilities {

	public void fileUploadUsingSendkeys(WebElement elementname, String path) {
		elementname.sendKeys(path);
	}
}