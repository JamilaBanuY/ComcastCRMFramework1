package ListenerTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.GenericBaseUtility.BaseClass;

public class InvoiceTestbyxml extends BaseClass {
	@Test
	public void createInvoiceTest()
	{System.out.println("execute createInvoiceTest");
	String ActTitle = driver.getTitle();
	Assert.assertEquals("ActTitle", "Login");//intentionally failing Test Case
	System.out.println("Step1");
	System.out.println("Step2");
	System.out.println("Step3");
	System.out.println("Step4");
	//String ActTitle = driver.getTitle();
	//Assert.assertEquals("ActTitle", "Login");//intentionally failing Test Case
//Run in suite will get old Screenshot (backup) and new Screenshot with timeStamp; 

	}

	@Test
	public void createInvoicewithContactTest()
	{System.out.println("execute createInvoicewithContactTests");
	System.out.println("Step1");
	System.out.println("Step2");
	System.out.println("Step3");
	System.out.println("Step4");

	}


	
}
