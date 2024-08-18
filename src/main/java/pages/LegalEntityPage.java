package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificMethod;

public class LegalEntityPage extends ProjectSpecificMethod {

	private WebDriverWait wait;

	//private RemoteWebDriver driver;

	public LegalEntityPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		this.actions = new Actions(driver);
		this.executor = (JavascriptExecutor)driver;
	}
	
//	public LegalEntityPage  NLEClickDropdown() {
//	WebElement clickLegalEntitiesDropdown = driver.findElement(By.xpath(
//			"((//a//following::span[contains(text(),'Legal Entities')])[1]//following::a[@role='button'])[1]"));
//	clickLegalEntitiesDropdown.click();
//	return this;
//	}	
//	public LegalEntityPage verifyNLEModel() {
//		wait.until(ExpectedConditions.titleContains("Legal Entity"));
//		System.out.println(driver.getTitle()+" Page is loaded for user actions");
//		return this;		
//	}
	 
	 public NewLegalEntityModel selectNewNLE() {
		  WebElement newButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='New' and text()='New']")));
			newButton.click();
		System.out.println("The New LegalEntity drop down is not available, hitting the New button");
	return new NewLegalEntityModel(driver);

	  
	  }

	

//	public NewLegalEntityModel selectNewNLE() {
//		try {
//			//Click on LegalEntity dropdown from "Recent Viewed LegalEntity"/"LegalEntity" tab.
////			WebElement newNLEDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@title,'Legal Entities')]")));
////			newNLEDropdown.click();
//			WebElement newLegalEntity  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='New Legal Entities'])/ancestor::a")));
//			new Actions(driver).moveToElement(newLegalEntity).click().build().perform();
//		} catch(Exception e) {
//			//If the "LegalEntity"/"Recently Viewed LegalEntity" tab not available or "New LegalEntity" option is not available then move to "New" button to achieve it.
//			WebElement newWTGButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='New' and text()='New']")));
//			newWTGButton.click();
//			System.out.println("The New LegalEntity drop down is not available, hitting the New button");
//		}
//		return new NewLegalEntityModel(driver);
//	}
  
}
