package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethod;

public class LoginPage extends ProjectSpecificMethod {

	/*
	 * public LoginPage(WebDriver driver) { this.driver=driver; }
	 */

	By locate_loginField = By.id("username");
	By locate_passwordField = By.id("password");
	By locate_loginButton = By.id("Login");

	public LoginPage enterLogin(String user) {
		driver.findElement(locate_loginField).sendKeys(user);
		return this;

	}

	public LoginPage enterPassword(String pass) {
		driver.findElement(locate_passwordField).sendKeys(pass);
		return this;

	}

	public HomePage clickLoginButton() {

		driver.findElement(locate_loginButton).click();
		return new HomePage();

	}

}
