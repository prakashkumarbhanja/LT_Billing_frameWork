package tvd.trm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tvd.trm.qa.base.Testbase;
import tvd.trm.qa.pages.AddUserDetails_Comp_Page;
import tvd.trm.qa.pages.Generateticketpage;
import tvd.trm.qa.pages.Homepage;
import tvd.trm.qa.pages.Loginpage;
import tvd.trm.qa.pages.Userapprovalpage;
import tvd.trm.qa.util.Testutil;

public class UserapprovalTest extends Testbase {

	public Userapprovalpage approvalpage;
	public Homepage homepage;
	public Loginpage loginpage;
	public AddUserDetails_Comp_Page Adduserdetailscomppage;
	// public Userapprovalpage userapprovalpage;

	UserapprovalTest() {
		super();
	}

	@BeforeMethod
	public void initialise() {
		initialisation();
		loginpage = new Loginpage();
		approvalpage = new Userapprovalpage();
		homepage = new Homepage();
		Adduserdetailscomppage = new AddUserDetails_Comp_Page();
		approvalpage = new Userapprovalpage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"),
				prop.getProperty("role"));
		Adduserdetailscomppage = homepage.Add_User_Details();
		approvalpage = Adduserdetailscomppage.ClickonApproval();
	}

	@Test(priority = 1/*,enabled=false*/)
	public void CaptureTextTest() {
		String Text = approvalpage.Capturetext();
		Assert.assertEquals(Text, "User Approval/Reject", "Text not matched");
	}

	@Test(priority = 2)
	public void Click_on_Checkbox() {
		// approvalpage.Clickoncheckbox();
/*		if (approvalpage.Check_checkbox() != true) {
			approvalpage.Click_On_Checkbox();
			approvalpage.SelectApprove_Reject();
			approvalpage.ClickonSubmit();
		} else {
			System.out.println("===Check box already selected===");
		*/
		approvalpage.Click_On_Checkbox();
		approvalpage.SelectApprove_Reject();
		approvalpage.ClickonSubmit();
		//}

		Assert.assertTrue(true);
	}

	@AfterMethod
	public void Tearup() {
		driver.close();
	}

}
