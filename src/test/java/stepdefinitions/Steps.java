package stepdefinitions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;
import pageObjects.UserDashBoard;
import utilities.DataReader;

public class Steps {

	WebDriver driver;
	LoginPage lp;
	UserDashBoard udb;

	Logger logger; // calling Logger class its inbuilt
	ResourceBundle rb; // to read config file properties
	String br; // to store browser Name
	List<HashMap<String, String>> datamap; // Data driven

	@Before
	public void setUp() {

		// for logging
		logger = LogManager.getLogger(this.getClass());

		// Reading Config properties
		rb = ResourceBundle.getBundle("config");

		br = rb.getString("browser");

	}

	@After
	public void tearDown(Scenario scenario) {

		// When Scenario failed take screenshort
		if (scenario.isFailed()) {

			// To take screenshot and stores directly in Report (not in folder)
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshort = ts.getScreenshotAs(OutputType.BYTES); // list of screenshots into byte array
			scenario.attach(screenshort, "image/png", scenario.getName()); // screenshots with scenario name stores
																			// automatically in Reports
		}

		driver.quit();
	}

	@Given("User Launch Browser")
	public void user_launch_browser() {

		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Given("Opens URL {string}")
	public void opens_url(String url) {

		driver.get(url);
		driver.manage().window().maximize();

	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String string, String string2) {

		lp = new LoginPage(driver);

		lp.setUserName(string);
		logger.info("Provided UserName ");

		lp.setpassword(string2);
		logger.info("Provided Password ");

	}

	@When("click on Login button")
	public void click_on_login_button() {
		lp.clickSubmit();
		logger.info("Clicked on Login button");
	}

	@Then("User navigates to MyAccountPage")
	public void user_navigates_to_my_account_page() {

		udb = new UserDashBoard(driver);
		boolean targetPage = udb.isMyAccountExist();

		if (targetPage) {

			logger.info("Login Success ");
			Assert.assertTrue(true);
		} else {

			logger.error("Login Failed ");
			Assert.assertTrue(false);
		}

	}
	
	// ******* Data Driven test method **************
	// Check User navigates to MyAccountPage by passing Email and Password with
	// excel row "<row_index>"
/*	@Then("Check User navigates to MyAccountPage by passing Email and Password with excel row {string}")
	public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_data(String rows) {
		datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\Opencart_LoginData.xlsx", "Sheet1");

		int index = Integer.parseInt(rows) - 1;
		String email = datamap.get(index).get("username");
		String pwd = datamap.get(index).get("password");
		String exp_res = datamap.get(index).get("res");

		lp = new LoginPage(driver);
		lp.setUserName(email);
		lp.setpassword(pwd);

		lp.clickSubmit();
		try {
			UserDashBoard udb = new UserDashBoard(driver);

			// returned status from method stored in boolean and verified with Assertion.
			boolean targetPage = udb.isMyAccountExist(); // returned status stored in boolean

			/*
			 * Below written logic for comapring result of targetPage on webpage and result
			 * column of Excel sheet
			 * 
			 * 1. If result in Excel sheet has "valid" and web page result has
			 * "expected result(Dashboard)" then Test Passed. 2. If result in Excel sheet
			 * has "valid" and web page result has "expected result(Not Dashboard)" then
			 * Test Failed.
			 */

			// PART-1 (positive testing)
			// for "Valid" and "TargetPage true" (if these both not satisfied then Test fail
			// and there is a bug)
		/*	if (exp_res.equals("Valid")) // retrieving value from Expected Result column from excel sheet
			{
				if (targetPage == true) // if dashboard page displayed after successful login
				// both Excelsheet result column value and webpage should be true then only
				// "Testpassed"

				{
					udb.logout(); // logout from app even logged in with valid or invalid credentials
					Assert.assertTrue(true);
					// if dashboard page displayed after successful login
					// both Excelsheet result column value and webpage should be true then only
					// "Testpassed"

				} else { // if login not successful.
					// expected True and excelsheet has valid data but Test Fail(Bug) (page not
					// logged even given valid data)
					Assert.assertTrue(false);
				}
			}

			// PART-2 (Negative testing)
			// for "InValid" and "TargetPage false" (if these both not satisfied then Test
			// fail and there is a bug)
			if (exp_res.equals("Invalid")) // retrieving value from Expected Result column from excel sheet
			{
				if (targetPage == true) // Given Invalid data(excel sheet) and page logged
				{

					udb.logout();
					Assert.assertTrue(false);// Test Fail as page logged even after giving invalid data
				} else { // if login not successful
					Assert.assertTrue(true); // given invalid data and page not logged and hence Test Pass
				}
			}

		} catch (Exception e) {

			Assert.assertTrue(false);
		}
		driver.close(); 
		
	} */

}
