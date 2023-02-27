package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomersPage {
	WebDriver ldriver;
	
	public AddNewCustomersPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//@FindBy(xpath="//i[@class='fa fa-bars']")
	//WebElement menu;
	
	@FindBy(xpath="//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']/li[4]/a/p")
	WebElement customerMenu;
	
	@FindBy(xpath="//nav[@class='mt-2']/ul/li[4]/ul/li[1]/a/p")
	WebElement menuitem;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement AddNewCustomer;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='Gender_Male']")
	WebElement btnGender_Male;
	
	@FindBy(xpath="//input[@id='Gender_Female']")
	WebElement btnGender_Female;
	
	@FindBy(xpath="//input[@id='DateOfBirth']")
	WebElement txtDateOfBirth;
	
	@FindBy(xpath="//input[@id='Company']")
	WebElement txtcompany;
	
	@FindBy(xpath="//div[@class='input-group-append input-group-required']//input[@role='listbox']")
	WebElement txtCustomerRole;
	
	@FindBy(xpath="//div[@class='input-group-append']//div[@role='listbox']")
    WebElement txtnewsletter;
	
	@FindBy(xpath=" //select[@id='VendorId']")
	WebElement managerOfVendor;
	
	@FindBy(xpath="//textarea[@id='AdminComment']")
	WebElement txtadmincomment;
	
	@FindBy(xpath="//input[@id='IsTaxExempt']")
	WebElement txtIsTaxExemptCheckBox;
	
	@FindBy(xpath="//input[@id='Active']")
	WebElement txtActiveCheckBox;
	
	@FindBy(xpath="//button[@name='save']")
	WebElement savebtn;
	
	
	public String getPageTtile() {
		return ldriver.getTitle();
	}
	
	public void clickOnCustomerMenu() {
		customerMenu.click();
	}
	
	public void clickOnCustomerMenuItem() {
		menuitem.click();
	}
	
	public void clickOnAddNewCustomer() {
		AddNewCustomer.click();
	}
	public void enterEmail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		txtpassword.sendKeys(password);
	}
	
	public void enterfirstName(String FirstName) {
		txtFirstName.sendKeys(FirstName);
	}
	
	public void enterLastName(String LastName) {
		txtLastName.sendKeys(LastName);
	}
	public void entergender(String gender) {
		if(gender.equals("Male")) {
			btnGender_Male.click();
		}else if(gender.equals("Female")){
		    btnGender_Female.click();
	    }else
	    {
	    	btnGender_Male.click();
		}
	}
	public void enterDob(String dob) {
		txtDateOfBirth.sendKeys(dob);
	}
	
	public void entercompanyname(String companyname) {
		txtcompany.sendKeys(companyname);
	}
	public void adminContent(String content) {
		txtadmincomment.sendKeys(content);
	}
	public void enterManagerOfVendor(String value) {
		Select select=new Select(managerOfVendor);
		select.selectByVisibleText(value);
	}

	public void entertxtNewsLetter(String nwsLetter) {
		Select select=new Select(txtnewsletter);
		select.selectByVisibleText(nwsLetter);
	}
		public void customerRole(String custRole) {
			Select select=new Select(txtCustomerRole);
			select.selectByVisibleText(custRole);
		}
	
	public void IsTaxExemp() {
		txtIsTaxExemptCheckBox.click();
	}
	public void activeCheckBox() {
		txtActiveCheckBox.click();
	}
	public void saveNewCustBtn() {
		savebtn.click();
	}
}
