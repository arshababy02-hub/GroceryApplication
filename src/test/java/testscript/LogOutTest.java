package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LogOutPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LogOutTest extends Base {
	@Test
	public void verifyUserIsAbleToLogout() throws IOException {
		// Step 1: Fetch valid username from Excel test data
		String username = ExcelUtility.getStringData(1, 0, "Loginpage");

		// Step 2: Fetch valid password from Excel test data
		String password = ExcelUtility.getStringData(1, 1, "Loginpage");

		// Step 3: Create LoginPage object to perform login actions
		LoginPage loginpage = new LoginPage(driver);

		// Step 4: Enter username in login page
		loginpage.enterusername(username);

		// Step 5: Enter password in login page
		loginpage.enterpassword(password);

		// Step 6: Click on Sign In button to login
		loginpage.clicksignin();

		// Step 7: Create LogOutPage object to perform logout actions
		LogOutPage logoutpage = new LogOutPage(driver);

		// Step 8: Click on Admin icon and select Logout option
		logoutpage.clickOnLogout();

		// Step 9: Verify whether user is redirected to Login page after logout
		boolean loginPage = logoutpage.isloginPageDisplayed();

		// Step 10: Assertion to confirm logout is successful
		Assert.assertTrue(loginPage, "Login page is not displayed after logout");
	}

}
