package com.crm.CreateContTng;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.objectrepositoryutility.ContactPg;
import com.comcast.crm.objectrepositoryutility.ContactinfoPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPg;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.crm.GenericBaseUtility.BaseClass;

public class CreateContactTest extends BaseClass {

	@Test(groups = "smoke Test")
	public void CreatecontactLn() throws IOException, Throwable { 
		
		// read TestScript data from Excel File
		System.out.println("execute Create Contact");
		String lastName = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();

		// step2: navigate to Contact module*/
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// step2: click on createnew contact "+" Button*/
		ContactPg Cp = new ContactPg(driver);
		Cp.getContactBtn().click();

		// enter detains in Lastname text field
		CreateNewContactPg cnc = new CreateNewContactPg(driver);
		cnc.getcreatecontact(lastName);
		cnc.getSaveBtn();

		// verify the Header PhoneNumber info Expected Result

	//	String actHeader = driver.findElement(By.id("dvHeaderText")).getText();
		/*ContactPg
		 * if (actHeader.contains(lastName)) { System.out.println(lastName +
		 * "Name is Verified ==PASS");
		 * 
		 * } else { System.out.println(lastName + "Name is not Verified ==Fail"); }
		 */
		String actHeader = Cp.getHeadertext().getText();
		boolean status = actHeader.contains(lastName);
		Assert.assertEquals(status, true);

		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(lastName, actLastName);
		/*
		 * if (actLastName.equals(lastName)) { System.out.println(lastName +
		 * "info is verified"); } else { System.out.println(lastName +
		 * "info is nont verified"); }
		 */

	}

	@Test(groups = "regressionTest")
	public void createContactwithsuppdate() throws Throwable, Throwable {
		System.out.println("execute Create Contact with date and verify");
		// step1://read TestScript data from Excel File
		String lastName = elib.getDataFromExcel("contact", 1, 2).toString() + jlib.getRandomNumber();

		// launch and login is in Baseclass

		// step2: navigate to Contact module*/
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// step3: click on create new Button*/
		ContactPg Cp = new ContactPg(driver);
		Cp.getContactBtn().click();

		String startDate = jlib.getSystemDate();
		String endDate = jlib.getRequiredDate(30);
		// System.out.println(endDate);
		ContactinfoPage cip = new ContactinfoPage(driver);
		cip.getdates(lastName, startDate, endDate);

		// verify the calenderdate

		String actstrdate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actstrdate.equals(startDate)) {
			System.out.println(startDate + "info is verified");
		} else {
			System.out.println(startDate + "info is not verified");
		}

		String actenddate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (actenddate.equals(endDate)) {
			System.out.println(endDate + "info is verified");
		} else {
			System.out.println(endDate + "info is not verified");
		}

	}

}
