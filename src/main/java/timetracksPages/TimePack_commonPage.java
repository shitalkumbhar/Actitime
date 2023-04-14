package timetracksPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import commonPages.BasePage;

public class TimePack_commonPage extends BasePage{
	public void clickOnTimeTrack() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[div[text()='Time-Track']]")));
		driver.findElement(By.xpath("//a[div[text()='Time-Track']]")).click();
	}
	
	public void clickOnTimeTrack_Submodule(String moduleName) {
		//Enter Time-Track //View Time-Track //Lock Time-Track //Approve Time-Track
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='secondLevelRow']//a[contains(text(),'"+moduleName+"')]")));
		driver.findElement(By.xpath("//tr[@class='secondLevelRow']//a[contains(text(),'"+moduleName+"')]")).click();
	}
	
	public void applyTask() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(@class,'WeekPicker-arrow')])[1]//*[local-name()='svg']/*[local-name()='path']")));
		driver.findElement(By.xpath("(//span[contains(@class,'WeekPicker-arrow')])[1]//*[local-name()='svg']/*[local-name()='path']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='ScrollbarsCustom trackYVisible']//div[contains(@class,'CalendarIntervalLabelsColumn')])[1]/following-sibling::div[position()=2]/div[position()=1]//button")));
		driver.findElement(By.xpath("(//div[@class='ScrollbarsCustom trackYVisible']//div[contains(@class,'CalendarIntervalLabelsColumn')])[1]/following-sibling::div[position()=2]/div[position()=1]//button"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'Search or select task')]")));
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search or select task')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'components-TaskItem-title')])[1]")));
		driver.findElement(By.xpath("(//div[contains(@class,'components-TaskItem-title')])[1]")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	
}
