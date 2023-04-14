package commonPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public static WebDriver driver;
	public static WebDriverWait wait;

	public void openBrowser(String browserType) {
		if (browserType.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
//			else if(browserType.equalsIgnoreCase("Edge")) {
//				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\drivers\\edgeDriver_110.exe");
//				driver = new EdgeDriver();
//			}
//			else if(browserType.equalsIgnoreCase("Firefox")) {
//				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\drivers\\geckodriver_v32.2.exe");
//				driver= new FirefoxDriver();
//			}
	}

	public void launchApp(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);
	}

	public void loginToApp(String UN, String PWD) {
		driver.findElement(By.id("username")).sendKeys("shitalkumbhar9665@gmail.com");
		driver.findElement(By.name("pwd")).sendKeys(PWD);
		driver.findElement(By.id("keepLoggedInCheckBox")).click();
		driver.findElement(By.id("loginButton")).click();
	}

	public void logoutFromApp() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		driver.findElement(By.linkText("Logout")).click();
	}

	public void closeBrowser() {
		driver.quit();
	}

	public WebDriverWait getWebDriverWait() {
		return wait = new WebDriverWait(driver, 30);
	}

}
