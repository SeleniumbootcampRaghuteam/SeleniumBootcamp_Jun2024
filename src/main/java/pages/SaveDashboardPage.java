package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificMethod;

public class SaveDashboardPage extends ProjectSpecificMethod {

	public SaveDashboardPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public SaveDashboardPage switchToFrameClickSaveButton(WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		// switchFrameByIndex(0);
		return new SaveDashboardPage(driver, wait);
	}

	public SaveDashboardPage clickSaveDashboardButton() throws InterruptedException {
		WebElement saveButton = getElementByXPath("//button[contains(text(),'Save')]");
		// wait.until(ExpectedConditions.visibilityOf(saveButton));
		jsClick(saveButton);
		System.out.println("Save button is clicked");
		return this;
	}

	public SaveDashboardPage switchToDefaultContent() {
		switchFrameToDefaultContent();
		return this;

	}
	
	public NewDashboardCreationPage clickEditDashboardProperties() {
		WebElement editDashboardProperties = driver
				.findElement(By.xpath("//button[@title='Edit Dashboard Properties']"));
		jsClick(editDashboardProperties);
		return new NewDashboardCreationPage(driver);
		
	}

	public DashboardsPage clickTheDashboardsTab() {

		WebElement dashboardsTab = getElementByXPath("//a[@title='Dashboards']//span[1]");
		jsClick(dashboardsTab);
		return new DashboardsPage(driver,wait);
	}
}
