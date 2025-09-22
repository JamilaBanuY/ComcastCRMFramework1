package Practice.TESTNG;

import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.crm.GenericBaseUtility.BaseClass;
/**
 * test class for Contact module
 * @author class for contact module
 * 
 */
public class CodingStarndard extends BaseClass {
	/**
	 * Scenario:Login()==navigateontact
	 */
	@Test
	public void SearchContactTest()
	{
		/*Step1: login to application*/
		LoginPage lp=new LoginPage(driver);
		lp.logintoApp("url", "username", "password");
		
		
		
	}

}
