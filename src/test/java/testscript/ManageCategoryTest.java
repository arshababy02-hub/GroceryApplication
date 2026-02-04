package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {

	@Test(groups = { "Regression" })
	public void verifyuserabletomanagecategorysuccessfully() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "Loginpage");
		String password = ExcelUtility.getStringData(1, 1, "Loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusername(username);

		loginpage.enterpassword(password);
		loginpage.clicksignin();

		ManageCategoryPage category = new ManageCategoryPage(driver);
		category.clickoncategorymoreinfo();
		category.clickonnew();
		category.adddata();
		category.addfile();
		category.savedata();

	}

}
