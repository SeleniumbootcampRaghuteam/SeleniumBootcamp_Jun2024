package pages;

import org.openqa.selenium.By;

public class Edit_AccountPage {

	By clickEditDropDown=By.xpath("((//table)[1]/tbody//td[5]//div[1]/a)[1]");
	By clickEdit=By.xpath("//div[text()='Edit']/..");
	By enter_name=By.xpath("//label[text()='Phone']/following-sibling::div/input"); //
	By locateType = By.xpath("//label[text()='Type']/following-sibling::div//div//div//button//span[text()='--None--']");
	
}
