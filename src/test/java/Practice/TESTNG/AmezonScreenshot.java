package Practice.TESTNG;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class AmezonScreenshot {
@Test
public void amscreenshot() throws Throwable
{WebDriver driver=new ChromeDriver();
driver.get("https://www.amazon.in/");
EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
File src = edriver.getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(src, new File("./Screenshot/test.png"));
}

	@Test
	public void fkshot() throws Throwable
	{WebDriver driver=new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	//step1: Create an object to EventFiring webdriver
	EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
	//step2; Use GetScreenshotAs method to get file type of screenshot
	File src1 = edriver.getScreenshotAs(OutputType.FILE);
	//step3: store the Screenshoton local driver
	FileUtils.copyFile(src1, new File("./Screenshot/test2.png"));


}

}
