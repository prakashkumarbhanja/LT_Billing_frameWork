package tvd.trm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import tvd.trm.qa.base.Testbase;

public class Loginpage extends Testbase {
	// Page factory of loginpage (OR)
	@FindBy(id = "txtusername")
	WebElement username;

	@FindBy(id = "txtPassword")
	WebElement password;

	@FindBy(name = "ddlgroupname")
	WebElement rol;

	@FindBy(id = "btnlogin")
	WebElement loginbtn;

	@FindBy(xpath = "//img[contains(@src,'images/HESCOM')]")
	WebElement trmlogo;

	// Initialising the page objects(So we use constructor)
	public Loginpage() {
		// Why "this"??
		// because, it means the current class(Loginpage)
		PageFactory.initElements(driver, this);

	}

	// Actions
	public String validateloginpagetitle() {
		return driver.getTitle();
	}

	public boolean validatetrmimage() {
		return trmlogo.isDisplayed();
	}

	public Homepage login(String un, String pwd, String roll) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		rol.click();
		Select sel = new Select(rol);
		// sel.selectByVisibleText("Admin");
		sel.selectByValue(roll);
		// sel.selectByIndex(1);

		loginbtn.click();
		return new Homepage();
	}

}
