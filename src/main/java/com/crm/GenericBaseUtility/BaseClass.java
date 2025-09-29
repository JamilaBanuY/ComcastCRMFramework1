package com.crm.GenericBaseUtility;

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

import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.genric.fileutility.ExcelUtility;
import com.comcast.genric.fileutility.FileUtility;
import com.comcast.gereric.webdriverutility.JavaUtility;
import com.comcast.gereric.webdriverutility.UtilityClassObject;
import com.concast.generic.databaseUtility.DataBaseUtility;

public class BaseClass {
	/* create Object */
	public DataBaseUtility dlib = new DataBaseUtility();
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	/*public static ExtentSparkReporter spark;
	public static ExtentReports report;*/
	@BeforeSuite(groups = { "regressionTest", "smoke Test" })
	public void BS() throws SQLException {
		System.out.println(" Connect DB");
		dlib.getDbconnection();
		
	/*	// spark Report Config
				ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
				spark.config().setDocumentTitle("CRM Test Suite Results");
				spark.config().setReportName("CRM Report");
				spark.config().setTheme(Theme.STANDARD);
				
				// add Env information and create test
				report = new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("os", "windows-11");
				report.setSystemInfo("BROWSER", "Chrome-138");
	}*/
	}
	@BeforeClass(groups = { "regressionTest", "smoke Test" })
	public void BC() throws Throwable {
		System.out.println("Launch Browser");
	//	String BROWSER = flib.getDataFromPropertiesFile("browser");
	String BROWSER =System.getProperty("browser", flib.getDataFromPropertiesFile("browser"));
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
sdriver=driver;
UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups = { "regressionTest", "smoke Test" })
	public void BM() throws Throwable {
		System.out.println("Login to app");
		//String URL = flib.getDataFromPropertiesFile("url");
		//String USERNAME = flib.getDataFromPropertiesFile("username");
		//String PASSWORD = flib.getDataFromPropertiesFile("password");
		String URL =System.getProperty("url", flib.getDataFromPropertiesFile("url"));
		String USERNAME = System.getProperty("username", flib.getDataFromPropertiesFile("username"));
		String PASSWORD = System.getProperty("password", flib.getDataFromPropertiesFile("password"));
		LoginPage lp = new LoginPage(driver);
		lp.logintoApp(URL, USERNAME, PASSWORD);

	}

	@AfterMethod(groups = { "regressionTest", "smoke Test" })
	public void AM() {
		System.out.println("Logout");
		HomePage hp = new HomePage(driver);
		hp.Logout();
	}

	@AfterClass(groups = { "regressionTest", "smoke Test" })
	public void AC() {
		
		System.out.println("Close Browser");
		driver.close();
	}

	@AfterSuite(groups = { "regressionTest", "smoke Test" })
	public void AS() throws SQLException {
		System.out.println("Close DB Report Back");
		dlib.closeDBConnection();
		
	}
}
