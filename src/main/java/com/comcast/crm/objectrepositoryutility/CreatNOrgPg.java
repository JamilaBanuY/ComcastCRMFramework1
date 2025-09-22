package com.comcast.crm.objectrepositoryutility;

import java.util.PrimitiveIterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatNOrgPg {

	WebDriver driver;

	public CreatNOrgPg(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement orgNameEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	@FindBy(name = "industry")
	private WebElement industryDB;

	@FindBy(id = "phone")
	private WebElement Phoneno;

	public WebElement getPhoneno() {
		return Phoneno;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public void getCreateOrgpn(String orgName, String phoneNumber) {
		orgNameEdt.sendKeys(orgName);
		Phoneno.sendKeys(phoneNumber);
		SaveBtn.click();
	}

	public void getCreateOrgI(String orgName, String industry) {
		orgNameEdt.sendKeys(orgName);
		Select sel = new Select(industryDB);
		sel.selectByVisibleText(industry);
		SaveBtn.click();
	}

	public void getCreateNOrg(String orgName)
				{
			orgNameEdt.sendKeys(orgName);
			SaveBtn.click();
				}
	
	
	
}
