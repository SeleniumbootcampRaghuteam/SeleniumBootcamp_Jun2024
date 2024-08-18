package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class S11_15_CreateNewDashboard extends ProjectSpecificMethod {
	
	
	@BeforeTest
	public void setValues() {
		excelFileName = "DashboardData";
		excelSheetName = "createdashboard";
	}
	
	@Parameters({ "username", "password" })
	@Test(dataProvider = "fetchData")
	public void newDashboard(String dashboardName, String searchDashboardText, String username, String password) throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.enterLogin(username)
		.enterPassword(password)
		.clickLoginButton().clickWaffle().click_viewAllLink().searchItems("Dashboards").clickDashboardsLink()
				.clickNewDashboardOption().switchToNewDashboardFrame().enterNewDashboardName(dashboardName).clickCreateButton()
				.switchToSaveDashboardPage(driver).switchToFrameClickSaveButton(driver,wait).clickSaveDashboardButton().switchToDefaultContent()
				.clickTheDashboardsTab().searchRecentDashboards(searchDashboardText).getNewDashboardName().verifyIfNewDashboardNameIsCreated(dashboardName);

	}
}
