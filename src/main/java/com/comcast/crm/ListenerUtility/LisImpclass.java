package com.comcast.crm.ListenerUtility;

import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.gereric.webdriverutility.UtilityClassObject;
import com.crm.GenericBaseUtility.BaseClass;

public class LisImpclass implements ITestListener, ISuiteListener {
	public static ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
		 String time = new Date().toString().replace(" ", "_").replace(":", "_");
		// spark Report Config
				 spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
				spark.config().setDocumentTitle("CRM Test Suite Results");
				spark.config().setReportName("CRM Report");
				spark.config().setTheme(Theme.DARK);
				// add Env information and create test

				report = new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("os", "windows-11");
				report.setSystemInfo("BROWSER", "Chrome-100");
	}

	public void onFinish(ISuite suite) {
		System.out.println("Report Backup");
		report.flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println("====>" + result.getMethod().getMethodName() + "==========>");
	test=report.createTest(result.getMethod().getMethodName());
	UtilityClassObject.setTest(test);
	test.log(Status.INFO, result.getMethod().getMethodName()+"START");
	
	
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("====>" + result.getMethod().getMethodName() + "==========>");
		test.log(Status.PASS, result.getMethod().getMethodName()+"COMPLETED");//to display Msg will execute automatically
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Screenshot ");
		String testName = result.getMethod().getMethodName();

		TakesScreenshot ts=(TakesScreenshot) BaseClass.sdriver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		//EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		//File src1 = edriver.getScreenshotAs(OutputType.FILE);
		 String time = new Date().toString().replace(" ", "_").replace(":", "_");
		 test.addScreenCaptureFromBase64String(filePath, testName+"-"+time);
		 test.log(Status.FAIL, result.getMethod().getMethodName()+"FAILED");
	}

}