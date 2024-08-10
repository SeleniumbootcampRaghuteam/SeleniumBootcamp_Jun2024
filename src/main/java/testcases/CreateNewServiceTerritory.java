package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class CreateNewServiceTerritory extends ProjectSpecificMethod
{

	@Test(dataProvider="fetchData")
	public void createServiceTerritory(String name, String city, String state, String country, String pincode) throws InterruptedException
	{
	LoginPage lp = new LoginPage(driver);
	lp.enterLogin("bootcamp_2024@testleaf.com").enterPassword("Bootcamp@123").clickLoginButton().clickWaffle().click_viewAllLink().clickServiceTerritory().
	clickNew().enterName(name).checkActiveField().clickOperatingHours().enterCity(city).enterState(state).
	enterCountry(country).enterPincode(pincode).saveServiceTerritory().verifyServiceTerritory();
	}
	
	@BeforeTest
	public void setData()
	{
		excelFileName = "CreateServiceTerritory";
	}
	
}
