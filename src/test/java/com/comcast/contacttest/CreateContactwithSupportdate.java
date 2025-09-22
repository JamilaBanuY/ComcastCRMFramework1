package com.comcast.contacttest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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
import org.openqa.selenium.remote.RemoteWebDriver;

import com.comcast.crm.objectrepositoryutility.ContactinfoPage;
import com.comcast.genric.fileutility.ExcelUtility;
import com.comcast.genric.fileutility.FileUtility;
import com.comcast.gereric.webdriverutility.JavaUtility;

public class CreateContactwithSupportdate {
	public static void main(String[] args) throws Throwable{
		FileUtility flib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();

		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		System.out.println(BROWSER);
	//read common data from properties file
	/*FileInputStream fis=new FileInputStream("./ConfigAppdata/DataDT.properties");
	Properties p=new Properties();
	p.load(fis);
	
	String BROWSER = p.getProperty("browser");
	String URL = p.getProperty("url");
	String USERNAME = p.getProperty("username");
	String PASSWORD = p.getProperty("password");
	System.out.println(BROWSER);
	
///generate the random number
	Random random=new Random();
	int randomInt=		random.nextInt(1000);
	
	//read TestScript data from Excel File
	FileInputStream fis1=new FileInputStream("./testData/facebookdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis1);
	Sheet sh = wb.getSheet("contact");
	Row row = sh.getRow(4);*/
	String lastName = eLib.getDataFromExcel("contact", 4, 2).toString() + jLib.getRandomNumber();

WebDriver driver=null;

if(BROWSER.equals("chrome"))
{
driver=new ChromeDriver();
}else if(BROWSER.equals("firefox"))
{driver=new FirefoxDriver();
}
else {driver=new ChromeDriver();
}
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.get(URL);
//step1 login to app
driver.findElement(By.name("user_name")).sendKeys(USERNAME);
driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
driver.findElement(By.id("submitButton")).click();

//step2: navigate to Contact module*/
driver.findElement(By.linkText("Contacts")).click();

//step3: Click on create org Button
driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

//step4: enter all the details to create contact
 /*Date dateObj = new Date();
SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
String startdate = sim.format(dateObj);

Calendar cal=sim.getCalendar();
cal.add(Calendar.DAY_OF_MONTH,30);
String enddate = sim.format(cal.getTime());*/


String startDate = jLib.getSystemDate();
String endDate = jLib.getRequiredDate(30);
System.out.println(endDate);

/*driver.findElement(By.name("lastname")).sendKeys(lastName);
driver.findElement(By.name("support_start_date")).clear();
driver.findElement(By.name("support_start_date")).sendKeys(startDate);*/
ContactinfoPage cip=new ContactinfoPage(driver);

cip.getdates(lastName, startDate, endDate);


/*driver.findElement(By.name("support_end_date")).clear();
driver.findElement(By.name("support_end_date")).sendKeys(endDate);*/
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

//verify the calenderdate

String actstrdate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
if(actstrdate.equals(startDate))
{System.out.println(startDate+"info is verified");
}else
{System.out.println(startDate+"info is not verified");
}

String actenddate = driver.findElement(By.id("dtlview_Support End Date")).getText();
if(actenddate.equals(endDate))
{System.out.println(endDate+"info is verified");
}else
{System.out.println(endDate+"info is not verified");}

driver.quit();
}

	}
