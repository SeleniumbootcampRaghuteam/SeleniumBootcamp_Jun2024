package com.framerwork.selenium.base;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.selenium.design.Browser;
import com.framework.selenium.design.Elements;

public class SeleniumBase implements Browser, Elements {

	public ChromeDriver driver;
	public ChromeOptions options;

	public WebElement getElementById(String idValue) {
		return driver.findElement(By.id(idValue));

	}

	public WebElement getElementByXPath(String xpathValue) {
		return driver.findElement(By.xpath(xpathValue));
	}

	public List<WebElement> getElementsByXPath(String xpathValue) {
		return driver.findElements(By.xpath(xpathValue));
	}

	public List<WebElement> getElementsByXPath(WebElement ele, String xpathValue) {
		return ele.findElements(By.xpath(xpathValue));
	}

	public WebElement getElementByXpath(WebElement ele, String xpathValue) {
		return ele.findElement(By.xpath(xpathValue));
	}

	public void sendKeys(WebElement element, String textValue) {
		element.sendKeys(textValue);

	}

	public void pressEnter(WebElement element) {
		element.sendKeys(Keys.ENTER);

	}

	public void click(WebElement element) {
		element.click();

	}

	public void clear(WebElement element) {
		element.clear();

	}

	public void jsClick(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

	}

	public void jsScrollDown(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public String elementgetText(WebElement element) {
		return element.getText();
	}

	public String getValueFromInput(WebElement element) {
		return element.getAttribute("value");
	}

	public void disableNotifications() {
		options = new ChromeOptions();

		options.addArguments("--disable-notifications");

	}

	public void browserInstantiate() {
		driver = new ChromeDriver(options);

	}

	public void browserMaximize() {
		driver.manage().window().maximize();

	}

	public void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

	}

	public void goToUrl(String url) {
		driver.get(url);

	}

	public void closeWindow() {
		driver.close();

	}

	public void quitBrowser() {
		driver.quit();

	}

	public void switchFrameByIndex(Integer index) {
		driver.switchTo().frame(index);

	}

	public void switchFrameByNameOrId(String nameOrId) {
		driver.switchTo().frame(nameOrId);

	}

	public void switchFrameByFrameLocator(By frameLocator) {
		WebElement frameElement = driver.findElement(frameLocator);
		driver.switchTo().frame(frameElement);

	}

	public void switchFrameToDefaultContent() {
		driver.switchTo().defaultContent();

	}

	public WebDriverWait createWebDriverWait(WebDriver driver, int timeoutInSeconds) {
		return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	}
	
	public void switchToWindow() {
		String WindowHandle = driver.getWindowHandle();

		Set<String> CurrentOpenedWindows = driver.getWindowHandles();
		for (String OpenWindow : CurrentOpenedWindows) {
			if (!OpenWindow.equals(WindowHandle)) {
				driver.switchTo().window(OpenWindow);
			}
		}
	}

}
