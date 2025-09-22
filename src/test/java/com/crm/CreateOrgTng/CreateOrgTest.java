package com.crm.CreateOrgTng;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.ListenerUtility.LisImpclass;
import com.comcast.crm.objectrepositoryutility.CreatNOrgPg;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationinfoPage;
import com.comcast.crm.objectrepositoryutility.OrgnizationsPage;
import com.comcast.gereric.webdriverutility.UtilityClassObject;
import com.crm.GenericBaseUtility.BaseClass;

public class CreateOrgTest extends BaseClass {

	@Test(groups = "smoke Test")
	public void createContact() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		System.out.println("execute CreateOrgwith Industry");
		// step1 login to app in basaclass
		// read data from Excel
		String orgName = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();

		// step2: navigate to Organization module*/
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Organization module");
		HomePage Hp = new HomePage(driver);
		Hp.getOrgLink().click();

		// step3: Click on create org Button
		UtilityClassObject.getTest().log(Status.INFO, "click on create new org Button");
		OrgnizationsPage org = new OrgnizationsPage(driver);
		org.getCreatenewOrg().click();

		// step4: enter all the details to create newORg
		UtilityClassObject.getTest().log(Status.INFO, "create new org ");
		CreatNOrgPg Cnp = new CreatNOrgPg(driver);
		Cnp.getCreateNOrg(orgName);

		// Step5: Verify HeaderMsg
		UtilityClassObject.getTest().log(Status.INFO, "Verify Msg");
		OrganizationinfoPage oip = new OrganizationinfoPage(driver);
		String actorgName = oip.getHeaderMsg().getText();
		if (actorgName.contains(orgName)) {
			System.out.println(orgName + "Name is Verified ==PASS");

		} else {
			System.out.println(orgName + "Name is not Verified ==Fail");
		}
	}

	@Test(groups = "regressionTest")
	public void CreateorgwithPhoneNo() throws Throwable {
		System.out.println("Create Organisationwithind and Verify");
		// read Data from excel
		String orgName = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();
		String phoneNumber = elib.getDataFromExcel("Org", 7, 3) + jlib.getRandomNumber();
		// step1: navigate to Organization module*/
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step3: Click on create org Button
		OrgnizationsPage org = new OrgnizationsPage(driver);
		org.getCreatenewOrg().click();

		// step4: enter all the details to create newORg
		CreatNOrgPg cnor=new CreatNOrgPg(driver);
		cnor.getCreateOrgpn(orgName, phoneNumber);
		// verify the PhoneNo

		String actphoneNumber = driver.findElement(By.id("dtlview_Phone")).getText();
		if (actphoneNumber.equals(phoneNumber)) {
			System.out.println(phoneNumber + "info is verified");
		} else

		{
			System.out.println(phoneNumber + "info is nont verified");
		}
	
		

	}

}
