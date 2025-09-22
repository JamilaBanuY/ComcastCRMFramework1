package com.comcast.crm.objectrepositoryutility;

import java.awt.print.PageFormat;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateQuickOrgDD {

	
		WebDriver driver;
		public CreateQuickOrgDD(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="qccombo")
		private WebElement QcuikcrtBtn;
		
		 @FindBy(xpath="//input[@name='accountname']")
		private WebElement orgNameEdt;
		 
		 @FindBy (xpath = "//input[@title='Save [Alt+S]']")
			private WebElement SaveBtn;
		 public WebElement getSaveBtn() {
				return SaveBtn;}
		
		
		public WebElement getOrgNameEdt() {
			return orgNameEdt;
		}

		public WebElement getQcuikcrtBtn() {
			return QcuikcrtBtn;}
						
		
			public void selectoptDD(String newName)
			{
				
				Select S=new Select(QcuikcrtBtn);
				S.selectByVisibleText(newName);
			
			}
			public void enterOrgname(String OrgName)
			{
				getOrgNameEdt().sendKeys(OrgName);
				getSaveBtn().click();
			}
			
		}
		
		
	


