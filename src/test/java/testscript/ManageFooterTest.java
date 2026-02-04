package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtility;

public class ManageFooterTest extends Base {
	@Test
	public void verifyuserabletomanagefootertext() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusername(username);

		loginpage.enterpassword(password);
		loginpage.clicksignin();

		ManageFooterPage managefooterpage = new ManageFooterPage(driver);
		managefooterpage.clickonmoreinfofooter();
		managefooterpage.clickonediticon();
		managefooterpage.editdatafields();
		managefooterpage.clickonupdatebtn();

	}
}
