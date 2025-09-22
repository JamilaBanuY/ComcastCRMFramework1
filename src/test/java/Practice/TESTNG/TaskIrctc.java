package Practice.TESTNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class TaskIrctc {

	@Test
	public void test()
	
	{
		ChromeOptions opts=new ChromeOptions();
		opts.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(opts);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().window().maximize();
	driver.get("https://www.irctc.co.in/nget/train-search");
	driver.findElement(By.xpath("//button[.='OK']")).click();
	//driver.findElement(By.xpath("(//input[@aria-autocomplete='list'])[1]")).sendKeys("Mumbai");
	driver.findElement(By.xpath("//input[@aria-controls='pr_id_1_list']")).sendKeys("Mumbai");
	//driver.findElement(By.xpath("(//input[@aria-autocomplete='list'])[2]")).sendKeys("Delhi");
	driver.findElement(By.xpath("//input[@aria-controls='pr_id_2_list']")).sendKeys("Delhi");	
	driver.findElement(By.xpath("//p-calendar[@id='jDate']")).click();
	driver.findElement(By.xpath("//span[@class='ui-datepicker-next-icon pi pi-chevron-right ng-tns-c59-10']")).click();
	driver.findElement(By.xpath("//a[.='30']")).click();
	
	//driver.close();	
		}
	}
