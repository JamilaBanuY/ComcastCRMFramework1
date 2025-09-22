package extentreports.scripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Sample1Reporttest1 {
	@Test

	public void createContactTest() {

		// spark Report Config
				ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
				spark.config().setDocumentTitle("CRM Test Suite Results");
				spark.config().setReportName("CRM Report");
				spark.config().setTheme(Theme.DARK);
				// add Env information and create test

				ExtentReports report = new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("os", "windows-11");
				report.setSystemInfo("BROWSER", "Chrome-100");
		ExtentTest test = report.createTest("createcontactTest");
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact");
		test.log(Status.INFO, "create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.log(Status.FAIL, "contact not created");
		}
		
	}
}
