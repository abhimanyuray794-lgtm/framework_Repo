package abhi.generic.baseclassutility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import abhi.generic.databaseutility.DatabaseUtility;
import abhi.generic.fileutility.ExcelUtility;
import abhi.generic.fileutility.PropertiesFileUtility;
import abhi.generic.webdriverutility.WebdriverUtility;
import abhi.objectrepositoryutility.HomePage;
import abhi.objectrepositoryutility.LoginPage;

public class BaseClassForAbhiTek {

	public PropertiesFileUtility plib = new PropertiesFileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public DatabaseUtility dlib = new DatabaseUtility();
	public WebdriverUtility wlib = new WebdriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite (groups = {"smokeTest","regressionTest"})
	public void configBS() {
		System.out.println("connect to database!");
	}

//	@Parameters("browser")
	@BeforeClass (groups = {"smokeTest","regressionTest"})
//	public void configBC(String browser) throws IOException {
	public void configBC() throws IOException {
		System.out.println("launch browser!");
//		String BROWSER = browser;
		String BROWSER = System.getProperty("browser",plib.readDataFromPropertiesFile("browser"));
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		sdriver = driver;
	}

	@BeforeMethod (groups = {"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
		System.out.println("navigate to url and login!");

		String URL = System.getProperty("url",plib.readDataFromPropertiesFile("url"));
		String USERNAME = System.getProperty("username",plib.readDataFromPropertiesFile("username"));
		String PASSWORD = System.getProperty("password",plib.readDataFromPropertiesFile("password"));

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod (groups = {"smokeTest","regressionTest"})
	public void configAM() {
		System.out.println("logout!");

		HomePage hp = new HomePage(driver);
		wlib.moveMouseToElement(driver, hp.getMouseHover());
		hp.getSignoutButton().click();
	}

	@AfterClass (groups = {"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("close browser!");
		driver.quit();
	}

	@AfterSuite (groups = {"smokeTest","regressionTest"})
	public void configAS() throws SQLException {
		System.out.println("close database!");
//		dlib.closeDatabaseConnection();
	}
}
