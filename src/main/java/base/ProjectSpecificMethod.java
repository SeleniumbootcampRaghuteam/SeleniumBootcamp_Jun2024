package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.framerwork.selenium.base.SeleniumBase;

import utils.ReadData;


public class ProjectSpecificMethod extends SeleniumBase {
	
	public static WebDriver driver;
	public JavascriptExecutor executor;
	public String excelFileName;
	public static Properties prop;
	public Actions actions;
	public String fileName;
	public WebDriverWait wait;
	
	public static WebElement waitForElement(WebDriver driver, By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		return driver.findElement(locator);
	}

	public static WebElement waitForElement2(WebDriver driver, By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));	
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator);
	}

	static Random rand=new Random();
	public static String set_Account_Name = "Yamuna" + rand.nextInt();
	
	@Parameters({"browser","url"})
	@BeforeMethod
	public void preCondition(String lang, String url) throws IOException 
	{
		FileInputStream fis = new FileInputStream("./src/main/resources/config.en.properties");
		prop = new Properties();
		prop.load(fis);
		
		if(lang.equals("chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			driver = new ChromeDriver(option);
		}
		else if(lang.equals("edge")) {
		EdgeOptions option = new EdgeOptions();
			option.addArguments("--disable-notifications");
			driver = new EdgeDriver(option);
		}
		
		else if(lang.equals("firefox")) {
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("--disable-notifications");
			driver = new FirefoxDriver(option);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);

	}

	@AfterMethod
	public void postCondition() {
            driver.quit();
	}
	
	@DataProvider(name="fetchData")
	public String[][] getData() throws IOException
	{
		return utils.ReadExcelData.readExcel(excelFileName);
	}
	

}
