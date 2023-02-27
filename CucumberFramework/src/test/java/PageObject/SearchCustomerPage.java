package PageObject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {    //class
	WebDriver ldriver;
	
	public SearchCustomerPage(WebDriver rdriver){  ///constructor
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//input[@id='SearchEmail']")               //finding webelements
	WebElement email;
	
	@FindBy(xpath="//button[@id='search-customers']")
	WebElement searchBtn;
	
	@FindBy(xpath="//div[@class='dataTables_scrollHeadInner']//table[@class='table table-bordered table-hover table-striped dataTable no-footer']")
	WebElement SearchReault;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody/tr[1]/td")
	List<WebElement> tableColumns;
	
	@FindBy(xpath ="//input[@id='SearchFirstName']")
	WebElement FirstName;
	
	@FindBy(xpath ="//input[@id='SearchLastName']")
	WebElement LastName;
	
	public void enterEmailAdd(String emailAdd) {       //action methods
		email.sendKeys(emailAdd);
	}
	
	public void clickOnSearchButton() {
		searchBtn.click();
	}
	
	//////////////////////// search by email /////////////////////////
	public boolean searchCustomerByEmail(String expectedEmail) {
		boolean found=false;
		//total no of rows
		//total no of columns
		int totlRows=tableRows.size();
				
		for(int i=1;i<=totlRows;i++) {
		WebElement element=ldriver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody/tr["+i+"]/td[2]"));
		String actualEmailAdd=element.getText();
		if(actualEmailAdd.equals(expectedEmail)) {
			found=true;
			}
		}
		return found;
		
	}
	
	public void FirstName(String FName) {
		FirstName.sendKeys(FName);
	}
	
	public void LastName(String LName) {
		LastName.sendKeys(LName);
	}
	
	////////////////search by user name////////////////
	public boolean searchCustomerByName(String expectedUserName) {
		boolean found=false;
		//total no of rows
		//total no of column
		int totlRows=tableRows.size();
				
		for(int i=1;i<=totlRows;i++) {
		WebElement elementName=ldriver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody/tr["+i+"]/td[3]"));
		String actualName=elementName.getText();
		if(actualName.equals(expectedUserName)) {
			found=true;
			}
		}
		return found;
		
	}
}
