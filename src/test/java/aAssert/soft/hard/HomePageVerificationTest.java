package aAssert.soft.hard;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomePageVerificationTest {
@Test
public void Homepgtest(Method mtd)
{
	System.out.println(mtd.getName()+ "Test Start");
	String ExpectedPage="Home";
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://49.249.28.218:8888/");
	
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	String actTitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
	if (actTitle.trim().equals(ExpectedPage))
			{System.out.println("pass");}
	else
	{System.out.println("fail");
	}}
	//driver.close();}

@Test
public void verityhomepgtest(Method mtd)

	{
	
	System.out.println(mtd.getName()+ "Test Start");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://49.249.28.218:8888/");
	
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	boolean status = driver.findElement(By.xpath("//img[@alt='vtiger-crm-logo.gif']")).isEnabled();
	if (status)
	
	{System.out.println("page is Verified=pass");}
	else
	{
		System.out.println("Page is not Verified-Fail");
	}
	//driver.close();
}
}

