package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTestclass extends Base {
	/**
	 * Test Case 1: Verify that user is able to login using valid username and valid
	 * password. Test data is fetched from Excel sheet.
	 */

	@Test(priority = 1, description = "verify user is able to login using valid password and user name")
	public void verifywhetheruserisabletoenterusingvalidcredentials() throws IOException {
		// Read valid username and password from Excel
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		// Create object of LoginPage
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusername(username);// Perform login actions
		loginpage.enterpassword(password);
		loginpage.clicksignin();
		boolean home = loginpage.isHomePageDisplayed();// Verify whether home page is displayed
		Assert.assertTrue(home, "home page is not loaded with valid credentials");

	}

	/**
	 * Test Case 2: Verify login attempt using invalid username and invalid
	 * password.
	 */

	@Test(priority = 2)
	public void verifyuserabletoenterusinginvalidcredentials() throws IOException {
		String username = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusername(username);
		loginpage.enterpassword(password);
		loginpage.clicksignin();
		boolean home = loginpage.isHomePageDisplayed();
		Assert.assertTrue(home, "home page is not loaded with valid credentials");

	}

	/**
	 * Test Case 3: Verify login using valid username and invalid password.
	 */
	@Test(priority = 3)
	public void verifyuserabletoenterusingvalidusernameandinvalidpassword() throws IOException {
		String username = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusername(username);
		loginpage.enterpassword(password);
		loginpage.clicksignin();
		boolean home = loginpage.isHomePageDisplayed();
		Assert.assertTrue(home, "home page is not loaded with valid credentials");
	}

	/**
	 * Test Case 4: Verify login using invalid username and valid password. Data is
	 * supplied using DataProvider.
	 */

	@Test(priority = 4, dataProvider = "loginProvider")
	public void verifyuserabletoenterusinginvalidusernameandvalidpassword(String username, String password)
			throws IOException {
		// String username = ExcelUtility.getStringData(4, 0, "LoginPage");
		// String password = ExcelUtility.getStringData(4, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusername(username);
		loginpage.enterpassword(password);
		loginpage.clicksignin();
		boolean home = loginpage.isHomePageDisplayed();
		Assert.assertTrue(home, "home page is not loaded with valid credentials");
	}

	/**
	 * DataProvider method: Supplies multiple sets of login credentials to test
	 * method.
	 */
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}
}