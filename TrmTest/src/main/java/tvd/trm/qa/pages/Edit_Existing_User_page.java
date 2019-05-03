package tvd.trm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import tvd.trm.qa.base.Testbase;

public class Edit_Existing_User_page extends Testbase {
	@FindBy(id = "ctl00_ContentPlaceHolder1_Label8")
	WebElement UpdateUserDetails_Text;
	@FindBy(name = "ctl00$ContentPlaceHolder1$ddluser")
	WebElement Select_Username;
	@FindBy(name = "ctl00$ContentPlaceHolder1$txtpass")
	WebElement Enter_Password;
	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlgrp")
	WebElement Select_Groupname;
	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlaccst")
	WebElement Select_AccountStatus;
	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlsub")
	WebElement Select_Subdivision;
	@FindBy(name = "ctl00$ContentPlaceHolder1$txteml")
	WebElement Enter_Mailid;
	@FindBy(name = "ctl00$ContentPlaceHolder1$txtmob")
	WebElement Enter_Mobileno;
	@FindBy(name = "ctl00$ContentPlaceHolder1$btnMod")
	WebElement Update_Button;
	@FindBy(name = "ctl00$ContentPlaceHolder1$btndel")
	WebElement Delete_Button;
	@FindBy(name = "ctl00$ContentPlaceHolder1$btnclear")
	WebElement Clear_Button;
	@FindBy(xpath = "//a[text()='Back']")
	WebElement Back_Button;

	public Edit_Existing_User_page() {

		PageFactory.initElements(driver, this);
	}

	public String Verify_UpdateuserdatilsText() {
		return UpdateUserDetails_Text.getText();
	}

	public void Choose_Username(String username) {
		Select sel = new Select(Select_Username);
		sel.selectByVisibleText(username);
		java.util.List<WebElement> usernameoptions = sel.getOptions();
		int size = usernameoptions.size();
		System.out.println("=== The total no of Username===" +  size);
		for (WebElement dd : usernameoptions) {
			System.out.println(dd.getText());
		}
	}

	public void Fillthe_PAssword(String password) {
		Enter_Password.sendKeys(password);
	}

	public void Choose_Groupname(String groupname) {

		Select sel1 = new Select(Select_Groupname);
		sel1.selectByVisibleText(groupname);
		java.util.List<WebElement> groupoptions = sel1.getOptions();
		int groupsize = groupoptions.size();
		System.out.println("===Group size is==="+  groupsize);
		for (WebElement dd : groupoptions) {
			System.out.println(dd.getText());
		}
	}

	public void Choose_Account_Status(String status) {
		Select sel2 = new Select(Select_AccountStatus);
		sel2.selectByVisibleText(status);
	}

	public void Choose_Subdivision(String accountstatus) {
		Select sel3 = new Select(Select_AccountStatus);
		sel3.selectByVisibleText(accountstatus);
		// sel3.selectByIndex(1);
		java.util.List<WebElement> Accountstatusoptions = sel3.getOptions();
		System.out.println("===Subdivision size is===" +  Accountstatusoptions.size());
		for (WebElement dd : Accountstatusoptions)

		{
			System.out.println(dd.getText());
		}
	}

	public void Enter_Emailid(String email) {
		Enter_Mailid.sendKeys(email);
	}

	public void Enter_Mobileno(String mobileno) {
		Enter_Mobileno.sendKeys(mobileno);
	}

	public void Update_Button() {
		if (Update_Button.isEnabled()) {
			Update_Button.click();

		} else {
			System.out.println("====Update Button is Not Enabled====");

		}
	}

	public void Delete_Button() {
		if (Delete_Button.isEnabled()) {
			Delete_Button.click();

		} else {
			System.out.println("====Delete Button is Not Enabled====");

		}
	}

	public void Clear_Button() {
		if (Clear_Button.isEnabled()) {
			Clear_Button.click();

		} else {
			System.out.println("====Clear Button is Not Enabled====");

		}
	}

	public Userapprovalpage Back_Button() {
		Back_Button.click();
		return new Userapprovalpage();
	}

}
