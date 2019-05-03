package tvd.trm.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import tvd.trm.qa.base.Testbase;
import tvd.trm.qa.pages.Homepage;
import tvd.trm.qa.pages.Loginpage;
import tvd.trm.qa.pages.Lt_billingpage;
import tvd.trm.qa.util.Testutil;

public class Lt_billingtest extends Testbase {
	// object creation
	public static Loginpage loginpage;
	public static Homepage homepage;
	public static Lt_billingpage ltbillingpag;
	public static Testutil testutil;

	String excelsheetname = "540038";

	public Lt_billingtest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		// Initialisation

		initialisation();
		loginpage = new Loginpage();
		ltbillingpag = new Lt_billingpage();
		testutil = new Testutil();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"),
				prop.getProperty("role"));
		homepage.mousehoveronconsumerbill();
		ltbillingpag = homepage.clickonltbilling();
		
		// loginpage.selectadmin();
	}

	@Test(enabled=false)
	public void compnamelable() {
		boolean sampleofcompa_name_lebel = ltbillingpag.compnamelable();
		Assert.assertTrue(sampleofcompa_name_lebel,"Not displayed");
	}
	
	@DataProvider
	public Object[][] getAccountidTestdata() throws EncryptedDocumentException, IOException
	{
		Object data[][] = Testutil.GetTestData(excelsheetname);
		return data;
	}

	@Test(dataProvider = "getAccountidTestdata")
	public void Ltbill(String ACCOUNT_ID,String PRESENT_READING) {
		System.out.println("=======The account id is===>>>"+ACCOUNT_ID);
		System.out.println("=======The Present reading is====>>>"+PRESENT_READING);
		ltbillingpag.Ltbill(ACCOUNT_ID, PRESENT_READING);
	}

	/*// Write back the data into the excel file
	@Test(enabled=false )
	public void fetchcurrdg() {
		ltbilling.fetchtotaldmnd();
	}*/

	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
