package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//creating Page Object class for Home Page including Page Factory concept

public class HomePage extends BasePage{
	
	
//written a Constructor
	public HomePage(WebDriver driver) {
		super(driver); //calling Parent class (BasePage) Constructor and inheriting its properties.
		
	}
	
	//create WebElements , Locators with PageFactory concept
	
	@FindBy(linkText ="Register")
	WebElement lnkRegister;
	
	//Action Methods
	
	
	public void clickRegister() {
		lnkRegister.click();
	}

}
