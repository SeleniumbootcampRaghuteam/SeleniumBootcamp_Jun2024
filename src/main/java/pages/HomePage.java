package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethod;

public class HomePage extends ProjectSpecificMethod{
	
	By locate_WaffleIcon = By.xpath("//button[contains(@class,'slds-icon-waffle_container')]");
	By locate_viewAllLink = By.xpath("(//button[@class='slds-button'])[2]");  //button[text()='View All']
	By locate_searchTextBox = By.xpath("//input[@class='slds-input']");
	By locate_SalesLink=By.xpath("//p[contains(text(),'Manage your sales process')]/preceding-sibling::a//span//mark");
	
	/*
	 * public HomePage(WebDriver driver) { this.driver=driver; }
	 */

	public  HomePage clickWaffle() throws InterruptedException {
		waitForElement(driver, locate_WaffleIcon, 50).click();
		return this;
	}
	
	public  HomePage click_viewAllLink()
	{			
		waitForElement(driver, locate_viewAllLink, 50).click();
		return this; 	
	}
	
	public HomePage searchSales() 
	{	
		waitForElement(driver, locate_searchTextBox, 20).sendKeys("sales");
		return this;
	}
	
	
  public Sales_HomePage  click_SalesLink()	{	
		driver.findElement(locate_SalesLink).click();
		return new Sales_HomePage();
	}
	
	
}
