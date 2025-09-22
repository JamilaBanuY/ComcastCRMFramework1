package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpprtunitiesPG {
WebDriver driver;
public OpprtunitiesPG(WebDriver driver)
{
	this.driver=driver;
PageFactory.initElements(driver, this);
}

@FindBy(linkText="Opportunities")
private WebElement Opptlink;

@FindBy(xpath = "//img[@alt='Create Opportunity...']")
private WebElement CreateOppBtn;

@FindBy(name="potentialname")
private WebElement Oppname;

@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement SaveBtn;

@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
private WebElement Cropbtn;

@FindBy(xpath = "a//href='Amazon_1982']")
private WebElement existingOpplink;

@FindBy(xpath = "//input[@name='search_text']")
private WebElement Entertext;

public WebElement getEntertext() {
	return Entertext;
}

public WebElement getCropbtn() {
	return Cropbtn;
}

public WebElement getExistingOpplink() {
	return existingOpplink;
}

public WebElement getOpptlink() {
	return Opptlink;
}

public WebElement getCreateOppBtn() {
	return CreateOppBtn;
}

public WebElement getOppname() {
	return Oppname;
}

public WebElement getSaveBtn() {
	return SaveBtn;
}





}