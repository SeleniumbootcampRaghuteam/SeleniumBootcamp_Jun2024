package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificMethod;

public class TasksPage extends ProjectSpecificMethod
{
	public TasksPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public TasksPage recentlyViewedTasks() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[@title='Select a List View: Tasks']")).click();
		driver.findElement(By.xpath("//li[@data-aura-class='forceVirtualAutocompleteMenuOption']//span[text()='Recently Viewed']")).click();
		Thread.sleep(2000);
		return this;
	}
	
	public TasksPage showMoreActions()
	{
		// 6. Click the Dropdown for Bootcamp task and select Edit
		driver.findElement(By.xpath("//a[@title='Show 6 more actions']")).click();
		return this;
	}
	
	public TasksPage clickEdit()
	{
		String taskSubject = driver.findElement(By.xpath("(//li[@data-aura-class='forceSplitViewListSelectableRecord']//span)[4]")).getText();
		System.out.println("The subject name is " + taskSubject);
		
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		return this;
	}
	
	public TasksPage selectDate()
	{
		//  7. Select todays date as Due date
		driver.findElement(By.xpath("//lightning-datepicker[@variant='label-hidden']")).click();
		driver.findElement(By.xpath("//button[@name='today']")).click();
		return this;
	}
		
	public TasksPage selectPriority()
	{
		// 8. Select Priority as low
		driver.findElement(By.xpath("(//span[@title='required']/parent::span/following-sibling::div)[2]")).click();
		driver.findElement(By.xpath("//a[@title='Low']")).click();
		return this;
	}
	
	public TasksPage clickSave()
	{
		// 10. Click save and verify Subject
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		return this;
	}

	public TasksPage verifyEditTask()
	{
		
		// Adding explicitly wait for the Toast Message to be visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@data-aura-class='forceToastMessage']"))));
		WebElement toastMessage = driver.findElement(By.xpath("//div[@data-aura-class='forceToastMessage']"));
		
		// Verifying whether the Toast Message gets displayed
		boolean msgDisplayed = toastMessage.isDisplayed();
		System.out.println("Is the Task Edited? : " + msgDisplayed);
		String message = toastMessage.getText();
		System.out.println("The toast message is " + message);
		
		//Verifying whether the subject name given is present in the Toast Message
		if(message.contains("saved"))
		{
			System.out.println("Task got edited successfully");
		}
		else
		{
			System.out.println("Task is not edited");
		}
		
		return this;
	}
	
}
