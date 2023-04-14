package tasksPages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import commonPages.BasePage;

public class Task_commonPage extends BasePage {
	
	public void clickOnTasks() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[div[text()='Tasks']]")));
		driver.findElement(By.xpath("//a[div[text()='Tasks']]")).click();
	}
	
	public void clickOnFlighttab() {
	    driver.findElement(By.xpath("//div[@class='title']/div[text()='Flight operations']")).click();
	}
		
	public void createAddTask() throws InterruptedException {
		driver.findElement(By.xpath("(//div[text()='Add Task'])[1]")).click();
		Thread.sleep(3000);
	}
    
	public void fillDatainAddTAsk() throws InterruptedException{
		driver.findElement(By.xpath("(//div[@class='nameInput'])[5]/input")).sendKeys("User");
		Thread.sleep(3000);
	}
	
	public void clickOnCreateTask() throws InterruptedException {
		driver.findElement(By.xpath("(//div[text()='Add Task'])[3]")).click();
		Thread.sleep(3000);
	}
	
	public void selectAddedTask() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='titleEditButtonContainer']/div[text()='Flight operations']")));
		WebElement Table_1 = driver.findElement(By.xpath("//table[@class='taskRowsTable']"));
		Thread.sleep(3000);
		 List<WebElement> Rows = Table_1.findElements(By.tagName("tr"));
		    System.out.println("No. of rows: "+Rows.size());
		    for(int i=0; i<Rows.size();i++)
		    {
		        List<WebElement> Cols = Rows.get(i).findElements(By.tagName("td"));
		        for(int j=0; j<Cols.size();j++)
		        {
		            if(Cols.get(j).getText().contains("User"))
		            {
		                driver.findElement(By.xpath("(//div[@class='checkbox inactive'])[2]")).click();;
		                driver.findElement(By.xpath("//div[@class='title' and text()='User']"));
		                Thread.sleep(3000);
		            }
		        } 
		 }  
		}
	
	public void deleteTask() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='delete button' and text()='Delete']")));
		driver.findElement(By.xpath("//div[@class='delete button' and text()='Delete']")).click();
		Thread.sleep(3000);
	}
		
	public void popupdeleteTask() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Delete permanently']")));
		driver.findElement(By.xpath("//span[text()='Delete permanently']")).click();	
		Thread.sleep(3000);
	}
}
