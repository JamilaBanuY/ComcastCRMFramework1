package ListenerTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericBaseUtility.BaseClass;
import com.google.errorprone.annotations.FormatString;
@Listeners(com.comcast.crm.ListenerUtility.LisImpclass.class)
public class InvoiceTest extends BaseClass{
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
