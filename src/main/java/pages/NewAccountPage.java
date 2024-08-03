package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.Color;

import base.ProjectSpecificMethod;

public class NewAccountPage extends ProjectSpecificMethod{
	
	/*
	 * public NewAccountPage(WebDriver driver) { this.driver=driver; }
	 */
	
	By locate_accountName=By.xpath("//input[@name='Name']");
	By locate_ownershipText=By.xpath("//label[text()='Ownership']");
	By locate_Dropdown = By.xpath("(//span[text()='--None--'])[3]");
	By locate_selctDropdown=By.xpath("//span[text()='Public']");
	By locate_Save = By.xpath("//button[@name='SaveEdit']");
	By locate_toastMessageText = By.xpath("//span[text()='Account']/parent::div"); // get toast message part 1  //span[text()='Account']
	

	public NewAccountPage enter_AccountName() {
	
		waitForElement(driver, locate_accountName, 20).sendKeys(set_Account_Name);
	return this;
		}
		
	public NewAccountPage scroll_untillOwnershipDropdow() {
		WebElement locateOwnershipText1=driver.findElement(locate_ownershipText);
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].scrollIntoView(true);",locateOwnershipText1);
	return this;
		}
		
		public NewAccountPage click_OwnershipDropdown() {		
		waitForElement(driver, locate_Dropdown, 30).click();
		return this;
		}
		
		public NewAccountPage select_Public() {		
		waitForElement(driver, locate_selctDropdown, 20).click();
		return this;
		
		}
		public NewAccountPage click_saveButton() {	
		waitForElement(driver, locate_Save, 20).click();
		return this;
		}
		
		public  AccountHomePage  get_CreateAccountToastMessage() throws InterruptedException {
		String text1 = waitForElement(driver, locate_toastMessageText, 40).getText();		
		System.out.println(text1);
		return new AccountHomePage();
		}
				
			
		
		
}
