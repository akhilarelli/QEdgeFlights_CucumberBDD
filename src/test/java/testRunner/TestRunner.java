package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		//feature file path [if multiple files use {"",""}, if complete files then add only //Folder//]
		features = {".//Features//Login.feature"},
		//features = {".//Features//LoginDDT.feature"},
		//features = {".//Features//LoginDDTExcel.feature"},
		//features="@target/return.txt", //runs only failure tests
		//stendDefinition File
		glue = "stepdefinitions",
		
		//To capture failures and retest specific failures like failure.xml in TestNg
		
		plugin = {
				"pretty", "html:reports/myreport.html", 
        		"json:reports/myreport.json" 
        		},
        		
		//****For Advance Reports
		//plugin = {"com.cucumber.listener.ExtentCucumberFormatter:reports/AdminLogresult.html"},
		
		dryRun = false, //to verify all step definitions methods are matchng with steps of feature file
		monochrome = true, //to remove special characters from console
		tags = "@sanity"  //to define groups (group testing)
		//tags = "@sanity and @regression"	//Scenarios tagged with both @sanity and @regression
        //tags = "@sanity or @regression"	 //Scenarios tagged with either @sanity or @regression
        //tags = "@sanity and not @regression", //Scenarios tagged with @sanity but not tagged with @regression
		)
public class TestRunner {

	/*This class is Empty no need to add anything inside this class
	 * */
}
