package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTestclass extends Base {

	@Test(priority = 1,description="verify user is able to login using valid password and user name")
	public void verifywhetheruserisabletoenterusingvalidcredentials() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusername(username);
		loginpage.enterpassword(password);
		loginpage.clicksignin();
		boolean home = loginpage.isHomePageDisplayed();
		Assert.assertTrue(home);

	}

	@Test(priority = 2)
	public void verifyuserabletoenterusinginvalidcredentials() throws IOException {
		String username = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusername(username);
		loginpage.enterpassword(password);
		loginpage.clicksignin();
		boolean alert1 = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert1);

	}

	@Test(priority = 3)
	public void verifyuserabletoenterusingvalidusernameandinvalidpassword() throws IOException {
		String username = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusername(username);
		loginpage.enterpassword(password);
		loginpage.clicksignin();
		boolean alert1 = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert1);
	}

	@Test(priority = 4,dataProvider="loginProvider")
	public void verifyuserabletoenterusinginvalidusernameandvalidpassword(String username,String password) throws IOException {
		//String username = ExcelUtility.getStringData(4, 0, "LoginPage");
		//String password = ExcelUtility.getStringData(4, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusername(username);
		loginpage.enterpassword(password);
		loginpage.clicksignin();
		boolean alert1 = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert1);
	}
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

	return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
	// new Object[] {ExcelUtility.getStringData(3,
	// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
	};
	}
}