package tvd.trm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import tvd.trm.qa.base.Testbase;

public class Testutil extends Testbase {
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 30;
	// String sheetname="Generate_Ticket";
	// For Data Lt bill
	//public static String LTBILL_Sheet_Path = "C:\\Users\\user1\\git\\TRM_Framework\\TrmTest\\src\\main\\java\\tvd\\trm\\qa\\testdata\\Data of 540038.xlsx";

	// for generate ticket path
	// public static String generateticketpath ="C:\\Users\\user1\\git\\TRM_Framework\\TrmTest\\src\\main\\java\\tvd\\trm\\qa\\testdata\\GenerateTicket.xlsx";
	// for manualcollection path
	public static String manualcoolectionpath="C:/Users/user1/git/TRM_Framework/TrmTest/src/main/java/tvd/trm/qa/testdata/Manual_CollectonEntry.xlsx";
	// For Adduser path
	//public static String
	 //Adduser_Path="C:\\Users\\user1\\git\\TRM_Framework\\TrmTest\\src\\main\\java\\tvd\\trm\\qa\\testdata\\AdduserDetails.xlsx";
	//For Edit Existing User
	//public static String EditExistingUser="C:\\Users\\user1\\git\\TRM_Framework\\TrmTest\\src\\main\\java\\tvd\\trm\\qa\\testdata\\Edit_Existing_Userdata.xlsx";
	
	private static XSSFWorkbook wb;
	private static XSSFSheet sheet;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	public void switchtoframe() {
		// driver.switchTo().frame(arg0);
	}

	public void clickonpopup() {
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}

	// Java script for scroll
	public static void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,22000)");
	}

	// HERE getTestdata IS THE METHOD

	public static Object[][] GetTestData(String sheetname) {
		try {
			FileInputStream fis = new FileInputStream(manualcoolectionpath);   
			try {
				wb = new XSSFWorkbook(fis);
				sheet = wb.getSheet(sheetname);
			}

			catch (IOException e) {

				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int row = sheet.getLastRowNum();
		System.out.println("-----The tota no of row------"+ row);
		int col = sheet.getRow(1).getLastCellNum();
		System.out.println("----The total no of column----"+ col);
		Object[][] data = new Object[row][col];

		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				// By adding the try catch block it stat works
				data[i][j] = sheet.getRow(i).getCell(j).toString(); 
			}

		}
		System.out.println("==========The return data=======" + data);
		return data;
	}

	// <<.....CODE FOR SCREEN SHOT STORE PLACE.....>>
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		/*
		 * String currentDir = System.getProperty("user.dir");
		 * 
		 * FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" +
		 * System.currentTimeMillis() + ".png"));
		 */

	}
	// <<.............OVER..........>>

}
