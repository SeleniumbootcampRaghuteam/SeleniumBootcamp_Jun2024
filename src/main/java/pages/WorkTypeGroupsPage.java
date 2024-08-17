package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.ProjectSpecificMethod;

public class WorkTypeGroupsPage extends ProjectSpecificMethod {
	public WorkTypeGroupsPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		this.actions = new Actions(driver);
		this.executor = (JavascriptExecutor)driver;
	}
		
	public WorkTypeGroupsPage verifyWTGModel() {
		wait.until(ExpectedConditions.titleContains(prop.getProperty("WorkTypeGroupsPage.WorkTypeGroupsLink.text")));
		System.out.println(driver.getTitle()+" Page is loaded for user actions");
		return this;
	}
	
	public NewWorkTypeGroupModel selectNewWTG() {
		try {
			//Click on New Work Type Group dropdown from "Recent Viewed Work Type Groups"/"Work Type Groups" tab.
			WebElement newWTGDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@title,'Work Type Groups')]")));
			newWTGDropdown.click();
			WebElement newWorkTypeGroup  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='New Work Type Group'])/ancestor::a")));
			new Actions(driver).moveToElement(newWorkTypeGroup).click().build().perform();
		} catch(Exception e) {
			//If the "Work Type Groups"/"Recently Viewed Work Type Groups" tab not available or "New Work Type Group" option is not available then move to "New" button to achieve it.
			WebElement newWTGButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='New' and text()='New']")));
			newWTGButton.click();
			System.out.println("The New WTG drop down is not available, hitting the New button");
		}
		return new NewWorkTypeGroupModel(driver);
	}
	
	public WorkTypeGroupsPage searchWorkTypeGroup(String workTypeGroupName) {
		WebElement searchWorkTypeGroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder ='Search this list...']")));
		searchWorkTypeGroup.clear();
		searchWorkTypeGroup.sendKeys(workTypeGroupName);
		searchWorkTypeGroup.sendKeys(Keys.ENTER);
		return this;
	}
	
	public EditWorkTypeGroupModel select_edit_WorkTypeGroup(String workTypeGroupName) {
		try {
			WebElement rowDropdown = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("((//table/tbody/tr//a[@title='"+workTypeGroupName+"'])/ancestor :: tr)//td//a[@role = 'button']"))));
			rowDropdown.click();
		} catch (StaleElementReferenceException e){
			System.out.println("StaleElementException occurred. Refreshing the page.");
			driver.navigate().refresh();
			WebElement rowDropdown = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("((//table/tbody/tr//a[@title='"+workTypeGroupName+"'])/ancestor :: tr)//td//a[@role = 'button']"))));
			rowDropdown.click();
		}
		WebElement editInMenu = driver.findElement(By.xpath("//div[@role='menu']//div[text()='Edit']"));
		executor.executeScript("arguments[0].click();", editInMenu);
		return new EditWorkTypeGroupModel(driver);
	}
	
	public WorkTypeGroupsPage select_delete_WorkTypeGroup(String workTypeGroupName) {
		try {
			WebElement rowDropdown = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("((//table/tbody/tr//a[@title='"+workTypeGroupName+"'])/ancestor :: tr)//td//a[@role = 'button']"))));
			rowDropdown.click();
		} catch (StaleElementReferenceException e){
			System.out.println("StaleElementException occurred. Refreshing the page.");
			driver.navigate().refresh();
			WebElement rowDropdown = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("((//table/tbody/tr//a[@title='"+workTypeGroupName+"'])/ancestor :: tr)//td//a[@role = 'button']"))));
			rowDropdown.click();
		}
		
		WebElement deleteInMenu = driver.findElement(By.xpath("//div[@role='menu']//div[text()='Delete']"));
		executor.executeScript("arguments[0].click();", deleteInMenu);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type = 'button' and @title = 'Delete']"))).click();
		return this;
	}
	public WorkTypeGroupsPage verifyToastMessage() {
		WebElement toastMessageElement = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']"));
		String toastMessage = toastMessageElement.getText();
		System.out.println("\nThe toast message:\n"+toastMessage);		
		return this;
	}
	
	public WorkTypeGroupsPage verifyNewWTGCreated(String workTypeGroupName) {
		System.out.println("Name verification on New Work Type Group Page:");
		String createdWorkTypeGroupName = driver.findElement(By.xpath("//lightning-formatted-text[@slot = 'primaryField']")).getText();
		if (createdWorkTypeGroupName.equals(workTypeGroupName))
		{
			System.out.println("Work Type Group Name on page: \"" +workTypeGroupName+"\" as expected.");
		}
		else
		{
			System.out.println("Failed");
		}
		return this;
	}
	
	
	public WorkTypeGroupsPage verifyWTGDescription(String workTypeGroupName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th//a[@title='"+workTypeGroupName+"']"))).click();
		String description = (driver.findElement(By.xpath("(//span[text()='Description'])[2]/following::lightning-formatted-text[@slot='outputField'][1]"))).getText();
		System.out.println("\nThe text in \"Description\" field: "+description);
		return this;
	}
	
	public WorkTypeGroupsPage verifyWTGDeletionAction(String workTypeGroupName) {
		try {
			WebElement rowWorkTypeGroup = driver.findElement(By.xpath("//table/tbody/tr//a[@title='"+workTypeGroupName+"']"));
			if(rowWorkTypeGroup.isDisplayed())
			{ 
				System.out.println("The Work Type Group \""+workTypeGroupName+"\" is not deleted, Try again");
			}
			else
			{
				String results = driver.findElement(By.xpath("//span[@part ='formatted-rich-text']")).getText();		
				if(results.contains("No items to display"))
				{
				System.out.println("\nThe Work Type Group \""+workTypeGroupName+"\" is deleted successfully.");
				}
				else
				System.out.println("Unable to verify if the Work Type Group \""+workTypeGroupName+"\" is deleted, please verify manually");
		
			}
		}
		catch (NoSuchElementException e){
			System.out.println("\nThe Work Type Group Name search for \""+workTypeGroupName+"\" returned no such element.");
			String results = driver.findElement(By.xpath("//span[@part ='formatted-rich-text']")).getText();		
			if(results.contains("No items to display"))
			{
				System.out.println("\nThe Work Type Group \""+workTypeGroupName+"\" is deleted successfully.");
			}
			else
				System.out.println("Unable to verify if the Work Type Group \""+workTypeGroupName+"\" is deleted, please verify manually");
		
		}
		return this;
	}
	
	
}
