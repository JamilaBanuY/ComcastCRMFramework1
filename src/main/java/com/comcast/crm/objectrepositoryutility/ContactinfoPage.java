package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactinfoPage {

	WebDriver driver;
	public ContactinfoPage(WebDriver driver)
	{this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "lastname")
	private WebElement lastname;


	@FindBy(name = "support_start_date")
	private WebElement Startdate;

	@FindBy(name = "support_end_date")
	private WebElement enddate;


	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
		public WebElement getStartdate() {
		return Startdate;
	}


	public WebElement getEnddate() {
		return enddate;
	}

	public WebElement getLastName() {
		return lastname;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public void getdates(String lastname, String startdate, String enddt)
	{
		getLastName().sendKeys(lastname);
		getStartdate().clear();
		getStartdate().sendKeys(startdate);
		getEnddate().clear();
		getEnddate().sendKeys(enddt);
		getSaveBtn().click();
	}
	
	
}
