package Practice.TESTNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ConfigAnnots {
	
	@BeforeSuite()
	public void BS()
	{
		System.out.println("BS");
	}
	@BeforeSuite(timeOut = 20)
	public void BS1()
	{
		System.out.println("BS1");
	}
	@BeforeClass( )
	public void BC()
	{
		System.out.println("execute BC");
	}
	
	@BeforeTest( )
	public void BT1()
	{
		System.out.println("execute BT1");
	}
	
	@BeforeClass
	public void BC1()
	{
		System.out.println("execute BC1");
	}
	
	@BeforeMethod
	public void BM()
	{
	System.out.println(("execute BM"));
	}
	@BeforeMethod()
	public void BM1()
	{
	System.out.println(("execute BM1"));
	}
	@Test
	public void cc()
	{
		System.out.println("execute Create Contact");
	}
	@Test
	public void ccd()
	{
		System.out.println("Create Organisation");
	}

	@AfterMethod
	public void AMa()
	{
		System.out.println("execute AMa");
	}
	@AfterMethod()
	public void AMb()
	{
		System.out.println("execute AMb");
	}
@AfterClass
	public void ACa()
	{
		System.out.println("ACa");
	}
@AfterClass
public void ACb()
{
	System.out.println("ACb");
}

@AfterTest()
public void AT1()
{
	System.out.println("At1");
}
	
	@AfterSuite()
	public void ASa()
	{System.out.println("ASa");}


@AfterSuite
public void ASb()
{System.out.println("ASb");}
}
