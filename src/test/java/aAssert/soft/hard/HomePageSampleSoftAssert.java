package aAssert.soft.hard;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleSoftAssert {
@Test

	public void homepgtest(Method mtd)
	{System.out.println(mtd.getName()+"Test Start");
	SoftAssert obj=new SoftAssert();
	System.out.println("step1");
	System.out.println("step2");
	obj.assertEquals("Home", "Home-Page");//try to fail TC useSoftAssert even though Testcase is failed all steps will get executed
	System.out.println("step3");
	System.out.println("step4");
	obj.assertEquals("Home-CRM", "Home-CRM");
	obj.assertAll();                                             //use assertAll to print exception also it will fail the testcase
	System.out.println(mtd.getName());
	}
	@Test
	public void verifyLogoHomePagetest(Method mtd)
	{System.out.println(mtd.getName()+"Test Start");
	SoftAssert obj=new SoftAssert();
	System.out.println("step1");
	System.out.println("step2");
	obj.assertTrue(true);                       //softassert
	System.out.println("step3");
	System.out.println("step4");
	Assert.assertEquals("Home-CRM", "Home-CRM"); //hardassert we can use both soft and hard assert
	obj.assertAll();
	System.out.println(mtd.getName());

	}
}