package tasksTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import commonTests.BaseTest;
import tasksPages.Task_commonPage;
import usersPages.Users_commonPage;

public class Task_Verification extends BaseTest {
	Task_commonPage tasks_commonPage= null;  

	@BeforeClass
	public void TasksBase() {
		tasks_commonPage= new Task_commonPage();
		tasks_commonPage.clickOnTasks();
	}
	@Test(priority=1)
	private void FlightOperations() {
		tasks_commonPage.clickOnFlighttab();
	}
	@Test(priority=2)
	public void AddTask() throws InterruptedException {
		
		tasks_commonPage.createAddTask();
	}
	@Test(priority=3)
	public void EnterName() throws InterruptedException{
		tasks_commonPage.fillDatainAddTAsk();
	}	
	@Test (priority=4)
	public void CreateTask() throws InterruptedException
	{
		tasks_commonPage. clickOnCreateTask();
	}
	
	@Test (priority=5)
	public void SelectTask() throws InterruptedException
	{
		tasks_commonPage.selectAddedTask();
	}
	
	@Test (priority=6)
	public void DeleteTask() throws InterruptedException
	{
		tasks_commonPage.deleteTask();
	}
	
	@Test (priority=7)
	public void popupDeletemessage() throws InterruptedException {
		tasks_commonPage.popupdeleteTask();
	}
}
