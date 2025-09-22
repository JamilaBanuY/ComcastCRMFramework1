package aAssert.soft.hard;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageSampleTestHardAssert {
@Test
public void homepgtest(Method mtd)
{System.out.println(mtd.getName()+"Test Start");
System.out.println("step1");
System.out.println("step2");
Assert.assertEquals("Home", "Home-Page");//try to fail TC HardAssert Skipped remaining TestCases
System.out.println("step3");
System.out.println("step4");
Assert.assertEquals("Home-CRM", "Home-CRM");
System.out.println(mtd.getName());
}
@Test
public void verifyLogoHomePagetest(Method mtd)
{System.out.println(mtd.getName()+"Test Start");
System.out.println("step1");
System.out.println("step2");
Assert.assertTrue(true);
System.out.println("step3");
System.out.println("step4");
Assert.assertEquals("Home-CRM", "Home-CRM");
System.out.println(mtd.getName());

}
}
