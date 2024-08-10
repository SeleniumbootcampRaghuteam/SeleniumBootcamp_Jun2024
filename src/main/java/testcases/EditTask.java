package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class EditTask extends ProjectSpecificMethod 
{
	@Test
	public void runEditTask() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterLogin("bootcamp_2024@testleaf.com").enterPassword("Bootcamp@123").clickLoginButton().clickWaffle().click_viewAllLink().searchSales().click_SalesLink().clickTaskTab().recentlyViewedTasks().showMoreActions().clickEdit().selectDate().selectPriority().clickSave().verifyEditTask();
		
	}
}
