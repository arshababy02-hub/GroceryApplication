package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {

	@Test(groups = { "Regression" })
	public void verifyuserabletomanagecategorysuccessfully() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "Loginpage"); // Step 1: Read valid login credentials from
																			// Excel
		String password = ExcelUtility.getStringData(1, 1, "Loginpage");

		LoginPage loginpage = new LoginPage(driver);// Step 2: Login to the application
		loginpage.enterusername(username);

		loginpage.enterpassword(password);
		loginpage.clicksignin();
		String categoryName = ExcelUtility.getStringData(0, 0, "ManageCategory");
		ManageCategoryPage category = new ManageCategoryPage(driver);// Step 3: Navigate to Manage Category page
		category.clickoncategorymoreinfo();
		category.clickonnew();// Step 4: Click on New button to add a category
		category.adddata(categoryName);// Step 5: Enter category details
		category.addfile(); // Step 6: Upload category image/file
		category.savedata();// Step 7: Save the category
		boolean alert = category.isAlertDisplayed();
		Assert.assertTrue(alert, "Category creation success message is not displayed");
	}

}
