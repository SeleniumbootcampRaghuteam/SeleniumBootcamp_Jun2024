package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.ProjectSpecificMethod;

public class AppLauncherPage extends ProjectSpecificMethod {
	public AppLauncherPage(WebDriver driver) {
		this.driver = driver;
	}

	public DashboardsPage clickDashboardsLink() {
		driver.findElement(By.xpath("//p[@class='slds-truncate']//mark[contains(text(),'Dashboards')]")).click();
		return new DashboardsPage(driver,wait);

	}
}
