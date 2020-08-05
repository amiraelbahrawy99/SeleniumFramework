package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndExcel extends TestBase{

	HomePage homeObj;
	UserRegistrationPage userRegisterObj;
	LoginPage userLoginObj;

	
	@DataProvider(name="ExcelData")
	public Object[][] userRegistrationData() throws IOException
	{
		ExcelReader ER=new ExcelReader();
		return ER.getExcelData();


	}


	@Test(priority=1,alwaysRun=true,dataProvider="ExcelData")
	public void userRegisterSuccessfuly(String Fname,String Lname,String email,String password) throws InterruptedException
	{
		Thread.sleep(3000);
		homeObj=new HomePage(driver);
		homeObj.openRegisterationPage();
		Thread.sleep(4000);
		userRegisterObj=new UserRegistrationPage(driver);
		userRegisterObj.userRegistration(Fname, Lname, email, password);
		Assert.assertTrue(userRegisterObj.successmsg.getText().contains("Your registration completed"));
		Thread.sleep(2000);
		userRegisterObj=new UserRegistrationPage(driver);
		userRegisterObj.userLogout();
		Thread.sleep(2000);
		homeObj.openLoginPage();
		userLoginObj=new LoginPage(driver);
		userLoginObj.userLogin(email, password);
		assertTrue(userRegisterObj.logoutlink.getText().equals("Log out"));
		Thread.sleep(1000);
		userRegisterObj.userLogout();
		Thread.sleep(1000);

	}


}
