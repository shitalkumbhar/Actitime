package usersTests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonTests.BaseTest;
import usersPages.Users_commonPage;

public class Users_Verification extends BaseTest {
	Users_commonPage users_commonPage= null;
	
	@BeforeMethod
	public void UsersBase() {
		users_commonPage= new Users_commonPage();
		users_commonPage.clickOnUsers();
	}	
	@Test
	public void verify_ListOfUsers() {
		List<String> users= users_commonPage.getUsersName();
		List<String> departments=  users_commonPage.getUsers_Department(users);
		users_commonPage.verify_Users_AND_Deparment(users, departments);
	 }			
	@Test
	public void create_User() throws InterruptedException {
		users_commonPage.createUser();
		boolean status= users_commonPage.confirm_UserCreation();
		Assert.assertTrue(status,"User not created");
		users_commonPage.close_userCreation_PopUp();
	}
}
