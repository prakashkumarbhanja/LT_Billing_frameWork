package tvd.trm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tvd.trm.qa.base.Testbase;
import tvd.trm.qa.util.Testutil;

public class Lt_billingpage extends Testbase {
	@FindBy(name = "ctl00$ContentPlaceHolder1$txtconsidrrno")
	WebElement accountid;

	@FindBy(how = How.XPATH, using = "//font[text()='Hubli Electricity Supply Company Ltd. (RAPDRP-HESCOM)']")
	WebElement compnamelable;

	@FindBy(xpath = "span[text()='540038-CSD2. BELGAUM.']")
	WebElement level;

	@FindBy(name = "ctl00$ContentPlaceHolder1$btnconsidrrno")
	WebElement searchbtn;

	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlstatus")
	WebElement status;

	@FindBy(name = "ctl00$ContentPlaceHolder1$txtcurrentread")
	WebElement currdg;

	@FindBy(name = "ctl00$ContentPlaceHolder1$btnupdate")
	WebElement update;

	@FindBy(id = "ctl00_ContentPlaceHolder1_grdmonthlydetalis_ctl02_Label71")
	WebElement totaldmnd;

	// Initialize the object
	// This initElements method will create all WebElements
	public Lt_billingpage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public boolean compnamelable() {
		System.out.println("===Company lable is: ===" + compnamelable.getText());
		return compnamelable.isDisplayed();
	}

	public void Ltbill(String acntid, String curdg) {
		accountid.click();
		accountid.clear();
		accountid.sendKeys(acntid);
		searchbtn.click();
		Testutil.scroll();
		status.click();
		Select sel = new Select(status);
		sel.selectByVisibleText("Normal");
		Testutil.scroll();
		currdg.click();
		currdg.sendKeys(curdg);
		update.click();
	}
	/*
	 * public void searchbtn() { searchbtn.click();
	 * 
	 * }
	 */
	/*
	 * public void statusbtn() { status.click(); Select sel=new Select(status);
	 * sel.selectByVisibleText("Normal"); }
	 */
	/*
	 * public void currentrdg(String curdg) { currdg.click();
	 * currdg.sendKeys(curdg); }
	 */
	/*
	 * public void updatebutton() { update.click();
	 * 
	 * }
	 */

	/*
	 * public void fetchtotaldmnd() { totaldmnd.click();
	 * 
	 * }
	 */
}
