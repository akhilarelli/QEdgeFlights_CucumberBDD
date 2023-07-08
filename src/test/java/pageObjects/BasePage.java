package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial;

/*This will be invoked by all other Page Object classes
 * */
public class BasePage {
	
	WebDriver driver;
	
	public BasePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		/* initElements is a static method in Page Factory class. 
		 * Using the initElements method, one can initialize all the web elements located by @FindBy annotation.
		 * */
	}
	

}
