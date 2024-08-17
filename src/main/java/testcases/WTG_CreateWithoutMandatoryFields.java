package testcases;

import org.testng.annotations.*;
import base.ProjectSpecificMethod;
import pages.LoginPage;

public class WTG_CreateWithoutMandatoryFields extends ProjectSpecificMethod{

	String uName;
	String pWord;
	
	@Parameters({"username","password"})
	@BeforeTest
	public void fetchVariables(String username, String password) {
		uName = username;
		pWord = password;
		
	}
	@Test
	public void runWTGCreateWithoutMandatoryFields() throws InterruptedException{
		System.out.println("Create Work Type Group without mandatory fields");
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
		// skip enterNewWTGName(WorkTypeGroupName) to verify error on Save.
		.enterNewWTGDescription("Automation")
		.selectGroupType("Capacity")
		.clickSave_withErrors()
		.verifyWTGMandatoryError();
		
	}

}
