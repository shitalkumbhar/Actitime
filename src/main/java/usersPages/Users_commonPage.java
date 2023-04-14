package usersPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import commonPages.BasePage;

public class Users_commonPage extends BasePage {
	public JavascriptExecutor js = (JavascriptExecutor)driver;
	public void clickOnUsers() {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[div[text()='Users']]")));
		driver.findElement(By.xpath("//a[div[text()='Users']]")).click();
	}
	
	public List<String> getUsersName(){
		List<WebElement> elements= null;
		List<String> userNames= new ArrayList<String>();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'userName')]")));
		elements = driver.findElements(By.xpath("//span[contains(@class,'userName')]"));
		for(WebElement element: elements) {
			userNames.add(element.getText().trim());
		}
		return userNames;
	}
	
	public List<String> getUsers_Department(List<String> users){
		List<WebElement> elements= null;
		List<String> departments= new ArrayList<String>();
		int i= 0;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'userName')]")));
		elements = driver.findElements(By.xpath("//span[contains(@class,'userName')]"));
		for(WebElement element: elements) {
			departments.add(driver.findElement(By.xpath("//div[span[contains(@class,'userName') and text()='"+users.get(i)+"']]/following-sibling::div/div[@class='groupName']")).getText().trim());
			i++;
		}
		return departments;
	}
	
	public void verify_Users_AND_Deparment(List<String> users, List<String> departments) {
		String value= null;
		String textValue= null;
		String deptValue= null;
		for(int i= 0; i<users.size(); i++) {
			driver.findElement(By.xpath("//span[contains(@class,'userName') and contains(text(),'"+users.get(i)+"')]")).click();
			String name[]= users.get(i).split(" ");
			value= name[1] + " " + name[0].substring(0,name[0].length()-2);
			System.out.println("name[0].length()-2 ===>" + (name[0].length()-2));
			System.out.println(name[0].substring(0,name[0].length()-1));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'nameInfo')])[1]")));
			textValue= driver.findElement(By.xpath("//div[contains(@class,'nameInfo') and contains(text(),'"+value+"')]")).getText();
			deptValue= driver.findElement(By.xpath("//div[contains(@class,'nameInfo') and contains(text(),'"+departments.get(i)+"')]")).getText();
			Assert.assertEquals(users.get(i), textValue);
			driver.findElement(By.xpath("(//div[@class='hideButton_panelContainer'])[1]")).click();
		}
	}
	
	public void createUser() throws InterruptedException {
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='New User']")));
		driver.findElement(By.xpath("//div[text()='New User']")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Add User']")));
		driver.findElement(By.id("createUserPanel_firstNameField")).click();
		driver.findElement(By.id("createUserPanel_firstNameField")).sendKeys("User");
		String lastName= java.time.LocalTime.now()+"";
		String arr[]= lastName.split(":");
		lastName="";
		for(String value:arr) {
			lastName= lastName+value;
		}
		driver.findElement(By.id("createUserPanel_lastNameField")).click();
		driver.findElement(By.id("createUserPanel_lastNameField")).sendKeys(lastName);
		driver.findElement(By.id("createUserPanel_emailField")).click();
		driver.findElement(By.id("createUserPanel_emailField")).sendKeys("User"+lastName+"@email.com");
		driver.findElement(By.xpath("//div[contains(text(),'Save & Send Invitation')]")).click();
	}
	
	public boolean confirm_UserCreation() {
		boolean status= false;
		if(driver.findElements(By.xpath("//div[contains(text(),'has been created')]")).size()>0) {
			status= true;
		}
		return status;
	}
	
	public void close_userCreation_PopUp() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='closeLink']")));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Close']")));
	}
}

