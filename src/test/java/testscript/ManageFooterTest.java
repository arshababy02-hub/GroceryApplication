package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Contants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtility;

public class ManageFooterTest extends Base {
	public HomePage home;
	public ManageFooterPage managefooterpage;

	/**
	 * Test Case: Verify that user is able to edit and update footer text
	 * successfully. Login credentials are fetched from Excel file.
	 */
	@Test
	public void verifyuserabletomanagefootertext() throws IOException {
		// Read login credentials from Excel sheet
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);// Create LoginPage object and perform login
		loginpage.enterusername(username).enterpassword(password);

		// loginpage.enterpassword(password);
		home = loginpage.clicksignin();
		String address1 = ExcelUtility.getStringData(0, 0, "ManageFooter");
		String emailid = ExcelUtility.getStringData(1, 0, "ManageFooter");
		String phonenumber = ExcelUtility.getStringData(2, 0, "ManageFooter");
		// Create ManageFooterPage object
		// ManageFooterPage managefooterpage = new ManageFooterPage(driver);
		managefooterpage = home.clickonmoreinfofooter();// Navigate to footer management section
		managefooterpage.clickonediticon().editaddress(address1).editphonenumber(phonenumber).editemailid(emailid).clickonupdatebtn();
		/*managefooterpage.editaddress(address1); // Edit footer data fields
		managefooterpage.editphonenumber(phonenumber);
		managefooterpage.editemailid(emailid);
		managefooterpage.clickonupdatebtn();// Click update button to save changes*/
		boolean isUpdated = managefooterpage.isFooterUpdatedSuccessfully();
		// Assertion: Verify success message is displayed after update
		Assert.assertTrue(isUpdated, Contants.MANAGE_FOOTER);
	}
}
