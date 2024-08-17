package testcases;

import org.testng.annotations.*;
import base.ProjectSpecificMethod;
import pages.LoginPage;

public class WTG_Delete extends ProjectSpecificMethod {
	
	String uName;
	String pWord;
	
	@Parameters({"username","password"})
	@BeforeTest
	public void fetchVariables(String username, String password) {
		WTGfileName = "WorkTypeGroupName_Delete";
		uName = username;
		pWord = password;
		
	}	
	
	@Test(dataProvider = "WorkTypeGroupName")
	public void runWTGDelete(String WorkTypeGroupName) throws InterruptedException{
		System.out.println("Delete Work Type Group");
		new LoginPage(driver)
		.enterLogin(uName)
		.enterPassword(pWord)
		.clickLoginButton()
		.clickWaffle()
		.click_viewAllLink()
		.searchSelectWorkTypeGroups()
		.verifyWTGModel()
		.searchWorkTypeGroup(WorkTypeGroupName)
		.select_delete_WorkTypeGroup(WorkTypeGroupName)
		.verifyToastMessage()
		.searchWorkTypeGroup(WorkTypeGroupName)
		.verifyWTGDeletionAction(WorkTypeGroupName);
	}

}
