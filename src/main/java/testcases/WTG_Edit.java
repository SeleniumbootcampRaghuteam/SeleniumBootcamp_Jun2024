package testcases;

import org.testng.annotations.*;
import base.ProjectSpecificMethod;
import pages.LoginPage;

public class WTG_Edit extends ProjectSpecificMethod {
	
	String uName;
	String pWord;
	
	@Parameters({"username","password"})
	@BeforeTest
	public void fetchVariables(String username, String password) {
		WTGfileName = "WorkTypeGroupName_Edit";
		uName = username;
		pWord = password;
		
	}	
	
	@Test(dataProvider = "WorkTypeGroupName")
	public void runWTGEdit(String WorkTypeGroupName) throws InterruptedException{
		System.out.println("Edit Work Type Group");
		new LoginPage(driver)
		.enterLogin(uName)
		.enterPassword(pWord)
		.clickLoginButton()
		.clickWaffle()
		.click_viewAllLink()
		.searchSelectWorkTypeGroups()
		.verifyWTGModel()
		.searchWorkTypeGroup(WorkTypeGroupName)
		.select_edit_WorkTypeGroup(WorkTypeGroupName)
		.edit_enterNewWTGDescription("Automation")
		.edit_selectGroupType("Capacity")
		.edit_clickSave()
		.verifyToastMessage()
		.verifyWTGDescription(WorkTypeGroupName);
		
	}

}
