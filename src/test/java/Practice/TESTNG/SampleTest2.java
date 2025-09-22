package Practice.TESTNG;

import org.testng.annotations.Test;

public class SampleTest2 {
@Test(invocationCount = 0)
public void createcontact()
{System.out.println("create contact");}

@Test(dependsOnMethods = "createcontact")
public void modifycontact()
{System.out.println("modifycontact");}

@Test(dependsOnMethods = "modifycontact")
public void deletecontact()
{System.out.println("deletecontact");}

}
