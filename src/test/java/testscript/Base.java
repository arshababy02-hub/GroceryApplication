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

public class Base {

	public WebDriver driver;
	public FileInputStream file;
	public Properties property;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void browserInitialization(String browser) throws Exception {
		try {
			property=new Properties();
			file=new FileInputStream(Contants.CONFIGFILE);
			property.load(file);
			
		}
		catch(Exception e) {
			System.out.println(e);
			
			
		}
		
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else
			throw new Exception("Invalid");

		//driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.get(property.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));
		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true)
	public void close() {
		driver.quit();
	}
}