package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegestraionTest extends TestBase{

	HomePage homeObj;
	UserRegistrationPage userRegisterObj;
	LoginPage userLoginObj;
	String firstName="Amira";
	String lastName="Amin";
	String email="amdfcgf@gmail.com";
	String Password="123456";


	@Test(priority=1,alwaysRun=true)
	public void userRegisterSuccessfuly() throws InterruptedException
	{
		Thread.sleep(1000);
		homeObj=new HomePage(driver);
		homeObj.openRegisterationPage();
		Thread.sleep(6000);
		userRegisterObj=new UserRegistrationPage(driver);
		userRegisterObj.userRegistration(firstName, lastName, email, Password);
		Assert.assertTrue(userRegisterObj.successmsg.getText().contains("Your registration completed"));
		Thread.sleep(1000);

	}

	@Test(priority=2)
	public void registerdUserCanLogout() throws InterruptedException
	{
		Thread.sleep(1000);
		userRegisterObj=new UserRegistrationPage(driver);
		userRegisterObj.userLogout();
		Thread.sleep(1000);

	}


	@Test(priority=3)
	public void registeredUserCanLogin() throws InterruptedException
	{
		Thread.sleep(1000);
		homeObj=new HomePage(driver);
		homeObj.openLoginPage();
		userLoginObj=new LoginPage(driver);
		userLoginObj.userLogin(email, Password);
		assertTrue(userRegisterObj.logoutlink.getText().equals("Log out"));
		Thread.sleep(1000);
	}




}
