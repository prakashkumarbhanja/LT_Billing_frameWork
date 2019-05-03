package tvd.trm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import tvd.trm.qa.base.Testbase;
import tvd.trm.qa.pages.AddUserDetails_Comp_Page;
import tvd.trm.qa.pages.Edit_Existing_User_page;
import tvd.trm.qa.pages.Homepage;
import tvd.trm.qa.pages.Loginpage;
import tvd.trm.qa.pages.Userapprovalpage;
import tvd.trm.qa.util.Testutil;

public class Edit_Existing_User_page_Test extends Testbase {

	public String sheetname = "Edit_Existing_User";
	public Homepage homepage;
	public Loginpage loginpage;
	public AddUserDetails_Comp_Page Adduserdetailscomppage;
	public Userapprovalpage approvalpage;
	public Edit_Existing_User_page editexistinguserpage;
	public Testutil testutil;

	@BeforeMethod
	public void Setup() {
		initialisation();
		homepage = new Homepage();
		loginpage = new Loginpage();
		approvalpage = new Userapprovalpage();
		testutil = new Testutil();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"),
				prop.getProperty("role"));
		Adduserdetailscomppage = homepage.Add_User_Details();
		approvalpage = Adduserdetailscomppage.ClickonApproval();
		editexistinguserpage = approvalpage.Move_Control_to_Editexistinguser();
	}

	/*@Test(priority = 1, enabled = false)
	public void UserdetailsText_Test() {
		String actualtext = editexistinguserpage.Verify_UpdateuserdatilsText();
		Assert.assertEquals(actualtext, "Update User Details", "=== TEXT Not Getting Matched===");
	}*/

	@DataProvider
	public Object[][] GetTestdata() {
		Object data[][] = Testutil.GetTestData(sheetname);
		return data;
	}

	@Test(priority = 2, dataProvider = "GetTestdata"/* , enabled = false */)
	public void UpdateUserdetails(String Username, String Password, String Groupname, String Accountstatus,
			String Subdivision, String Emailid, String Mobileno) {
		editexistinguserpage.Choose_Username(Username);
		editexistinguserpage.Fillthe_PAssword(Password);
		editexistinguserpage.Choose_Groupname(Groupname);
		editexistinguserpage.Choose_Account_Status(Accountstatus);
		editexistinguserpage.Choose_Subdivision(Subdivision);
		editexistinguserpage.Enter_Emailid(Emailid);
		editexistinguserpage.Enter_Mobileno(Mobileno);
		editexistinguserpage.Update_Button();
		editexistinguserpage.Delete_Button();
		editexistinguserpage.Clear_Button();
		editexistinguserpage.Back_Button();
	}

	@AfterMethod
	public void TearUp() {
		driver.close();
	}

}
