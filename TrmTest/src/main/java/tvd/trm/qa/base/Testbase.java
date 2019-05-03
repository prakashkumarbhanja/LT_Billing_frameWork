package tvd.trm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import tvd.trm.qa.util.Testutil;
import tvd.trm.qa.util.WebEventListener;

public class Testbase {
	
	//why make driver and proprties public
	//because, So, that it can be use in the chield class also
	public static WebDriver driver;
	public static Properties prop;
	
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public Testbase()
	{
		try
		{
	    prop=new Properties();
		FileInputStream fip=new FileInputStream("C:\\Users\\user1\\git\\TRM_Framework\\TrmTest\\src\\main\\java\\tvd\\trm\\qa\\config\\config.properties");
		//C:\\Users\\user1\\git\\TRM_Framework\\TrmTest\\src\\main\\java\\tvd\\trm\\qa\\config\\config.properties
		//E:\\Users\\user1\\workspaceslnm\\TrmTest\\src\\main\\java\\tvd\\trm\\qa\\config\\config.properties
		prop.load(fip);
		}
		catch (FileNotFoundException e) 
		{
		e.printStackTrace();	
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public static void initialisation()
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Eclips_Dri_Jars\\Chrome_Driver(V-2.42)\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browsername.equals("firefox"))
		{
			System.setProperty("Webdriver.gecko.driver", "E:/Eclips_Dri_Jars/Gecko_Driver/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if (browsername.equals("headlessbrowser")) {
			driver=new HtmlUnitDriver(BrowserVersion.CHROME);
			
		}
		
		//<<<<<.....TO TAKE THE SCREEN SHOT....>>>
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		//e_driver.register(eventListener);
		e_driver.register((WebDriverEventListener) eventListener);
		driver = e_driver;
		
		//<<<<<....OVER.....>>>>>>
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//How i call the "PAGE_LOAD_TIMEOUT" variable in Testbase calss by using the class name of Testutil????
	   //ANS:- AS beacause of,i have declare the variabe as the "STATIC" so no need to create the object, directly we can call by the calss name.
	  //AND AS BECAUSE OF I AM NOT EXTEND THE Testutil Class SO I NEED TO CALL THE METHOD BY USING THE CLASS NAME ONLY,
     //OTHERWISE IR WILL NOT HAPPEND. AND WILL GIVE ERROR..
		
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url_link"));
		//driver.get("http://testing.hescomtrm.com");
		
		
	}

}
