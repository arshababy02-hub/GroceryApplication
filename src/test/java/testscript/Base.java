package testscript;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.math3.analysis.function.Constant;
import org.apache.logging.log4j.util.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Contants;
import utilities.WaitUtility;

/**
 * Base class is used to perform common setup and teardown operations like
 * browser initialization, loading configuration, and closing browser. All test
 * classes will extend this Base class.
 */
public class Base {

	public WebDriver driver;// WebDriver instance used across test classes
	public FileInputStream file;
	public Properties property; // Properties object to read values from config file

	/**
	 * This method initializes the browser before each test method. Browser name is
	 * passed from testng.xml using @Parameters.
	 */
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void browserInitialization(String browser) throws Exception {
		try {
			property = new Properties();// Create Properties object
			file = new FileInputStream(Contants.CONFIGFILE);// Load configuration file using file path from Constants
															// class
			property.load(file);

		} catch (Exception e) {
			System.out.println(e);

		}
		// Launch browser based on the parameter value
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else
			throw new Exception("Invalid"); // Throw exception if invalid browser name is provided

		// driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.get(property.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));// Apply implicit wait
																								// using utility class
		driver.manage().window().maximize(); // Maximize the browser window
	}

	/**
	 * This method closes the browser after each test method execution.
	 */
	@AfterMethod(alwaysRun = true)
	public void close() {
		driver.quit();
	}
}