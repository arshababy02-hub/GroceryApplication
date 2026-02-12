package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

/**
 * ManageNewsTestclass contains test cases related to publishing news messages
 * and logout functionality. This class extends Base class to reuse browser
 * setup and teardown.
 */
public class ManageNewsTestclass extends Base {
	/**
	 * Test Case 1: Verify that user is able to publish a news message successfully.
	 */
	@Test(priority = 1)

	public void verifuserabletopublishmessage() throws IOException {
		// Read login credentials from Excel
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		// Login to the application
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusername(username);
		loginpage.enterpassword(password);
		loginpage.clicksignin();
		String msg=ExcelUtility.getStringData(3, 0, "ManageFooter");
		// Navigate to Manage News page and publish message
		ManageNewsPage manage = new ManageNewsPage(driver);
		manage.clickonmoreinfo();
		manage.clickonnews();
		manage.entermessage(msg);
		manage.save();
		boolean msgalert = manage.isAlertmessageDisplayed();
		Assert.assertTrue(msgalert);
	}
	/**
	 * Test Case 2: Verify that user is able to logout successfully.
	 */
	/*
	 * @Test(priority = 2) public void verifylogoutbutton() throws IOException {
	 * String username = ExcelUtility.getStringData(1, 0, "LoginPage"); String
	 * password = ExcelUtility.getStringData(1, 1, "LoginPage");
	 * 
	 * LoginPage loginpage = new LoginPage(driver);
	 * loginpage.enterusername(username); loginpage.enterpassword(password);
	 * loginpage.clicksignin();
	 * 
	 * ManageNewsPage manage = new ManageNewsPage(driver); manage.clickonlogout(); }
	 */

}
