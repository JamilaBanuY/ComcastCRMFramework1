package Practice.TESTNG;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTest {
@Test(dependsOnMethods = "banana", priority = 2)
public void chiku()
{
	System.out.println("chiku");
}

@Test(priority = 3)
public void banana()
{System.out.println("banana");
	}

@Test(invocationCount = 1, priority = 1)
public void Apple()
{System.out.println("Apple2");
WebDriver driver=new ChromeDriver();
driver.get("https://www.flipkart.com/");
WebElement ele = driver.findElement(By.xpath("//div[@class='_1wE2Px']"));
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
wait.until(ExpectedConditions.visibilityOf(ele));
	}

}
