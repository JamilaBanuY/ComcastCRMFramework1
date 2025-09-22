package com.comcast.orgtest;

import java.io.FileInputStream;

import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.objectrepositoryutility.CreatNOrgPg;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrgnizationsPage;
import com.comcast.genric.fileutility.ExcelUtility;
import com.comcast.genric.fileutility.FileUtility;
import com.comcast.gereric.webdriverutility.JavaUtility;

public class CreateOrgTest {
	public static void main(String[] args) throws Throwable {
		FileUtility flib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();

		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		System.out.println(BROWSER);
		
		//read common data from properties file
			/*	FileInputStream fis=new FileInputStream("./ConfigAppdata/DataDT.properties");
				Properties p=new Properties();
				p.load(fis);
				
				String BROWSER = p.getProperty("browser");
				String URL = p.getProperty("url");
				String USERNAME = p.getProperty("username");
				String PASSWORD = p.getProperty("password");
				System.out.println(BROWSER);*/ // added file utility
				
			///generate the random number
			/*Random random=new Random();
				int randomInt=		random.nextInt(1000);*/ //used JLib
				
				//read TestScript data from Excel File
				//read date from excelutlity
		/*	FileInputStream fis1=new FileInputStream("./testData/facebookdata.xlsx");
				Workbook wb = WorkbookFactory.create(fis1);
				Sheet sh = wb.getSheet("Org");
				Row row = sh.getRow(7);
					String orgName = row.getCell(3).toString() + randomInt;
			String ContactLastName = row.getCell(4).toString();*/
			String orgName = eLib.getDataFromExcel("contact", 1, 2) +jLib.getRandomNumber();		
		
			WebDriver driver=null;
			if(BROWSER.equals("chrome"))
			{
			driver=new ChromeDriver();
			}else if(BROWSER.equals("firefox"))
			{driver=new FirefoxDriver();
			}
			else {driver=new ChromeDriver();
			}
			/*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(URL);*/
			//step1 login to app
			/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();*/
			LoginPage lp=new LoginPage(driver);
			lp.logintoApp(URL, USERNAME, PASSWORD);

			//step2: navigate to Organization module*/
			//driver.findElement(By.linkText("Organizations")).click();
			HomePage hp=new HomePage(driver);
			hp.getOrgLink().click();

			//step3: Click on create org Button
		//	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			OrgnizationsPage org = new OrgnizationsPage(driver);
			org.getCreatenewOrg().click();
			
			//step4: enter all the details to create newORg
		/*	driver.findElement(By.name("accountname")).sendKeys(orgName);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();*/
			CreatNOrgPg Cnp = new CreatNOrgPg(driver);
			Cnp.getCreateNOrg(orgName);
			
			
			
			String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(headerinfo.contains(orgName))
			{System.out.println(orgName+"info is verified");
			}else
			{System.out.println(orgName+"info is not verified");
			}
	}

}
