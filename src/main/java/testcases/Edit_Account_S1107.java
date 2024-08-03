package testcases;

import org.testng.annotations.Test;

import pages.AccountHomePage;
import pages.LoginPage;

public class Edit_Account_S1107 {

	
	@Test
	public void edit_Account() throws InterruptedException {
		
		LoginPage lp=new LoginPage();
		
		lp.enterLogin("bootcamp_2024@testleaf.com")
		.enterPassword("Bootcamp@123")
		.clickLoginButton()
		.clickWaffle()
		.click_viewAllLink()
		.searchSales()
		.click_SalesLink()
		.click_AccountTab();
		
		AccountHomePage ah=new AccountHomePage();
		ah.ParentSearch().childSearch();
	
}
}
