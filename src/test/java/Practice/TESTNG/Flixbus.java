package Practice.TESTNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Flixbus {
@Test
public void bookticket()
{
	ChromeOptions opt=new ChromeOptions();
	opt.addArguments("--disable--otifiation");
WebDriver driver=new ChromeDriver(opt);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.manage().window().maximize();
driver.get("https://www.flixbus.in/");
driver.findElement(By.xpath("//button[.='Accept All'}")).click();



	
	
	
	
}
}
