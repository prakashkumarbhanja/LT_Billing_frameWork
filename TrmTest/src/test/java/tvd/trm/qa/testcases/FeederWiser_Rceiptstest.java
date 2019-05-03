package tvd.trm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tvd.trm.qa.base.Testbase;
import tvd.trm.qa.pages.Feederwise_Receiptspage;
import tvd.trm.qa.pages.Homepage;
import tvd.trm.qa.pages.Loginpage;
import tvd.trm.qa.util.Testutil;

public class FeederWiser_Rceiptstest extends Testbase {
	public static Feederwise_Receiptspage federwisereceipt;
	public static Homepage homepage;
	public static Loginpage loginpage;
	public static Testutil testutil;

	public FeederWiser_Rceiptstest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialisation();

		// This ::--"Loginpage loginpage=new Loginpage();" is mandatory

		Loginpage loginpage = new Loginpage();
		federwisereceipt = new Feederwise_Receiptspage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"),
				prop.getProperty("role"));
		federwisereceipt = homepage.click_on_FeederWise_Receipt_Details();

	}

	@Test(priority = 1)
	public void titletest() {
		String title = federwisereceipt.gettitle();
		Assert.assertEquals(title, "FeederWise Receipt Report", "Titlt is not matched");
	}

	@Test(priority = 2)
	public void federwisereceiptsdetailsleveltest() {
		String f = federwisereceipt.federwisereceiptsdetailslevel();
		Assert.assertEquals(f, "Feederwise Receipts");
	}

	@Test(priority = 3)
	public void mon_yyy_leveltest() {
		boolean flag = federwisereceipt.mon_yyy_level();
		Assert.assertTrue(flag);
	}

	@Test(priority = 4)
	public void fill_the_Feederwise_Reeipts_Details() {
		federwisereceipt.languagedropdown();
		federwisereceipt.click_on_dateicon();
		federwisereceipt.click_on_report();
		try {
			testutil.clickonpopup();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
