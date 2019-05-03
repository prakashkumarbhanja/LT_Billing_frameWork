package tvd.trm.qa.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tvd.trm.qa.base.Testbase;
import tvd.trm.qa.pages.Homepage;
import tvd.trm.qa.pages.Loginpage;

public class Loginpagetest extends Testbase {
	public static Loginpage loginpage;
	public static Homepage homepage;
	public static Testbase testbase;
	public static Loginpagetest loginpagetest;

	public Loginpagetest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		loginpagetest = new Loginpagetest();
		initialisation();
		loginpage = new Loginpage();
		testbase = new Testbase();
	}

	@Test(/* enabled=false */) // How to disable a testcases ??
								// (enabled=false)
	public void loginpagetitletest() {
		String title = loginpage.validateloginpagetitle();
		System.out.println("The titlt name is=="+title);
		Assert.assertEquals(title, "Login Page","Titlt not matched");

	}

	@Test()
	public void trmlogoimagetest() {
		Boolean flag = loginpage.validatetrmimage();
		Assert.assertTrue(flag,"Logo not present");
	}

	@Test()
	public void loginpage() {
		System.out.println("The username is======="+prop.getProperty("username"));
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"),
				prop.getProperty("role"));

	}

	@AfterMethod
	public void teardown() {
		driver.close();
		driver.quit();
	}

}
