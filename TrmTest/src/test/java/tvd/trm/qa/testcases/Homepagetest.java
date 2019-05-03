package tvd.trm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tvd.trm.qa.base.Testbase;
import tvd.trm.qa.pages.Homepage;
import tvd.trm.qa.pages.Loginpage;
import tvd.trm.qa.pages.Lt_billingpage;

public class Homepagetest extends Testbase
{
	public static Loginpage loginpage;
	public static Homepage homepage;
	public static Lt_billingpage ltbillingpage;
	public static Homepagetest homepagetest;
	
	
	public Homepagetest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialisation();
		loginpage=new Loginpage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("role"));
        ltbillingpage=new Lt_billingpage();
	}
	
	//Testcases should be independent to eachother
	//before each test cases-- lunch the browser and login
	//@test--execcute test cases
	//after testcases --qiut the browser
	
	
	@Test(priority=1)
	public void verifyloginpagetitletest()
	{
		String homepagetitle= homepage.verifytitleofhomepage();
		Assert.assertEquals(homepagetitle, "Welcome","Homepage title not matched");
	}
	@Test(priority=2)
	public void companynamelable()
	{
		boolean comnamelable=homepage.companynameleble();
		Assert.assertTrue(comnamelable);
	}
	
	@Test(priority=3)
	public void subdivlabledisplay()
	{
		boolean subdivlable=homepage.subdivlable();
		Assert.assertTrue(subdivlable);
	}
	@Test(priority=4)
	public void mousehover()
	{
		homepage.mousehoveronconsumerbill();
		ltbillingpage=homepage.clickonltbilling();
	}

	@AfterMethod
	public void teardown()
	{
		driver.close();
		
	}
	
	
	
	

}
