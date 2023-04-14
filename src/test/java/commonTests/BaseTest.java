package commonTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import commonPages.BasePage;

public class BaseTest extends BasePage  {
	
	
	BasePage basePage= null;
	WebDriver driver;
	
	
	@BeforeSuite 
	public void loginToApp() {
		basePage = new BasePage();
		basePage.openBrowser("Chrome");
		basePage.launchApp("https://online.actitime.com/chevron/login.do");
		basePage.loginToApp("shitalkumbhar9665@gmail.com", "123456");
		basePage.getWebDriverWait();
	}
	
	@AfterSuite 
	public void logOutToApp() {
		basePage.logoutFromApp();
		basePage.closeBrowser();
	}
	}
		
