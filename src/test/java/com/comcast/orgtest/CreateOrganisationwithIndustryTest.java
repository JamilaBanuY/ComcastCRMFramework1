package com.comcast.orgtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrgnizationsPage;
import com.comcast.genric.fileutility.ExcelUtility;
import com.comcast.genric.fileutility.FileUtility;
import com.comcast.gereric.webdriverutility.JavaUtility;

public class CreateOrganisationwithIndustryTest {
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
				/*FileInputStream fis=new FileInputStream("./ConfigAppdata/DataDT.properties");
				Properties p=new Properties();
				p.load(fis);
				
				String BROWSER = p.getProperty("browser");
				String URL = p.getProperty("url");
				String USERNAME = p.getProperty("username");
				String PASSWORD = p.getProperty("password");
				System.out.println(BROWSER);*/
				
			///generate the random number
			/*	Random random=new Random();
				int randomInt=		random.nextInt(1000);*/
				
				//read TestScript data from Excel File
			/*	FileInputStream fis1=new FileInputStream("./testData/facebookdata.xlsx");
				Workbook wb = WorkbookFactory.create(fis1);
				Sheet sh = wb.getSheet("Org");
				Row row = sh.getRow(4);*/
				String orgName = eLib.getDataFromExcel("Org", 0, 2).toString() + jLib.getRandomNumber();
				String industry = eLib.getDataFromExcel("Org", 4, 3).toString() ;
				String type = eLib.getDataFromExcel("Org", 4, 4).toString();
						
		RemoteWebDriver driver=null;
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
		/*driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();*/

		LoginPage lp= new LoginPage(driver);
		lp.logintoApp(URL, USERNAME, PASSWORD);
		//step2: navigate to Organization module*/
		HomePage hp=new HomePage(driver);
		hp.getOrgLink();

		//step3: Click on create org Button
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		OrgnizationsPage op=new OrgnizationsPage(driver);
		op.getCreatenewOrg().click();
		
		//step4: enter all the details to create new org
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		 WebElement ele = driver.findElement(By.name("industry"));
		Select s =new Select(ele);
		s.selectByVisibleText(industry);
		WebElement ele1 = driver.findElement(By.name("accounttype"));
		Select S=new Select(ele1);
		S.selectByVisibleText(type);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//verify the Dropdown Industry and Type info
		
		String actIndustry = driver.findElement(By.id("dtlview_Industry")).getText();
		if(actIndustry.equals(industry))
		{System.out.println(industry+"info is verified");
		}else
		{System.out.println(industry+"info is nont verified");
		}
			//verify Header orgName Expected Result 
			String actType = driver.findElement(By.id("txtbox_Type")).getText();
			
			if(actType.equals(type)) 
			{System.out.println(actType+"info is verified");
			}else
			{System.out.println(actType+"info is notverified");
			}

	}
	
}
