package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {
	@Test
	public void verifyusercanupdatecontactinformation() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusername(username);

		loginpage.enterpassword(password);
		loginpage.clicksignin();

		ManageContactPage managecontact = new ManageContactPage(driver);
		managecontact.clickonmanagecontact();
		managecontact.clickonedit();
		managecontact.enterdata();
		managecontact.updatedata();

	}

}
