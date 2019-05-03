package tvd.trm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tvd.trm.qa.base.Testbase;

public class Generateticketpage extends Testbase {

	@FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_lblGenerateTicket")
	WebElement tickettitle;
	@FindBy(name = "ctl00$ContentPlaceHolder1$drpPriority")
	WebElement priority;
	@FindBy(name = "ctl00$ContentPlaceHolder1$drpSEVIRITY")
	WebElement severity;
	@FindBy(id = "ctl00_ContentPlaceHolder1_drpHescom")
	WebElement complaintype;
	@FindBy(name = "ctl00$ContentPlaceHolder1$drpStatus1")
	WebElement status;
	@FindBy(name = "ctl00$ContentPlaceHolder1$txtTitle")
	WebElement title;
	@FindBy(name = "ctl00$ContentPlaceHolder1$txtDescription")
	WebElement description;
	@FindBy(name = "ctl00$ContentPlaceHolder1$txtdesc")
	WebElement narration;
	@FindBy(name = "ctl00$ContentPlaceHolder1$btnUpload")
	WebElement generate;

	// Initialize the pageobject

	public Generateticketpage() {
		PageFactory.initElements(driver, this);
	}

	/// -------***------

	public String tickettitlename() {
		return tickettitle.getText();
	}

	public void clickonpriority(String priorty) {
		priority.click();
		Select sel = new Select(priority);
		sel.selectByVisibleText(priorty);
	}

	public void selectseverity(String severty) {
		severity.click();
		Select sel = new Select(severity);
		sel.selectByVisibleText(severty);
	}

	public void clickontypeofcomplaint(String complaint) {
		complaintype.click();
		Select sel = new Select(complaintype);
		sel.selectByVisibleText(complaint);
	}

	public void clickonstatus(String sttus) {
		status.click();
		Select sel = new Select(status);
		sel.selectByVisibleText(sttus);
	}

	public void givetitle(String titlee) {
		title.click();
		title.sendKeys(titlee);
	}

	public void filldescription(String desc) {
		description.click();
		description.sendKeys(desc);
	}

	public void fillnaration(String narratin) {
		narration.click();
		narration.sendKeys(narratin);
	}

	public void clickongeneratebutton() {
		generate.click();
	}

}