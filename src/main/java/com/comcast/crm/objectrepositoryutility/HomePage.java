package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{
WebDriver driver;
public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
@FindBy(linkText = "Organizations")
private WebElement orgLink;

@FindBy(linkText = "Contacts")
private WebElement ContactLink;

@FindBy(linkText = "Campaign")
private WebElement Campaignlink;
 
@FindBy(linkText = "More")
private WebElement Morelink;

@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
private WebElement Signoutimg;

@FindBy(linkText = "Sign Out")
private WebElement signoutlink;


public WebElement getSignoutlink() {
	return signoutlink;
}



public WebElement getCampaignlink() {
	return Campaignlink;
}



public WebElement getMorelink() {
	return Morelink;
}



public WebElement getOrgLink() {
	return orgLink;
}



public WebElement getContactLink() {
	return ContactLink;
}

public void navigatetoCampaignpg()
{
	Actions act=new Actions(driver);
	act.moveToElement(Morelink).perform();
	Campaignlink.click();
	
}
public void Logout()
{
	Actions act1=new Actions(driver);
	act1.moveToElement(Signoutimg).perform();
	signoutlink.click();
}


}
