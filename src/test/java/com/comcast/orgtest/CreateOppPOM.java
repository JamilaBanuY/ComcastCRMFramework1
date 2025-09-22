package com.comcast.orgtest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.objectrepositoryutility.CreatNOrgPg;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OpprtunitiesPG;
import com.comcast.crm.objectrepositoryutility.OrgnizationsPage;
import com.comcast.genric.fileutility.ExcelUtility;
import com.comcast.genric.fileutility.FileUtility;
import com.comcast.gereric.webdriverutility.JavaUtility;

public class CreateOppPOM {
	public static void main(String[] args) throws Throwable {

		FileUtility flib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();

		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		System.out.println(BROWSER);

		String OprtName = eLib.getDataFromExcel("Opp", 1, 2) + jLib.getRandomNumber();

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
		// step1: login to app
		LoginPage lp=new LoginPage(driver);
		lp.logintoApp(URL, USERNAME, PASSWORD);

		// Step2: Navigate to Opportunities module
		OpprtunitiesPG Opt = new OpprtunitiesPG(driver);
		Opt.getOpptlink().click();

//step3: Click on create opt Button
		Opt.getCreateOppBtn().click();

//step4: enter all the details to create newOprtunity
		Opt.getOppname().sendKeys(OprtName);
//Opt.getCropbtn().click();
//Opt.getEntertext().sendKeys("Amezon_1982");
//Opt.getExistingOpplink().click();
		Opt.getSaveBtn().click();
		Alert f = driver.switchTo().alert();
		f.accept();

//Step6: Logout
		HomePage Hp = new HomePage(driver);
		Hp.Logout();
		System.out.println("Done");

	}
}