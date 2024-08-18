package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificMethod;

public class DashboardsPage extends ProjectSpecificMethod {
	public DashboardsPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public String newDashboardName;

	public DashboardsPage searchRecentDashboards(String recentDbName) {

		WebElement searchRecentDashboardsElement = getElementByXPath(
				"//input[@placeholder='Search recent dashboards...']");
		sendKeys(searchRecentDashboardsElement, recentDbName);
		return this;
	}

	public DashboardsPage getNewDashboardName() throws InterruptedException {

		WebElement dashboardNameText = getElementByXPath("//div[@class='slds-scrollable_y']/table//tbody//th//a");
		newDashboardName = elementgetText(dashboardNameText);
		Thread.sleep(2000);
		System.out.println(newDashboardName);
		return this;
	}

	public DashboardsPage searchDashboardName(String dbName) {

		WebElement searchDashboardName = getElementByXPath("//input[@placeholder='Search recent dashboards...']");
		sendKeys(searchDashboardName, dbName);
		return this;
	}

	public DashboardsPage clickDashboardDropdownIcon() throws InterruptedException {
		Thread.sleep(2000);
		WebElement searchDashboardName = getElementByXPath("//table/tbody/tr[1]/td[6]//button");
		jsClick(searchDashboardName);
		return this;
	}

	public NewDashboardCreationPage clickDashboardEditOption() {

		WebElement dashboardEditOption = getElementByXPath("//span[text()='Edit']");
		dashboardEditOption.click();
		return new NewDashboardCreationPage(driver);
	}

	public DashboardsPage verifyIfNewDashboardNameIsCreated(String newDbNameexcel) {
		if (newDashboardName.equalsIgnoreCase(newDbNameexcel)) {
			System.out.println("The New Dashboard is created Successfully");
		} else {
			System.out.println("New Dashboard is not created");
		}
		return this;
	}

	public NewDashboardCreationPage clickNewDashboardOption() {
		driver.findElement(By.xpath("//div[@title='New Dashboard']")).click();
		return new NewDashboardCreationPage(driver);
	}

}
