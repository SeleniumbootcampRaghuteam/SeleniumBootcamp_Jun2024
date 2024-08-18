package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificMethod;

public class NewLegalEntityModel extends ProjectSpecificMethod{

	private WebDriverWait wait;

	public NewLegalEntityModel(WebDriver driver) 
		   { this.driver=driver; }
	
	
	
	 
		public NewLegalEntityModel switchToNLEWindow() {
			  String WindowHandle = driver.getWindowHandle();

				Set<String> CurrentOpenedWindows = driver.getWindowHandles();
				for (String OpenWindow : CurrentOpenedWindows) {
					if (!OpenWindow.equals(WindowHandle)) {
						driver.switchTo().window(OpenWindow);}
					
				}
				 return new NewLegalEntityModel(driver);
			}	
	public NewLegalEntityModel verifyNewNLEModel() {
		wait.until(ExpectedConditions.titleContains("New Legal Entity Model"));
		System.out.println(driver.getTitle()+" Model Window Opened for User to Edit");
		return this;
	}

	public NewLegalEntityModel enterNewNLEName() {
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='Name']"))).sendKeys("Salesforceautomation by Nisha");
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforceautomation by Nisha");
		return this;
	}
	
	public NewLegalEntityModel clickSaveNLE() {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		return new NewLegalEntityModel(driver);
		
	}
	
	public NewLegalEntityModel verifytoasterMsgNLE() throws InterruptedException {

		// 8.verify Legal Entity NameExpected Result:The Legal Entity is created SuccessfullyStep
		String actualMessage = driver
				.findElement(
						By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small forceActionsText')]"))
				.getText();
		System.out.println(actualMessage);
		Thread.sleep(1000);
		String expectedMessage = "Legal Entity \"Saleforce automation by Nisha\" was created.";
		if (actualMessage.equals(expectedMessage)) {
			System.out.println("The New Legal Entity created sucessfully");
		} else {
			System.out.println("The New Legeal Entity not created");
		}
		return this;

	}

		
	}
	