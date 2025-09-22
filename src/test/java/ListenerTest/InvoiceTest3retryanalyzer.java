package ListenerTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.GenericBaseUtility.BaseClass;

public class InvoiceTest3retryanalyzer extends BaseClass {
	@Test(retryAnalyzer = com.comcast.crm.ListenerUtility.RetryListenerImp.class)
	public void createInvoiceTest() {
		System.out.println("execute createInvoiceTest");
		String ActTitle = driver.getTitle();
		Assert.assertEquals("ActTitle", "Login");// intentionally failing Test Case
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		System.out.println("Step4");
	}
}