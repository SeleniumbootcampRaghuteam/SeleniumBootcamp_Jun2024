package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificMethod;

public class HomePage extends ProjectSpecificMethod{
	
	By locate_WaffleIcon = By.xpath("//button[contains(@class,'slds-icon-waffle_container')]");
	By locate_viewAllLink = By.xpath("(//button[@class='slds-button'])[2]");  //button[text()='View All']
	By locate_searchTextBox = By.xpath("//input[@class='slds-input']");
	By locate_SalesLink=By.xpath("//p[contains(text(),'Manage your sales process')]/preceding-sibling::a//span//mark");
		
	 public HomePage(WebDriver driver) 
	 { 
		 this.driver=driver;
	 }
	 

	public  HomePage clickWaffle() throws InterruptedException 
	{
		waitForElement(driver, locate_WaffleIcon, 50).click();
		return this;
	}
	
	public HomePage clickGlobalActionIcon()
	{
		// Click on Global Actions SVG icon
		driver.findElement(By.xpath("//div[@data-aura-class='oneGlobalCreate']//a")).click();
		System.out.println("CLICKED GLOBAL ACTION ICON");
		return this;
	}
	
	public HomePage clickNewTask()
	{
		// Click New Task
		driver.findElement(By.xpath("//span[text()='New Task']")).click();
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
	
	public Sales_HomePage click_SalesLink()	
	{	
		driver.findElement(locate_SalesLink).click();
		return new Sales_HomePage(driver);
	}
	
	public ServiceTerritoryPage clickServiceTerritory()
	{
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Service Territories");
		
		// 6) Click on Service Territories
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@data-label='Service Territories']//mark"))));
		driver.findElement(By.xpath("//a[@data-label='Service Territories']//mark")).click();
		return new ServiceTerritoryPage(driver);
	}
	
	public HomePage enterSubjectInNewTask()
	{
		// 4) Enter subject as "Bootcamp"
		driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).sendKeys("Bootcamp");
		return this;
	}		
	
	public HomePage selectContactInNewTask()
	{
		// 5) Select Contact from DropDown
		WebElement contacts = driver.findElement(By.xpath("//img[@title='Contacts']"));
		contacts.click();
		driver.findElement(By.xpath("//span[text()='Contacts']")).click();
		return this;
	}		
	
	public HomePage selectStatusInNewTask()
	{
		// 6) Select status as 'Waiting on someone else'
		WebElement status = driver.findElement(By.xpath("//a[text()='Not Started']"));
		status.click();
		driver.findElement(By.xpath("//a[text()='Waiting on someone else']")).click();
		return this;
	}		
				
	public HomePage saveTask()
	{
		// 7) Save and verify the 'Task created' message
		driver.findElement(By.xpath("(//button[@type='button']/span[text()='Save'])[2]")).click();
		return this;
	}		
				
		
	public HomePage verifyTask()
	{
		// Adding explicitly wait to verify whether the task has been created
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@data-aura-class='forceToastMessage']"))));
		WebElement toastMessage = driver.findElement(By.xpath("//div[@data-aura-class='forceToastMessage']"));
				
		// Verify whether the task has been created
		boolean msgDisplayed = toastMessage.isDisplayed();
		System.out.println("Is the Task Created? : " + msgDisplayed);
		String message = toastMessage.getText();
		System.out.println("The toast message is " + message);
		if(message.contains("was created"))
		{
			System.out.println("Task was created");
		}
		else
		{
			System.out.println("Task is not created");
		}
		return this;
	}
	
	public void clickContent()
	{
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Content");
		driver.findElement(By.xpath("//div[@data-name='Content']")).click();
	}
	
	
}
