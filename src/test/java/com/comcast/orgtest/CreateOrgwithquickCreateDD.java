package com.comcast.orgtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.objectrepositoryutility.CreateQuickOrgDD;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.genric.fileutility.ExcelUtility;
import com.comcast.genric.fileutility.FileUtility;
import com.comcast.gereric.webdriverutility.JavaUtility;
import com.comcast.gereric.webdriverutility.WebDriverUtility;

public class CreateOrgwithquickCreateDD {
	public static void main(String[] args) throws Throwable {

		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility Jlib = new JavaUtility();

		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");

		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");

		String dropdownname = eLib.getDataFromExcel("Opp", 4, 3);
		String newOrgName = eLib.getDataFromExcel("Opp", 4, 2) + Jlib.getRandomNumber();

		WebDriver driver = null;
		if (BROWSER.equals("ChromeDriver")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

//Navigate to Application

		driver.get(URL);
		wLib.getImplicitwait(driver);
		LoginPage Lp = new LoginPage(driver);
		Lp.logintoApp(URL, USERNAME, PASSWORD);

//click on Quick Create DropDown
		CreateQuickOrgDD Qcd = new CreateQuickOrgDD(driver);
		Qcd.getQcuikcrtBtn().click();

		Qcd.selectoptDD(dropdownname);

		Qcd.enterOrgname(newOrgName);
		HomePage Hp = new HomePage(driver);
		Hp.Logout();

		System.out.println("Done");
		driver.quit();
	}
}
