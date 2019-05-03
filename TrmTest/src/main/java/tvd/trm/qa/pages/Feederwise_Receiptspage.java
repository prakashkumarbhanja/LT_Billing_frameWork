package tvd.trm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tvd.trm.qa.base.Testbase;

public class Feederwise_Receiptspage extends Testbase 
{
	@FindBy(xpath="//span[text()='Feederwise Receipts']")
	WebElement feederwiserecepts;
	@FindBy(id="ctl00_ContentPlaceHolder1_Label7")
	WebElement mon_yyyy_level;
	@FindBy(name="ctl00$ContentPlaceHolder1$ddlFederWiseReportLanguage")
	WebElement language;
	@FindBy(id="ctl00_ContentPlaceHolder1_dateimg")
	WebElement dateicon;
	@FindBy(name="ctl00$ContentPlaceHolder1$btndisplay")
	WebElement report_bottn;
	
	//<<<....Constructor......>>>
	
	public Feederwise_Receiptspage()
	{
		PageFactory.initElements(driver, this);
	}

	//<<<....Actions....>>>
	public String gettitle()
	{
		return driver.getTitle();
	}
	public String federwisereceiptsdetailslevel()
	{
		return feederwiserecepts.getText();
	}
	public boolean mon_yyy_level()
	{
		return mon_yyyy_level.isDisplayed();
	}
	public void languagedropdown()
	{
		language.click();
		Select sel=new Select(language);
		sel.selectByIndex(2);
	}
	public void click_on_dateicon()
	{
		dateicon.click();
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_day_0_6")).click();
	}
	public void click_on_report()
	{
		report_bottn.click();
	}
	
	
	
}
