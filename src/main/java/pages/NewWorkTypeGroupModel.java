package pages;

import java.time.Duration;
import java.util.List;
//import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.ProjectSpecificMethod;

public class NewWorkTypeGroupModel extends ProjectSpecificMethod {
	public NewWorkTypeGroupModel(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		this.actions = new Actions(driver);
		this.executor = (JavascriptExecutor)driver;
	}

	public NewWorkTypeGroupModel verifyNewWTGModel() {
		wait.until(ExpectedConditions.titleContains("New Work Type Group"));
		System.out.println(driver.getTitle()+" Model Window Opened for User to Edit");
		return this;
	}

	public NewWorkTypeGroupModel enterNewWTGName(String workTypeGroupName) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//label[text()='Work Type Group Name'])/following::input[1]"))).sendKeys(workTypeGroupName);
		return this;
	}
	
	public NewWorkTypeGroupModel enterNewWTGDescription(String WTGDescription) {
		driver.findElement(By.xpath("(//label[text()='Description'])//following :: textarea")).sendKeys(WTGDescription);
		return this;
	}
	
	public NewWorkTypeGroupModel selectGroupType(String WTGGroupType) {
		driver.findElement(By.xpath(("//label[text()='Group Type']/following::div[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//lightning-base-combobox-item//span[@class='slds-truncate' and contains(text(), '"+WTGGroupType+"')]"))).click();
		String selectedGroupType = driver.findElement(By.xpath("//button/span[@class='slds-truncate']")).getText();
		 
		if(selectedGroupType.equalsIgnoreCase(WTGGroupType))
			System.out.println(WTGGroupType+" Group Type is selected as expected.");
		else
			System.out.println(WTGGroupType+" is not selected, instead "+selectedGroupType+" is selected as Group Type, please check.");
		return this;
	}
	
	public WorkTypeGroupsPage clickSave_NoErrors() {
			driver.findElement(By.xpath("//button[text()='Save']")).click();
			System.out.println("Saved with no errors");
			return new WorkTypeGroupsPage(driver);

	}
	
	public NewWorkTypeGroupModel clickSave_withErrors() {
			driver.findElement(By.xpath("//button[text()='Save']")).click();
						
			WebElement errorPopUp = driver.findElement(By.xpath("//div[@role='dialog']//h2[text()='We hit a snag.']"));
			if (errorPopUp.isDisplayed()) {
				System.out.println("Error occured on Save, driver instance should be of the current page(this page class driver).");
			}
			else {
				System.out.println("Saved with no errors");

			}
			return this; 
	}
	
	public NewWorkTypeGroupModel verifyWTGMandatoryError() {
		try{
			WebElement errorPopUp = driver.findElement(By.xpath("//div[@role='dialog']//h2[text()='We hit a snag.']"));
			if(errorPopUp.isDisplayed())
			{
				List<WebElement> errorFields = driver
						.findElements(By.xpath("(//div/Strong[text()='Review the following fields'])/following::a"));
				for (int i = 0; i <= (errorFields.size())-1; i++) {
					String fieldName = errorFields.get(i).getText();
					if (fieldName.equalsIgnoreCase("Work Type Group Name")) {
						executor.executeScript("arguments[0].click();", errorFields.get(i));
						break;
					}
			}
			String errorMessage = driver.findElement(By.xpath("(//label[text()='Work Type Group Name'])//following::div[@part='help-text']")).getText();
			System.out.println("\nThe Work Type Group has the below error message:\n"+errorMessage);
			}
		} catch(Exception e) {  
			System.out.println(e+" No error pop up displayed!!!");
		}
		return this;
	}
	
}
