package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.ProjectSpecificMethod;

public class EditWorkTypeGroupModel extends ProjectSpecificMethod {
	public EditWorkTypeGroupModel(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		this.actions = new Actions(driver);
	}

	public EditWorkTypeGroupModel edit_enterNewWTGName(String workTypeGroupName) {
		WebElement WTGName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[text()='Work Type Group Name'])/following::input[1]")));
		WTGName.clear();
		WTGName.sendKeys(workTypeGroupName);
		return this;
	}
	
	public EditWorkTypeGroupModel edit_enterNewWTGDescription(String Description) {
		WebElement WTGDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[text()='Description'])//following :: textarea")));
		WTGDescription.clear();
		WTGDescription.sendKeys(Description);
		return this;
	}
	
	public EditWorkTypeGroupModel edit_selectGroupType(String WTGGroupType) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//label[text()='Group Type']/following::div[1]")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//lightning-base-combobox-item//span[@class='slds-truncate' and contains(text(), '"+WTGGroupType+"')]"))).click();
		String selectedGroupType = driver.findElement(By.xpath("//button/span[@class='slds-truncate']")).getText();
		 
		if(selectedGroupType.equalsIgnoreCase(WTGGroupType))
			System.out.println(WTGGroupType+" Group Type is selected as expected.");
		else
			System.out.println(WTGGroupType+" is not selected, instead "+selectedGroupType+" is selected as Group Type, please check.");
		return this;
	}
	
	public WorkTypeGroupsPage edit_clickSave() {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		return new WorkTypeGroupsPage(driver);
	}
}
