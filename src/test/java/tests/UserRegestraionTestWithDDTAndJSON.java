package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JSONReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegestraionTestWithDDTAndJSON extends TestBase{

	HomePage homeObj;
	UserRegistrationPage userRegisterObj;
	LoginPage userLoginObj;



	@Test(priority=1,alwaysRun=true)
	public void userRegisterSuccessfuly() throws InterruptedException, IOException, ParseException
	{
		JSONReader JSONReaderObj=new JSONReader();
		JSONReaderObj.JSONDataReader();
		
		Thread.sleep(3000);
		homeObj=new HomePage(driver);
		homeObj.openRegisterationPage();
		Thread.sleep(4000);
		userRegisterObj=new UserRegistrationPage(driver);
		userRegisterObj.userRegistration(JSONReaderObj.firstName, JSONReaderObj.lastName, JSONReaderObj.email, JSONReaderObj.password);
		Assert.assertTrue(userRegisterObj.successmsg.getText().contains("Your registration completed"));
		Thread.sleep(2000);
		userRegisterObj=new UserRegistrationPage(driver);
		userRegisterObj.userLogout();
		Thread.sleep(2000);
		homeObj.openLoginPage();
		userLoginObj=new LoginPage(driver);
		userLoginObj.userLogin(JSONReaderObj.email, JSONReaderObj.password);
		assertTrue(userRegisterObj.logoutlink.getText().equals("Log out"));
		Thread.sleep(1000);
		userRegisterObj.userLogout();
		Thread.sleep(1000);

	}



}
