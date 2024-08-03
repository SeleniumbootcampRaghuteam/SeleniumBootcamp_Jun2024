package pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethod;


public class AccountHomePage extends ProjectSpecificMethod{
	
	/*
	 * public AccountHomePage(WebDriver driver) { this.driver=driver; }
	 */
	By locate_newLink=By.xpath("//span[text()='New Account']/../.."); 
	By locate_ParentSearch=By.xpath("//button[contains(@class,'slds-button slds-button_neutral search-button slds-truncate')]");
	By locate_childSearch=By.xpath("//input[@class='slds-input' and @placeholder='Search...']");
	By locate_toastMessageText = By.xpath("//span[text()='Account']/parent::div");// get toast message part 1  //span[text()='Account']
	By locate_accountName = By.xpath("//table//tr//span/a[contains(text(),'Yamuna')]"); 
	
	public NewAccountPage click_NewButton() {
		
		WebElement locate_NewLink1= driver.findElement(locate_newLink);
		
	 executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", locate_NewLink1);
	return new NewAccountPage();
		
}
	
	public AccountHomePage  get_CreateAccount_ToastMessage() throws InterruptedException {
		
		//get toast message and verify
			String text1 = waitForElement(driver, locate_toastMessageText, 40).getText();
			return this;
	}
	
	public AccountHomePage ParentSearch() throws InterruptedException {
		
		WebElement locate_parentSearch1 =driver.findElement(locate_ParentSearch); 
		Thread.sleep(2000);
		locate_parentSearch1.click();
		Thread.sleep(2000);
		return this;
		
	}
	
	public AccountHomePage childSearch() {
		
		WebElement	locate_childSearch2 =driver.findElement(locate_childSearch); 
		locate_childSearch2.sendKeys(set_Account_Name);
		locate_childSearch2.sendKeys(Keys.RETURN);
		return this;
	}
	

	
	public AccountHomePage  get_accountName() throws InterruptedException {	
		Thread.sleep(3000);
		String name=waitForElement(driver, locate_accountName, 40).getText();
		
		return this;
			
}
	
}