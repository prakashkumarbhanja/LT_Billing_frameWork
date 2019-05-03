package tvd.trm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tvd.trm.qa.base.Testbase;

public class Homepage extends Testbase {
	@FindBy(xpath = "//font[text()='Hubli Electricity Supply Company Ltd. (RAPDRP-HESCOM)']")
	WebElement companynamelable;

	@FindBy(id = "ctl00_lblCSDNAME")
	WebElement subdivisionlable;

	@FindBy(xpath = "//a[text()='Consumer Billing']")
	WebElement consumerbilling;

	@FindBy(xpath = "//a[text()='LT Billing']")
	WebElement ltbilling;

	@FindBy(xpath = "//a[text()='MasterInformation']")
	WebElement masterinformation;
	@FindBy(xpath = "//a[text()='Generate Ticket']")
	WebElement generateticket;
	@FindBy(xpath = "//a[text()='Collections']")
	WebElement collection;
	@FindBy(xpath = "//a[text()='Manual Collection Entry']")
	WebElement manualcollectionentry;

	@FindBy(xpath = "//a[text()='Collection Reports']")
	WebElement collection_report;
	@FindBy(xpath = "//a[text()='FeederWise Receipt Details']")
	WebElement feederwise_receipt_details;
	@FindBy(xpath = "//a[text()='Add User']")
	WebElement Adduser;

	// initialise the page object

	public Homepage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public String verifytitleofhomepage() {
		return driver.getTitle();
	}

	public boolean companynameleble() {
		return companynamelable.isDisplayed();
	}

	public boolean subdivlable() {
		return subdivisionlable.isDisplayed();
	}

	public void mousehoveronconsumerbill() {
		Actions act = new Actions(driver);
		act.moveToElement(consumerbilling).build().perform();
	}

	public Lt_billingpage clickonltbilling() {
		ltbilling.click();
		return new Lt_billingpage();
	}

	public Generateticketpage click_on_generateticket() {
		Actions act = new Actions(driver);
		act.moveToElement(masterinformation).build().perform();
		generateticket.click();
		return new Generateticketpage();
	}

	public Manualcollectionentrypage clickonmanualcollectionentry() {
		Actions act1 = new Actions(driver);
		act1.moveToElement(collection).build().perform();
		manualcollectionentry.click();
		return new Manualcollectionentrypage();
	}

	public Feederwise_Receiptspage click_on_FeederWise_Receipt_Details() {
		Actions act2 = new Actions(driver);
		act2.moveToElement(collection).build().perform();
		Actions act3 = new Actions(driver);
		act3.moveToElement(collection_report).build().perform();
		feederwise_receipt_details.click();
		return new Feederwise_Receiptspage();

	}

	public AddUserDetails_Comp_Page Add_User_Details() {
		Actions act3 = new Actions(driver);
		act3.moveToElement(masterinformation).build().perform();
		Adduser.click();
		return new AddUserDetails_Comp_Page();

	}

}
