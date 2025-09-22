package com.comcast.orgtest;

import java.time.Duration;

import javax.xml.xpath.XPath;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.objectrepositoryutility.CreatNOrgPg;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationinfoPage;
import com.comcast.crm.objectrepositoryutility.OrgnizationsPage;
import com.comcast.genric.fileutility.ExcelUtility;
import com.comcast.genric.fileutility.FileUtility;
import com.comcast.gereric.webdriverutility.JavaUtility;
import com.comcast.gereric.webdriverutility.WebDriverUtility;

public class DeleteOrgTest {
	public static void main(String[] args) throws Throwable {
		FileUtility flib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		System.out.println(BROWSER);

		// read common data from properties file
		/*
		 * FileInputStream fis=new FileInputStream("./ConfigAppdata/DataDT.properties");
		 * Properties p=new Properties(); p.load(fis);
		 * 
		 * String BROWSER = p.getProperty("browser"); String URL = p.getProperty("url");
		 * String USERNAME = p.getProperty("username"); String PASSWORD =
		 * p.getProperty("password"); System.out.println(BROWSER);
		 */ // added file utility

		/// generate the random number
		/*
		 * Random random=new Random(); int randomInt= random.nextInt(1000);
		 */ // used JLib

		// read TestScript data from Excel File
		// read date from excelutlity
		/*
		 * FileInputStream fis1=new FileInputStream("./testData/facebookdata.xlsx");
		 * Workbook wb = WorkbookFactory.create(fis1); Sheet sh = wb.getSheet("Org");
		 * Row row = sh.getRow(7); String orgName = row.getCell(3).toString() +
		 * randomInt; String ContactLastName = row.getCell(4).toString();
		 */
		String orgName = eLib.getDataFromExcel("Org", 10, 2) + jLib.getRandomNumber();

		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get(URL);
		// step1 login to app
		LoginPage lp = new LoginPage(driver);
		lp.logintoApp(URL, USERNAME, PASSWORD);
		// step2: navigate to Organization module*/
		HomePage Hp = new HomePage(driver);
		Hp.getOrgLink().click();

		// step3: Click on create org Button
		OrgnizationsPage org = new OrgnizationsPage(driver);
		org.getCreatenewOrg().click();

		// step4: enter all the details to create newORg
		CreatNOrgPg Cnp = new CreatNOrgPg(driver);
		Cnp.getCreateNOrg(orgName);

		// Step5: Verify HeaderMsg
		OrganizationinfoPage oip = new OrganizationinfoPage(driver);
		String actorgName = oip.getHeaderMsg().getText();
		if (actorgName.contains(orgName)) {
			System.out.println(orgName + "Name is Verified ==PASS");

		} else {
			System.out.println(orgName + "Name is not Verified ==Fail");

		}
		// Go back to OrganisationPage
		Hp.getOrgLink().click();

		// search for Organization
		org.getSearchEdt().sendKeys(orgName);
		wlib.SelectbyVT(org.getSearchDD(), "Organization Name");
		org.getSearchBtn().click();

		driver.findElement(By.xpath("//a[text()='" + orgName + "']/../../td[8]/a[text()='del']")).click();
		Alert f = driver.switchTo().alert();
		f.accept();
		// Step6: Logout
		Hp.Logout();

	}// Banu_2368
}
