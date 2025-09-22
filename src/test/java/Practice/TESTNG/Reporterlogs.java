package Practice.TESTNG;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Reporterlogs {
	@Test

	public void homepgtest(Method mtd)
	{Reporter.log(mtd.getName()+"Test Start");
	SoftAssert obj=new SoftAssert();
	Reporter.log("step1", true);// this will get printed in console if TRUE
	Reporter.log("step2", true);
	obj.assertEquals("Home", "Home");//try to fail TC useSoftAssert even though Testcase is failed all steps will get executed
	Reporter.log("step3", true);
	Reporter.log("step4", true);
	obj.assertAll(); 
	obj.assertEquals("Home-CRM", "Home-CRM");
	                                            //use assertAll to print exception also it will fail the testcase
	System.out.println(mtd.getName());
	}
	@Test
	public void verifyLogoHomePagetest(Method mtd)
	{Reporter.log(mtd.getName()+"Test Start");
	SoftAssert obj=new SoftAssert();
	Reporter.log("step1");
	Reporter.log("step2");
	obj.assertTrue(true);                       //softassert
	Reporter.log("step3");
	Reporter.log("step4");
	Assert.assertEquals("Home-CRM", "Home-CRM"); //hardassert we can use both soft and hard assert
	obj.assertAll();
	Reporter.log(mtd.getName());

	}
}
