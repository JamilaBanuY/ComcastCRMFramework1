package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPg {

	WebDriver driver;

	public CreateNewContactPg(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Creating New Contact
	@FindBy(xpath = "//span[.='Creating New Contact']")
	private WebElement createnewcon;
	
	@FindBy(name = "lastname")
	private WebElement lastname;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public void getcreatecontact(String lastName) {
		lastname.sendKeys(lastName);
		SaveBtn.click();
	}
}
