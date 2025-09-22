package extentreports.scripts;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ERAttachScreenshot {
	ExtentSparkReporter spark;
	ExtentReports report; // created Global Variable

	@BeforeSuite
	public void BS() {
		// spark Report Config
		 spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
	
		// add Env information and create test

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "windows-11");
		report.setSystemInfo("BROWSER", "Chrome-100");
	}
	@Test

	public void createContactTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://49.249.28.218:8888/");
		//step to take Screenshot
		TakesScreenshot ts=(TakesScreenshot) driver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		
 		ExtentTest test = report.createTest("createcontactTest");
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact");
		test.log(Status.INFO, "create contact");
		if ("HDFCdd".equals("HDFC")) {
			test.log(Status.PASS, "contact is created with Date");
		} else {
			test.log(Status.FAIL, "contact not created");
			test.addScreenCaptureFromBase64String(filePath, "ErrorFile");
		}
		driver.close();
		report.flush();
		
	}
}
