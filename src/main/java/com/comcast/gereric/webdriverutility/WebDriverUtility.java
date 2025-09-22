package com.comcast.gereric.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

public void getImplicitwait(WebDriver driver) {
    
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 }

public void getexpWait(WebDriver driver, WebElement ele)
{
	WebDriverWait wait= new WebDriverWait(driver,  Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOf(ele));
}

public void switchnewBrowserTab(WebDriver driver, String partialUrl)
{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String winid = it.next();
			driver.switchTo().window(winid);
			
			String actUrl = driver.getCurrentUrl();
			
			if(actUrl.contains(partialUrl))
			{
				break;
			}
		}
}

public void switchtoTabonTitle(WebDriver driver, String partialTitle)
{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String winid = it.next();
			driver.switchTo().window(winid);
			
			String actUrl = driver.getTitle();
			
			if(actUrl.contains(partialTitle))
			{
				break;
			}
		}
}


public void switchtohomeFrame(WebDriver driver, int index)
{driver.switchTo().frame(index);
}

public void switchtoFrame(WebDriver driver, String nameId)
{driver.switchTo().frame(nameId);
}
public void switchtoFrame(WebDriver driver, WebElement ele)

{
	driver.switchTo().frame(ele);
	
}
public void switchtoAlertandaccept(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
public void switchtoAlertanddismiss(WebDriver driver)
{driver.switchTo().alert().dismiss();
}
public void SelectbyVT(WebElement ele, String text)
{
	Select s=new Select(ele);
	s.selectByVisibleText(text);
}
public void selectByindex(WebElement ele, int Index)
{
	Select S=new Select(ele);
	S.selectByIndex(Index);
}
public void select(WebElement ele, String opt)
{Select s=new Select(ele);
List<WebElement> opts = s.getOptions();
	for(WebElement o:opts)
	{System.out.println(o);
	}
}
public void mousemoveon(WebDriver driver, WebElement ele)
{
	Actions act=new Actions(driver);
	act.moveToElement(ele).perform();
}
public void doubleClick(WebDriver driver, WebElement ele)
{Actions act=new Actions(driver);
		act.doubleClick(ele).perform();
		}
}