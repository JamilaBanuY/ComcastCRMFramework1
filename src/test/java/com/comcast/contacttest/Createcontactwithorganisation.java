package com.comcast.contacttest;

import java.time.Duration;

import java.util.Iterator;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.comcast.crm.objectrepositoryutility.ContactPg;
import com.comcast.crm.objectrepositoryutility.CreatNOrgPg;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPg;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrgnizationsPage;
import com.comcast.genric.fileutility.ExcelUtility;
import com.comcast.genric.fileutility.FileUtility;
import com.comcast.gereric.webdriverutility.JavaUtility;
import com.comcast.gereric.webdriverutility.WebDriverUtility;

public class Createcontactwithorganisation {
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
		 * 
		 * //generate the random number Random random=new Random(); int randomInt=
		 * random.nextInt(1000);
		 * 
		 * //read TestScript data from Excel File /* FileInputStream fis1=new
		 * FileInputStream("./testData/facebookdata.xlsx"); Workbook wb =
		 * WorkbookFactory.create(fis1); Sheet sh = wb.getSheet("contact"); Row row =
		 * sh.getRow(7);
		 */
		String orgName = eLib.getDataFromExcel("Org", 1, 2) + jLib.getRandomNumber();
		String ContactLastName = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandomNumber();
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		RemoteWebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		// step1 login to app
		/*
		 * driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 * driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 * driver.findElement(By.id("submitButton")).click();
		 */
		LoginPage lp = new LoginPage(driver);
		lp.logintoApp(URL, USERNAME, PASSWORD);
		// step2: navigate to Organization module*/
		// driver.findElement(By.linkText("Organizations")).click();
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		// step3: Click on create org Button
		// driver.findElement(By.xpath("//img[@title='Create
		// Organization...']")).click();
		OrgnizationsPage org = new OrgnizationsPage(driver);
		org.getCreatenewOrg().click();
		// step4: enter all the details to create newORg
		/*
		 * driver.findElement(By.name("accountname")).sendKeys(orgName);
		 * driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 */

		CreatNOrgPg Cnp = new CreatNOrgPg(driver);
		Cnp.getCreateNOrg(orgName);
		// step5 verify the Header info
		String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerinfo.contains(orgName)) {
			System.out.println(orgName + "info is verified");
		} else {
			System.out.println(orgName + "info is not verified");
		}

		// step5: navigate to Contacts module*/
		Thread.sleep(2000);
		driver.findElement(By.linkText("Contacts")).click();

		// step6: Click on create Contact Button
		// driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		ContactPg cp = new ContactPg(driver);
		cp.getContactBtn().click();
		// step7: enter all the details to create new org

		// driver.findElement(By.name("lastname")).sendKeys(ContactLastName);
		Thread.sleep(2000);
		// driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		CreateNewContactPg cnp = new CreateNewContactPg(driver);
		cnp.getcreatecontact(lastName);

		// switch To child Window
		/*
		 * Set<String> set = driver.getWindowHandles(); Iterator<String> it =
		 * set.iterator();
		 * 
		 * while (it.hasNext()) { String windowID = it.next();
		 * driver.switchTo().window(windowID);
		 * 
		 * String actUrl = driver.getCurrentUrl(); if
		 * (actUrl.contains("Accounts&parent")) { break; } }
		 */
		wlib.switchnewBrowserTab(driver, "module=Accounts");
		
		 driver.findElement(By.name("search_text")).sendKeys(orgName);
		  driver.findElement(By.name("search")).click();
		 
	/*	OrgnizationsPage op = new OrgnizationsPage(driver);
		op.getSearchOrg(orgName);*/

		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();

		// switch to parent window
		/*
		 * Set<String> set1 = driver.getWindowHandles(); Iterator<String> it1 =
		 * set1.iterator();
		 * 
		 * while (it1.hasNext()) { String windowID = it1.next();
		 * driver.switchTo().window(windowID);
		 * 
		 * String actUrl = driver.getCurrentUrl(); if
		 * (actUrl.contains("Contacts&action")) { break; } }
		 */
		wlib.switchtoTabonTitle(driver, "module=Contacts");
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerinfo.contains(ContactLastName)) {
			System.out.println(ContactLastName + "info is verified");
		} else {
			System.out.println(ContactLastName + "info is not verified");
		}

		String actorgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (actorgName.contains(orgName)) {
			System.out.println(orgName + "info is verified");
		} else {
			System.out.println(orgName + "info is not verified");
		}

		driver.quit();
	}

}
