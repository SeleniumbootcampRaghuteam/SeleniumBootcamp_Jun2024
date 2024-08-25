package testcases;

import org.testng.annotations.*;
import base.ProjectSpecificMethod;
import pages.LoginPage;

public class WTG_Create extends ProjectSpecificMethod{
	String uName;
	String pWord;
	
	@Parameters({"username","password"})
	@BeforeTest
	public void fetchVariables(String username, String password) {
		WTGfileName = "WorkTypeGroupName_Create";
		excelSheetName = "Sheet1";
		uName = username;
		pWord = password;
		
	}
	
	@Test(dataProvider = "WorkTypeGroupName")
	public void runWTGCreate(String WorkTypeGroupName) throws InterruptedException{
		System.out.println("Create Work Type Group");
		new LoginPage(driver)
		.enterLogin(uName)
		.enterPassword(pWord)
		.clickLoginButton()
		.clickWaffle()
		.click_viewAllLink()
		.searchSelectWorkTypeGroups()
		.verifyWTGModel()
		.selectNewWTG()
		.verifyNewWTGModel()
		.enterNewWTGName(WorkTypeGroupName)
		.enterNewWTGDescription("Automation")
		.selectGroupType("Capacity")
		.clickSave_NoErrors()
		.verifyToastMessage();
		
	}

}
