package com.comcast.contacttest;

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

import com.comcast.crm.objectrepositoryutility.ContactPg;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPg;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.genric.fileutility.ExcelUtility;
import com.comcast.genric.fileutility.FileUtility;
import com.comcast.gereric.webdriverutility.JavaUtility;


public class CreateContactTest {

public static void main(String[] args) throws Throwable {
		//Create Object/*
	FileUtility flib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();

	String BROWSER = flib.getDataFromPropertiesFile("browser");
	String URL = flib.getDataFromPropertiesFile("url");
	String USERNAME = flib.getDataFromPropertiesFile("username");
	String PASSWORD = flib.getDataFromPropertiesFile("password");
	System.out.println(BROWSER);
		
	/*	//read common data from properties file
				FileInputStream fis=new FileInputStream("./ConfigAppdata/DataDT.properties");
				Properties p=new Properties();
				p.load(fis);*/ //commented and added above
				
				
			///generate the random number
				Random random=new Random();
				int randomInt=		random.nextInt(1000);
				
				//read TestScript data from Excel File
			/*	FileInputStream fis1=new FileInputStream("./testData/facebookdata.xlsx");
				Workbook wb = WorkbookFactory.create(fis1);
				Sheet sh = wb.getSheet("contact");
				Row row = sh.getRow(1);
				String lastName = row.getCell(2).toString() + randomInt;*/
				
				String lastName =eLib.getDataFromExcel("contact", 1, 2)+ jLib.getRandomNumber();
			
				
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

		//step2: navigate to Contact module*/
		//driver.findElement(By.linkText("Contacts")).click();
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();

		//step3: Click on create Contact Button
		//driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
        ContactPg cp=new ContactPg(driver);
        cp.getContactBtn().click();
        
		//step4: enter all the details to create new contact
		
	/*	driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();*/
		
        CreateNewContactPg cnp=new CreateNewContactPg(driver);
        cnp.getcreatecontact(lastName);
        
		//verify the lastname
		
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if(actLastName.equals(lastName))
		{System.out.println(lastName+"info is verified");
		}else
		{System.out.println(lastName+"info is nont verified");
		}
		
			
driver.quit();
	}
	}