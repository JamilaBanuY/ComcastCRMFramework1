package Practice.TESTNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactDataProvider1 {
	@Test(dataProvider = "getData")
	public void createcontacttest(String FirstN, String LastN) {
		System.out.println("FirstName :" + FirstN + ", LastName :" + LastN);

	}

@DataProvider 
public Object[][] getData()
{
	Object[][] objarr=new Object[3][2];
	objarr[0][0]="Jamila";
	objarr[0][1]="SE";
	objarr[1][0]="Banu";
	objarr[1][1]="TE";
	objarr[2][0]="Jamila";
	objarr[2][1]="QA";
	return objarr;
}

}
