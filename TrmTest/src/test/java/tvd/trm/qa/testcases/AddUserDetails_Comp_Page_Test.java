package tvd.trm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import tvd.trm.qa.base.Testbase;
import tvd.trm.qa.pages.AddUserDetails_Comp_Page;
import tvd.trm.qa.pages.Homepage;
import tvd.trm.qa.pages.Loginpage;
import tvd.trm.qa.util.Testutil;

public class AddUserDetails_Comp_Page_Test extends Testbase {
	public Homepage homepage;
	public Loginpage loginpage;
	public AddUserDetails_Comp_Page Adduserdetailscomppage;
	public Testutil testutil;

	String sheetname = "Adduserdetails_Comp_Level";

	public AddUserDetails_Comp_Page_Test() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialisation();
		homepage = new Homepage();
		loginpage = new Loginpage();
		testutil = new Testutil();
		Adduserdetailscomppage = new AddUserDetails_Comp_Page();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"),
				prop.getProperty("role"));
		Adduserdetailscomppage = homepage.Add_User_Details();
	}

	@Test(enabled = false)
	public void CaptureTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "TVDMaste Page", "===========Title not matched=========");
	}

	@Test(enabled = false)
	public void Capturetext() {
		String Text = Adduserdetailscomppage.Capturetext();
		Assert.assertEquals(Text, "ADD USER DETAILS", "=========Text not Matched===========");
	}

	@DataProvider
	public Object[][] Getdata() {
		Object data[][] = Testutil.GetTestData(sheetname);
		return data;
	}

	@Test(dataProvider = "Getdata")

	public void Adduserdetailscomplevel(String SelectLevel, String GroupName, String UserName, String Password,
			String Emailid, String MobileNo) {
		Adduserdetailscomppage.Selectlevel(SelectLevel);
		Adduserdetailscomppage.Selectgrupname(GroupName);
		Adduserdetailscomppage.Selectusername(UserName);
		Adduserdetailscomppage.Selectpassword(Password);
		Adduserdetailscomppage.SelectEmailid(Emailid);
		Adduserdetailscomppage.Selectmobilename(MobileNo);
		Adduserdetailscomppage.ClickonAddapprovalbutton();
	}

	@AfterMethod
	public void tearup() {
		driver.close();
	}

}
