package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	//Added constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	// Finding WebElement(Locators)
	@FindBy(name = "email")
	WebElement userName;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//*[@type=\"submit\"]")
	WebElement submit;
	
	//Action Methods
	
	//In Page Object class Action Methods starts with 'verb' terminology.
	
	public void setUserName(String usrName) {
		userName.sendKeys(usrName);
		
	}
	
	public void setpassword(String psWD) {
		password.sendKeys(psWD);
		
	}
	
	public void clickSubmit() {
		submit.click();
		
	}
	

}
