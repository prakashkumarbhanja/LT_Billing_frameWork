package tvd.trm.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import tvd.trm.qa.base.Testbase;
import tvd.trm.qa.pages.Generateticketpage;
import tvd.trm.qa.pages.Homepage;
import tvd.trm.qa.pages.Loginpage;
import tvd.trm.qa.util.Testutil;

public class GenerateticketTest extends Testbase
{
	public static Loginpage loginpage;
	public static Homepage homepage;
	public static Testutil testutil;
	public static Generateticketpage generateticket;
	
	//SHEET NAME.....
	static String sheetname="Generateticket";
	public GenerateticketTest()
	{
		super();
	}
	
	@BeforeMethod()
	public void setup()
	{
		initialisation();
		Loginpage loginpage=new Loginpage();
		testutil=new Testutil();
		homepage=new Homepage();
		generateticket=new Generateticketpage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("role"));
		generateticket=homepage.click_on_generateticket();
	}
	
	@Test(/*priority=1*/enabled=false)
	public void verifyltbillingtitle()
	{
		String tickettitle=generateticket.tickettitlename();
		System.out.println("===Ticket Title is==="+tickettitle);
		Assert.assertEquals(tickettitle, "GENERATE TICKET","Titlt text not matched");
	}
	//<<----DATA_PROVIDER---->>
	@DataProvider
	public Object[][] getTestdataofgenerateticket() throws EncryptedDocumentException, IOException
	{
		
		//How, call the method by the Class Name ?? Of below TESTUTIL.gettestdata(sheetname)
	   //ANS:-- As because of i hav used the static keyword before that particular method, 
	  //So i can call the method of any class which is declare as static by the help of CLASS Name. 
	 //If No Static keyword is there then we have to create the object of that particular class and call that method
		Object data[][] = Testutil.GetTestData(sheetname);
		return data;
	}
	
	  @Test(priority=2,dataProvider="getTestdataofgenerateticket")
		public void raiseaticket(String Priority,String Severity,String TypeOfComplaint,String Status,String Title,String Description,String Narration)
		{
		//homepage.click_on_generateticket();
		generateticket.clickonpriority(Priority);
		generateticket.selectseverity(Severity);
		generateticket.clickontypeofcomplaint(TypeOfComplaint);
		generateticket.clickonstatus(Status);
		generateticket.givetitle(Title);
		generateticket.filldescription(Description);
		generateticket.fillnaration(Narration);
		//generateticket.clickongeneratebutton();
	   } 

	@AfterMethod()
	public void teardown()
	{
		driver.quit();
	}
}
