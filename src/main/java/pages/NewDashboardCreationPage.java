package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.ProjectSpecificMethod;

public class NewDashboardCreationPage extends ProjectSpecificMethod {

	public NewDashboardCreationPage(WebDriver driver) {
		this.driver = driver;
	}

	public NewDashboardCreationPage switchToNewDashboardFrame() {
		switchFrameByFrameLocator(By.xpath("//iframe[@title='dashboard']"));
		return this;

	}

	public NewDashboardCreationPage enterNewDashboardName(String dashboardName) {
		driver.findElement(By.id("dashboardNameInput")).sendKeys(dashboardName);
		return this;
	}

	public NewDashboardCreationPage clickCreateButton() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("submitBtn")).click();
		System.out.println("CreateButton is clicked");
		return this;

	}
	
	public NewDashboardCreationPage enterDashboardDescription(String dbDescription) {
		WebElement dashboardDescription = getElementByXPath("//input[@id='dashboardDescriptionInput']");
		sendKeys(dashboardDescription, dbDescription);
		return this;
	}
	
	public NewDashboardCreationPage clickSaveButton() throws InterruptedException {
		WebElement saveDashboardButton = getElementByXPath("(//button[contains(@class,'slds-button slds-button_brand')])[2]");
		click(saveDashboardButton);
		return this;

	}

	public SaveDashboardPage switchToSaveDashboardPage(WebDriver driver) {
		switchFrameToDefaultContent();
		return new SaveDashboardPage(driver, wait);
	}

}
