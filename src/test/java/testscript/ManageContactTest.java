package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Contants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {
	public HomePage home;
	public ManageContactPage managecontact;

	// Description:test cases for updating contact information
	@Test
	public void verifyusercanupdatecontactinformation() throws IOException {
		// Step 1: Read valid login credentials from Excel
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		// Step 2: Login to the application
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusername(username).enterpassword(password);

		// loginpage.enterpassword(password);
		home = loginpage.clicksignin();
		String Phonenumber = ExcelUtility.getStringData(1, 0, "ManageCategory");
		String email = ExcelUtility.getStringData(2, 0, "ManageCategory");
		// Step 3: Navigate to Manage Contact page
		// ManageContactPage managecontact = new ManageContactPage(driver);
		managecontact = home.clickonmanagecontact();
		managecontact.clickonedit().enterdata(Phonenumber).enterEmail(email).updatedata();// Step 4: Click on Edit option to update contact details
		/*managecontact.enterdata(Phonenumber);// Step 5: Update contact information
		managecontact.enterEmail(email);
		managecontact.updatedata();// Step 6: Save / Update the contact details*/
		boolean alert = managecontact.isAlertDisplayed();// Step 7: Verify success alert message is displayed
		Assert.assertTrue(alert, Contants.MANAGE_CONTACT);
	}

}
