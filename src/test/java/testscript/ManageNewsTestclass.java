package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTestclass extends Base {
	@Test(priority = 1)
	public void verifuserabletopublishmessage() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusername(username);
		loginpage.enterpassword(password);
		loginpage.clicksignin();

		ManageNewsPage manage = new ManageNewsPage(driver);
		manage.clickonmoreinfo();
		manage.clickonnews();
		manage.entermessage();
		manage.save();
		boolean msgalert = manage.isAlertmessageDisplayed();
		Assert.assertTrue(msgalert);
	}

	@Test(priority = 2)
	public void verifylogoutbutton() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusername(username);
		loginpage.enterpassword(password);
		loginpage.clicksignin();

		ManageNewsPage manage = new ManageNewsPage(driver);
		manage.clickonlogout();
	}

}
