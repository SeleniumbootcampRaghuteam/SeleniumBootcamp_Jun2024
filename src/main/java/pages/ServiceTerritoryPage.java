package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificMethod;

public class ServiceTerritoryPage extends ProjectSpecificMethod
{
	public ServiceTerritoryPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	public ServiceTerritoryPage clickNew()
	{
		// 7) Click on New 
		driver.findElement(By.xpath("//div[@title='New']")).click();
		return this;
	}
	
	public ServiceTerritoryPage enterName(String name)
	{
		// 8) Enter Your Name in Name field
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
		return this;
	}
	
	public ServiceTerritoryPage clickOperatingHours()
	{
		// 9) Click on Operating Hours and Choose the First option
		driver.findElement(By.xpath("//input[@placeholder='Search Operating Hours...']")).click();
		driver.findElement(By.xpath("(//span[@class='slds-media__body']//span)[4]")).click();	
		return this;
	}
	
	public ServiceTerritoryPage checkActiveField()
	{
		// 10) Check Active Field
		driver.findElement(By.xpath("//input[@name='IsActive']")).click();	
		return this;
	}
	
	public ServiceTerritoryPage enterCity(String city)
	{
		// 11) Enter the City your residing in City Field
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
		return this;
	}
		
	public ServiceTerritoryPage enterState(String state)
	{
		// 12) Enter the State your residing in State Field
		driver.findElement(By.xpath("//input[@name='province']")).sendKeys(state);
		return this;
	}			
		
				
	public ServiceTerritoryPage enterCountry(String country)
	{
		// 13) Enter the Country your residing in Country Field
		driver.findElement(By.xpath("//input[@name='country']")).sendKeys(country);
		return this;
	}		
				
		
	public ServiceTerritoryPage enterPincode(String pincode)
	{
		// 14) Enter your current Postal Zip Code
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(pincode);
		return this;
	}				
		
	public ServiceTerritoryPage saveServiceTerritory()
	{
		//  15) Click on Save
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		return this;
	}				
	
	public ServiceTerritoryPage verifyServiceTerritory()
	{
		// 16) Verify Service Territory is created Successfully
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@data-aura-class='forceToastMessage']"))));
		WebElement toastMessage = driver.findElement(By.xpath("//div[@data-aura-class='forceToastMessage']"));
						
		// Verify whether the task has been created
		boolean msgDisplayed = toastMessage.isDisplayed();
		System.out.println("Is the Service Territories Created? : " + msgDisplayed);
		String message = toastMessage.getText();
		System.out.println("The toast message is " + message);
		if(message.contains("was created"))
		{
			System.out.println("Service Territories was created");
		}
		else
		{
			System.out.println("Service Territories is not created");
		}
		return this;
	}		
}
