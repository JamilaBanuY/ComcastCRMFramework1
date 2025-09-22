package Practice.TESTNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.genric.fileutility.ExcelUtility;

public class GetProdinfoTestDP2 {
	@Test(dataProvider = "getData") 
	public void getprodinfo(String brandName, String ProdName) throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName, Keys.ENTER);

		String x = "//span[text()='" + ProdName + "']/../../../../div[3]/div/div/div/div/div/a/span/span/span[2]";

		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
	}

	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility elib = new ExcelUtility();
		int rowCount = elib.getRowCount("Product");
		
		Object[][] objarr = new Object[rowCount][2];
		
		for(int i=0; i<rowCount; i++) {
		objarr[i][0] = elib.getDataFromExcel("Product", i+1, 0);
		objarr[i][1] = elib.getDataFromExcel("Product", i+1, 1);
		}
		return objarr;
	
	}
}
