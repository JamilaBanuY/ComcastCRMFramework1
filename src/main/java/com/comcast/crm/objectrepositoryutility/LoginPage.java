package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Jamila
 * Contains Login page elements and business library like Login;
 */

public class LoginPage {//Rule-1 Create a separate Java Class
	// Rule-2 Object Creation
	WebDriver driver;
	public LoginPage(WebDriver driver) {
	this.driver=driver;
	 PageFactory.initElements(driver, this);}
	
	@FindBy(name="user_name")
	private WebElement Username;
	@FindBy(name="user_password")
	private WebElement Password;
	@FindBy(id="submitButton")
	private WebElement LoginBtn;
	
	public WebElement getUsername() {
		return Username;
	}
	public WebElement getPassword() {
		return Password;
	}
	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	/**
	 * login to application based on username, password and url
	 * @param url
	 * @param username
	 * @param password
	 */
	public void logintoApp(String url, String username, String password)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		driver.manage().window().maximize();
		Username.sendKeys(username);
		Password.sendKeys(password);
		LoginBtn.click();
	}

}
