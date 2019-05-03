package tvd.trm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tvd.trm.qa.base.Testbase;

public class Userapprovalpage extends Testbase {
	@FindBy(xpath = "//span[text()='User Approval/Reject']")
	WebElement UserApprovalRejectText;
	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlselect")
	WebElement ChooseApprove_Reject;
	@FindBy(name = "ctl00$ContentPlaceHolder1$btnupdate")
	WebElement Submitbutton;
	@FindBy(id = "ctl00_ContentPlaceHolder1_grddetails_ctl02_chkapprej")
	WebElement Selectcheckbox;
	
	//Edit existing user
	@FindBy(name="ctl00$ContentPlaceHolder1$btnexist")
	WebElement Edit_Existing_User;

	public Userapprovalpage() {
		PageFactory.initElements(driver, this);
	}

	public String Capturetext() {
		return UserApprovalRejectText.getText();
	}

	public boolean Check_checkbox() {
		return Selectcheckbox.isSelected();
		// Selectcheckbox.click();
	}

	public void Click_On_Checkbox() {
		if (Selectcheckbox.isSelected()) {
			System.out.println("===CHECK BOX ALREADY SELECTED===");
		} else {
			System.out.println("===PLS SELECT THE CHECK BOX===");
			Selectcheckbox.click();
		}
	}

	public void SelectApprove_Reject() {
		ChooseApprove_Reject.click();
		Select sel = new Select(ChooseApprove_Reject);
		sel.selectByVisibleText("Reject");

	}

	public void ClickonSubmit() {
		if (Submitbutton.isEnabled())
			
		{
			Submitbutton.click();
		}else
		{
			System.out.println("====THE SUBIT BUTTON IS NOT ENABLED====");
		}

	}
	 public Edit_Existing_User_page Move_Control_to_Editexistinguser()
	 {
		 Edit_Existing_User.click();
		 return new Edit_Existing_User_page();
	 }
	
	
	
}