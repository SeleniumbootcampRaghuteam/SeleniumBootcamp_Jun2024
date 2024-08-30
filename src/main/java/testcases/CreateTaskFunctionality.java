package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class CreateTaskFunctionality extends ProjectSpecificMethod

{

	@Test
	public void runCreateTask() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterLogin("bootcamp_2024@testleaf.com").enterPassword("Bootcamp@1234").clickLoginButton().clickGlobalActionIcon().clickNewTask().enterSubjectInNewTask().selectContactInNewTask().selectStatusInNewTask().saveTask().verifyTask();
	}
}
	