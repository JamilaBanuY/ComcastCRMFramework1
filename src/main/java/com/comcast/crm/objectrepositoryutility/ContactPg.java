package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPg {
	WebDriver driver;
	public ContactPg(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getContactLink() {
		return ContactLink;
	}

	public WebElement getContactBtn() {
		return ContactBtn;
	}
	@FindBy(className="dvHeaderText")
	private WebElement headertext;

		public WebElement getHeadertext() {
		return headertext;
	}
		@FindBy(linkText = "Contacts")
	private WebElement ContactLink;

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement ContactBtn;
	
	public void getCreatenewcontact()
	{
		ContactBtn.click();
	}
	
}