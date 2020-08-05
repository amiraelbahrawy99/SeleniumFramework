package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase{


	HomePage homeObj;
	UserRegistrationPage userRegisterObj;
	MyAccountPage myAccountObj;
	LoginPage userLoginObj;
	String firstName="Amira";
	String lastName="Amin";
	String email="amok1@gmail.com";
	String oldPassword="123456";
	String newpassword="12345678";


	@Test(priority=1)
	public void userRegisterSuccessfuly() throws InterruptedException
	{
		homeObj=new HomePage(driver);
		homeObj.openRegisterationPage();
		Thread.sleep(6000);
		userRegisterObj=new UserRegistrationPage(driver);
		userRegisterObj.userRegistration(firstName, lastName, email, oldPassword);
		Assert.assertTrue(userRegisterObj.successmsg.getText().contains("Your registration completed"));

	}
	
	

	@Test(priority=2)
	public void registeredUserCanChangePassword() throws InterruptedException
	{
		Thread.sleep(6000);
		userRegisterObj=new UserRegistrationPage(driver);
		userRegisterObj.openMyAccountPage();
		myAccountObj=new MyAccountPage(driver);
		Thread.sleep(6000);
		myAccountObj.openChangePasswordPage();
		Thread.sleep(6000);
		myAccountObj.changepassword(oldPassword, newpassword);
		assertTrue(myAccountObj.successPasswordChangedMsg.getText().contains("Password was changed"));
	}

	
	@Test(priority=3)
	public void registerdUserCanLogout() throws InterruptedException
	{
		Thread.sleep(6000);
		userRegisterObj=new UserRegistrationPage(driver);
		userRegisterObj.userLogout();

	}

	@Test(priority=4)
	public void registeredUserCanLogin() throws InterruptedException
	{
		Thread.sleep(6000);
		homeObj=new HomePage(driver);
		homeObj.openLoginPage();
		userLoginObj=new LoginPage(driver);
		Thread.sleep(6000);

		userLoginObj.userLogin(email,newpassword);
		assertTrue(userRegisterObj.logoutlink.getText().equals("Log out"));

	}



}
