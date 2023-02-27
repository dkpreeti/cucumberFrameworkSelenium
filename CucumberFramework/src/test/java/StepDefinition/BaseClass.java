package StepDefinition;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import PageObject.AddNewCustomersPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;

//parent class for step definition
public class BaseClass {
	public WebDriver driver;
	public LoginPage loginpage;
	public AddNewCustomersPage addNewCustomersPage;
	public SearchCustomerPage searchCustomerPage;
	public ReadConfig readConfig;
	
	public static Logger logger;
	
	//generate random email id
	public String generateEmailId() {
		return RandomStringUtils.randomAlphabetic(5); 
	}

}
