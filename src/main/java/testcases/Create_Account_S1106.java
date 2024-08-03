package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.AccountHomePage;
import pages.LoginPage;
import pages.NewAccountPage;

public class Create_Account_S1106 extends ProjectSpecificMethod {

	@Test
	public void createAccount() throws InterruptedException {
		
		LoginPage lp=new LoginPage();
		
		lp.enterLogin("bootcamp_2024@testleaf.com")
		.enterPassword("Bootcamp@123")
		.clickLoginButton()
		.clickWaffle()
		.click_viewAllLink()
		.searchSales()
		.click_SalesLink()
		.click_AccountTab()
		.click_NewButton();
		NewAccountPage na=new NewAccountPage();
		na.enter_AccountName()
		.scroll_untillOwnershipDropdow()
		.click_OwnershipDropdown()
		.select_Public()
		.click_saveButton().get_CreateAccountToastMessage();
		

		/*
		 * AccountHomePage ah=new AccountHomePage();
		 * 
		 * if(text1.contains("was created.")) { System.out.println(text1);
		 * if(set_Account_Name.equals(name)) {
		 * System.out.println("Account name verified successfully"); } else {
		 * System.out.println("Account name not verified successfully"); }
		 * 
		 * }else { System.out.println("Account not created"); }
		 */
		
		
		
	}
	
	
	
}
