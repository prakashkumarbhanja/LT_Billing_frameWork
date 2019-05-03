package tvd.trm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import tvd.trm.qa.base.Testbase;

public class Manualcollectionentrypage extends Testbase
{
	@FindBy(id="ctl00_ContentPlaceHolder1_Rblmanual_1")
	WebElement radiobotoon;
	@FindBy(id="ctl00_ContentPlaceHolder1_lblmanual")
	WebElement manualcollectionentrylevel;
	@FindBy(name="ctl00$ContentPlaceHolder1$txtConsumerID")
	WebElement consid;
	@FindBy(how=How.NAME,using="ctl00$ContentPlaceHolder1$btnSearchconsumerIdwise")
	WebElement searchbtn;
	@FindBy(name="ctl00$ContentPlaceHolder1$txtCounter")
	WebElement counter;
	@FindBy(name="ctl00$ContentPlaceHolder1$txtrecieptnum")
	WebElement receiptno;
	@FindBy(id="ctl00_ContentPlaceHolder1_Image3")
     WebElement choosedate;
	@FindBy(name="ctl00$ContentPlaceHolder1$ddltowards")
	WebElement towords;
	@FindBy(name="ctl00$ContentPlaceHolder1$txtamountPaid")
	WebElement amount;
	@FindBy(name="ctl00$ContentPlaceHolder1$btnUpdate")
	WebElement submit;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_Label17")
	WebElement searchcollectionentry;
	

	
//<<<<....INITIALISE THE PAGEFACTORY.....>>>>>
public Manualcollectionentrypage()
{
	PageFactory.initElements(driver, this);
}

//<<<....Actions....>>>
public String checkmanualcollectionentry()
{
	return manualcollectionentrylevel.getText();
}

public void enter_consid(String consno)
{
	consid.sendKeys(consno);
	searchbtn.click();
}
public void setthecounter(String couter)
{
	counter.sendKeys(couter);
}
public void enterreceiptno(String recptno)
{
	receiptno.sendKeys(recptno);
}

//<<The date here is Hardcoded don't make it hard coded make a proper x path>>
public void choosethedate()
{
	choosedate.click();
	WebElement clickonleftarro=driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender3_prevArrow"));
	clickonleftarro.click();
	WebElement chhosedate=driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender3_day_2_3"));
	chhosedate.click();
}
public void chhose_Towords(String revnu)
{
	Select sel=new Select(towords);
	sel.selectByVisibleText(revnu);
}
public void enteramount(String amnt)
{
	amount.sendKeys(amnt);
}
public void clickonsubmit()
{
	submit.click();
}

public void click_on_radiobotton()
{
	radiobotoon.click();
}

public String search_collectionentry()
{
	return searchcollectionentry.getText();
}

}