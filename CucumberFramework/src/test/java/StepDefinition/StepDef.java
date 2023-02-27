package StepDefinition;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.AddNewCustomersPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

//child class
public class StepDef extends BaseClass{
	
	
	@Before
	public void setup() throws IOException {
		readConfig=new ReadConfig();
		
		logger=LogManager.getLogger("StepDef");
		String browserVal=readConfig.getBrowser();
		
		switch(browserVal) {
		case "chrome":
			 WebDriverManager.chromedriver().setup();
			   driver=new ChromeDriver();
			   break;
		case "firefox":
			 WebDriverManager.firefoxdriver().setup();
			   driver=new FirefoxDriver();
			   break;	
	    case "edge":
			 WebDriverManager.edgedriver().setup();
			   driver=new EdgeDriver();
			   break;  
	    default:
			   driver=null;
			   break;	   
		}
		
		
		   driver.manage().window().maximize();
		   logger.info("chromedriver launched");
		  
	}
	
	@Given("User Launch chrome browser")
	public void user_launch_chrome_browser() {
	  
	   loginpage=new LoginPage(driver);
	   addNewCustomersPage=new AddNewCustomersPage(driver);
	   searchCustomerPage=new SearchCustomerPage(driver);
	   	   
	}

	@When("User open URL {string}")
	public void user_open_url(String url) {
		driver.get(url);
	  	}

	@When("User enter email as {string} and Password as {string}")
	public void user_enter_email_as_and_password_as(String email, String passw) {
	   loginpage.enterEmail(email);
	   loginpage.enterPassword(passw);
	}

	@When("Click on Login")
	public void click_on_login() {
		loginpage.clickOnLoginButton(); 
	}
///////////////////////////////////// Login feature ///////////////////////////////////////
	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		 String actualTitle=driver.getTitle();
		 if(actualTitle.equals(expectedTitle)) {
			 Assert.assertTrue(true); 
		 }else
			 Assert.assertTrue(false);
		}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
	  loginpage.logoutButton();
	  
	}

	@Then("close browser")
	public void close_browser() {
	 driver.close();   
	 driver.quit();
	}
///////////////////////////////  Add new Customers ///////////////////////////////////////	
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		String actualTitle=addNewCustomersPage.getPageTtile();	
		String expectedTitle="Dashboard / nopCommerce administration";
		
		if(actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		}else
		{
			Assert.assertFalse(false);
		}
	}

	@When("User click on customers menu")
	public void user_click_on_customers_menu() {
		addNewCustomersPage.clickOnCustomerMenu();
	}

	@When("click on customer menu item")
	public void click_on_customer_menu_item() {
		addNewCustomersPage.clickOnCustomerMenuItem(); 
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		addNewCustomersPage.clickOnAddNewCustomer();
	   
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
	String actualTitle=addNewCustomersPage.getPageTtile();
	String ExpectedTitleAddNewCust="Add a new customer / nopCommerce administration";
	if(actualTitle.equals(ExpectedTitleAddNewCust)) {
		Assert.assertTrue(true);
		
	}else {
		Assert.assertFalse(false);
	}
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		addNewCustomersPage.enterEmail(generateEmailId()+"@gmail.com");
		addNewCustomersPage.enterPassword("test1");
		addNewCustomersPage.enterfirstName("prachi");
		addNewCustomersPage.enterLastName("gupta");
		addNewCustomersPage.entergender("female");
		addNewCustomersPage.enterDob("6/20/1990");
		addNewCustomersPage.entercompanyname("codestudio");
		addNewCustomersPage.IsTaxExemp();
		//addNewCustomersPage.entertxtNewsLetter("Test store 2");
		//addNewCustomersPage.customerRole("Vendors");
		//addNewCustomersPage.enterManagerOfVendor("Vendor 1");
		addNewCustomersPage.activeCheckBox();
		addNewCustomersPage.adminContent("adminContent");
		
	}

	@When("click on save button")
	public void click_on_save_button() {
		addNewCustomersPage.saveNewCustBtn(); 
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMsg) {
		String bodytext=driver.findElement(By.tagName("body")).getText();
		if(bodytext.contains(expectedConfirmationMsg)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		}
	//////////////////// search user///////////////////////////
	
	@When("enter customer Email")
	public void enter_customer_email() {
		searchCustomerPage.enterEmailAdd("victoria_victoria@nopCommerce.com");
	   
	}

	@When("click on search button")
	public void click_on_search_button() {
		searchCustomerPage.clickOnSearchButton();
	    
	}

	@Then("User should found email in search table")
	public void user_should_found_email_in_search_table() {
		String expectedEmailAdd="victoria_victoria@nopCommerce.com";
		if(searchCustomerPage.searchCustomerByEmail(expectedEmailAdd)==true)
		{
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(false);
		}
	}
	
	@When("enter customer FirstName")
	public void enter_customer_first_name() {
		searchCustomerPage.FirstName("Victoria");
	}

	@When("enter customer LastName")
	public void enter_customer_last_name() {
		searchCustomerPage.LastName("Terces");
	}

	@Then("User should found Name in search table")
	public void user_should_found_name_in_search_table() {
	String expectedName="victoria Treces";
		if(searchCustomerPage.searchCustomerByName(expectedName)==true)
		{
			Assert.assertTrue(true);
		}else {
			
			Assert.assertFalse(false);
		}
	}
	@After
	public void tearDown(Scenario sc) throws IOException {
		if(sc.isFailed()==true) {
		
		File Screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screenshot, new File(".//Screenshot/"+Screenshot.getName()+".png"));
		
		}
		driver.quit();
	}
}
