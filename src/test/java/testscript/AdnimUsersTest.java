package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdnimUsersTest extends Base {
	public HomePage home;
	public AdminUsersPage adminuserpage;
	// Description-Testcases for AdminUser page

	@Test
	public void verifyUserAbleToManageAdminUserPage() throws IOException {

		// Step 1: Read valid login credentials from Excel
		String username = ExcelUtility.getStringData(1, 0, "Loginpage");
		String password = ExcelUtility.getStringData(1, 1, "Loginpage");
		// Step 2: Login to the application using valid credentials
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusername(username).enterpassword(password);

		// loginpage.enterpassword(password);
		home = loginpage.clicksignin();
		// Step 3: Navigate to Admin Users page
		// AdminUsersPage adminuserpage= new AdminUsersPage(driver);
		adminuserpage = home.clickonadminusers(); // Step 4: Click on New button to create a new admin user
		adminuserpage.clickonNew().enterdata().performdropdown().savedata();
		/*
		 * adminuserpage.enterdata(); adminuserpage.performdropdown();
		 * adminuserpage.savedata();
		 */
		// Verify success alert message is displayed
		boolean alert = adminuserpage.isAlertDisplayed();
		Assert.assertTrue(alert, "Admin user creation success message is not displayed");
	}
}
