package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethod;

public class Sales_HomePage extends ProjectSpecificMethod{

	/*
	 * public Sales_HomePage(WebDriver driver) { this.driver=driver; }
	 */
	By locate_accountDropDown=By.xpath("//span[text()='Accounts List']/..");
	
	public AccountHomePage click_AccountTab() throws InterruptedException {
	
		//Click on account tab drop down	
		waitForElement(driver, locate_accountDropDown, 30).click();
		Thread.sleep(3000);
		return new AccountHomePage();
		
		
	}
	
	
	

}
