package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.AccountHomePage;
import pages.LoginPage;

public class Edit_Account_S1107 extends ProjectSpecificMethod {

	
	@Test
	public void edit_Account() throws InterruptedException {
		
		LoginPage lp=new LoginPage(driver);
		
		lp.enterLogin("bootcamp_2024@testleaf.com")
		.enterPassword("Bootcamp@1234")
		.clickLoginButton()
		.clickWaffle()
		.click_viewAllLink()
		.searchSales()
		.click_SalesLink()
		.click_AccountTab();
		
		AccountHomePage ah=new AccountHomePage(driver);
		ah.ParentSearch().childSearch();
	
}
}
