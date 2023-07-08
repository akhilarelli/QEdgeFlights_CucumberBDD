package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// calling Parent class (BasePage) Constructor and inheriting its properties.

		// Finding WebElement(Locators)

	}

	@FindBy(id = "name")
	WebElement firstName;
	
	@FindBy(id="contact")
	WebElement contactNum;
	
	@FindBy(id="email")
	WebElement inputEmail;
	
	@FindBy(id="address")
	WebElement inputPassword;
	
	@FindBy(name = "gender")
	WebElement genderDropDown;
	
	@FindBy(className = "ui-datepicker-month")
	WebElement selectMonth;
	
	@FindBy(className = "ui-datepicker-year")
	WebElement selectYear;
	
	@FindBy(className = "ui-datepicker-calendar")
	WebElement selectDate;
	
	@FindBy(id="flexCheckChecked")
	WebElement checkAgree;
	
	

	
	//Action Methods
	
	//In Page Object class Action Methods starts with 'verb' terminology.
	
	public void setFirstName(String fName) {
		
		firstName.sendKeys(fName);
	}
	
	public void setContactNumber(String Number) {
		
		contactNum.sendKeys(Number);
	}
	
	public void setEmailId(String email) {
		
		inputEmail.sendKeys(email);
	}
	
	public void setPassword(String pswd) {
		
		inputPassword.sendKeys(pswd);
	}
	
	public void selectfromDropDown(String gend) {
		
		Select gender = new Select(genderDropDown);
		
		gender.selectByVisibleText(gend);
	}
	
	public void calendardateSelection() {
		
		driver.findElement(By.name("dob")).click();
		String calendarData = "13/Sep/1996";
		String data[] = calendarData.split("/");
		String date = data[0];
		String mon = data[1];
		String year = data[2];
		
		WebElement monDropDown = driver.findElement(By.className("ui-datepicker-month"));
		Select monthdrp = new Select(monDropDown);
		monthdrp.selectByVisibleText(mon);
		
		WebElement yearDropDown = driver.findElement(By.className("ui-datepicker-year"));
		Select yeardrp = new Select(yearDropDown);
		yeardrp.selectByVisibleText(year);
		
		WebElement calendarTable = driver.findElement(By.className("ui-datepicker-calendar"));
		
		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		
		for(int i=1;i<rows.size();i++) {
			
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			for(WebElement element:cols) {
				
				if(element.getText().equals(date)) {
					element.click();
					break;
				}
			}
			
		}
	}
	
	
	
	public void clickAgree() {
		
		checkAgree.click();
	}

	
	}
	
	

