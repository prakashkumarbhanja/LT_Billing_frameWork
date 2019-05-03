package tvd.trm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tvd.trm.qa.base.Testbase;

public class AddUserDetails_Comp_Page extends Testbase {
	@FindBy(xpath = "//span[text()='ADD USER DETAILS']")
	WebElement Adduserdetails_Text;
	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlselect")
	WebElement Select_level;
	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlCompany")
	WebElement Select_Company;
	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlZone")
	WebElement Select_Zone;
	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlCircle")
	WebElement Select_Circle;
	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlDivision")
	WebElement Select_Divisuion;
	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlgroupname")
	WebElement Select_Groupname;
	@FindBy(name = "ctl00$ContentPlaceHolder1$txtusername")
	WebElement Enter_Username;
	@FindBy(name = "ctl00$ContentPlaceHolder1$txtPass")
	WebElement Enter_Password;
	@FindBy(name = "ctl00$ContentPlaceHolder1$txtemail")
	WebElement Enter_Emailid;
	@FindBy(name = "ctl00$ContentPlaceHolder1$txtmobile")
	WebElement Enter_Mobileno;
	@FindBy(name = "ctl00$ContentPlaceHolder1$btnAdd")
	WebElement AddToApproval_Button;
	@FindBy(name = "ctl00$ContentPlaceHolder1$btnapprej")
	WebElement UserInfoForApproval;

	@FindBy(name = "ctl00$ContentPlaceHolder1$btnapprej")
	WebElement UserinfoForApproval;

	public AddUserDetails_Comp_Page() {
		PageFactory.initElements(driver, this);
	}

	public String Capturetext() {
		return Adduserdetails_Text.getText();
	}

	public void Selectlevel(String level) {
		Select se = new Select(Select_level);
		se.selectByVisibleText(level);
		// se.deselectByIndex(1);
	}

	public void Selectcompany() {
		Select se1 = new Select(Select_Company);
		se1.selectByVisibleText("Hubli Electricity Supply Company Limited");
	}

	public void Selectgrupname(String Groupname) {
		Select se2 = new Select(Select_Groupname);
		se2.selectByVisibleText(Groupname);
	}

	public void Selectusername(String Username) {
		Select se3 = new Select(Enter_Username);
		se3.selectByVisibleText(Username);
	}

	public void Selectpassword(String PassWord) {
		Select se4 = new Select(Enter_Password);
		se4.selectByVisibleText(PassWord);;
	}

	public void SelectEmailid(String EmailId) {
		Select se5 = new Select(Enter_Emailid);
		se5.selectByVisibleText(EmailId);
	}

	public void Selectmobilename(String Mobileno) {
		Select se6 = new Select(Enter_Mobileno);
		se6.selectByVisibleText(Mobileno);
	}

	public void ClickonAddapprovalbutton() {
		AddToApproval_Button.click();
	}

	public Userapprovalpage ClickonApproval() {
		UserinfoForApproval.click();
		return new Userapprovalpage();
	}
}
