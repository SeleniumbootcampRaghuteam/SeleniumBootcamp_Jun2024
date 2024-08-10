package testcases;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.HomePage;
import pages.LoginPage;

public class CreateTaskFunctionality extends ProjectSpecificMethod

{

	@Test
	public void runCreateTask() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterLogin("bootcamp_2024@testleaf.com").enterPassword("Bootcamp@123").clickLoginButton().clickGlobalActionIcon().clickNewTask().enterSubjectInNewTask().selectContactInNewTask().selectStatusInNewTask().saveTask().verifyTask();
	}
}
	