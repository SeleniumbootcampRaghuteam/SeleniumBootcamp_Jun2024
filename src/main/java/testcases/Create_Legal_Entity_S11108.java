package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class Create_Legal_Entity_S11108 extends ProjectSpecificMethod{
	@Test
	public void newlegalentity() throws InterruptedException {
        LoginPage lp=new LoginPage(driver);
		 
		lp.enterLogin("bootcamp_2024@testleaf.com")
		.enterPassword("Bootcamp@1234")
		.clickLoginButton()
		.clickWaffle()
		.click_viewAllLink().searchLegalEntityandClick().selectNewNLE().switchToNLEWindow().enterNewNLEName().clickSaveNLE().verifytoasterMsgNLE();
		
		
	}


	@BeforeTest
	public void setData()
	{
		excelFileName = "LegalEntityName";
	}
	
}
