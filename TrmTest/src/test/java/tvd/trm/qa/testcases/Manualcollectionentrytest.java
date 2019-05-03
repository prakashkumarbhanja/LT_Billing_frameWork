package tvd.trm.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import tvd.trm.qa.base.Testbase;
import tvd.trm.qa.pages.Homepage;
import tvd.trm.qa.pages.Loginpage;
import tvd.trm.qa.pages.Manualcollectionentrypage;
import tvd.trm.qa.util.Testutil;

public class Manualcollectionentrytest extends Testbase {
	public static Loginpage loginpage;
	public static Homepage homepage;
	public static Manualcollectionentrypage manualcolpage;

	// sheet name
	static String sheetname = "Manual_Collection_Entry";

	public Manualcollectionentrytest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		// HOW I ABLE TO CALL THE INITIALISATION() METHOD DIRECTLY WITH OUT
		// OBJECT OR CLASS NAME
		// ANS:- AS BECAUSE OF I HAVE EXTEND THE BASE CLASS IN WHICH
		// INITIALISATION() METHOD IS THERE SO I CAN DIRECTLY CALL THE METHOD
		// WITHOUT HELP OF NOTHING. "I CAN CALL METHOD() BY THE HELP OF OBJECT
		// OF BASE CLASS ALSO"
		initialisation();
		// This ::--"Loginpage loginpage=new Loginpage();" is mandatory
		loginpage = new Loginpage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"),
				prop.getProperty("role"));
		manualcolpage = homepage.clickonmanualcollectionentry();
	}

	@Test(priority = 1)
	public void verifythelevel() {
		String name = manualcolpage.checkmanualcollectionentry();
		System.out.println("========The LEVEL is========" + name);
		Assert.assertEquals(name, "Manual Collection Entry", "Manual collectiom entry page is not displayed");
	}

	@DataProvider
	// public void getdataof_Manualcollectionentry() throws
	// EncryptedDocumentException, IOException
	public Object[][] getdataof_Manualcollectionentry() throws EncryptedDocumentException, IOException {
		Object data[][] = Testutil.GetTestData(sheetname);
		return data;
	}

	@Test(priority = 2, dataProvider = "getdataof_Manualcollectionentry")

	// HERE THE NAME WHICH I HAVE WRITTEN INSIDE THE
	// fill_the_form(consumerno,COUNTER,RECEIPTNO,TOWORDS,AMOUNT) METHOD IT
	// SHOULD BE SAME AS
	// THE NAME WRITE ON EXCEL THEN PASS THE SAME NAME TO THE DOWNSIDE.....>>

	public void fill_the_form(String consumerno, String counter, String receiptno, String towords, String amount) {
		System.out.println("====The value of Consumerno===" + consumerno);
		System.out.println("====The value of counter===" + counter);
		System.out.println("====The value of receiptno===" + receiptno);
		System.out.println("====The value of towords===" + towords + "===  AMOUNT ===" + amount);
		manualcolpage.enter_consid(consumerno);
		manualcolpage.setthecounter(counter);
		manualcolpage.enterreceiptno(receiptno);
		manualcolpage.choosethedate();
		manualcolpage.chhose_Towords(towords);
		manualcolpage.enteramount(amount);
		manualcolpage.click_on_radiobotton();
		manualcolpage.search_collectionentry();
	}
	@Test(priority=3)
	public void Fetch_Collection_Entry()
	{
		String Fetchdata=manualcolpage.search_collectionentry();
		System.out.println("===Fetch Data Is==="+Fetchdata);
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
