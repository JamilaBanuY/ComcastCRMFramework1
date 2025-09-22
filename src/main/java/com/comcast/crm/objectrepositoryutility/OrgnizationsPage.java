package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.gereric.webdriverutility.WebDriverUtility;

public class OrgnizationsPage {
WebDriver driver;
public OrgnizationsPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(name="search_text")
private WebElement searchEdt;

@FindBy(name="search")
private WebElement searchnow;

public WebElement getSearchnow() {
	return searchnow;
}

@FindBy(name="search_field")
private WebElement searchDD;

@FindBy(name="submit")
private WebElement SearchBtn;

@FindBy(xpath = "//a[@href='javascript:window.close();']")
private WebElement ornamelink;

public WebElement getSearchBtn() {
	return SearchBtn;
}
public WebElement getSearchEdt() {
	return searchEdt;
}
public WebElement getSearchDD() {
	return searchDD;
}
@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement CreatenewOrg;

public WebElement getCreatenewOrg() {
	return CreatenewOrg;
}
	public void getcreatenewOrg()
	{
		CreatenewOrg.click();
	}
	public void getSearchOrg(String Orgn)
	{
		WebDriverUtility n=new WebDriverUtility();
		n.getexpWait(driver, searchEdt);
	searchEdt.sendKeys(Orgn);
	searchnow.click();
	ornamelink.click();
	
	}
	}

