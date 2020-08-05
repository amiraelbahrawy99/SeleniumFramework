package tests;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegestrationTestWithDDtAndDataProvider extends TestBase{
	
	
	HomePage homeObj;
	UserRegistrationPage userRegisterObj;
	LoginPage userLoginObj;

	
	@DataProvider(name="testData")
	
	public static Object[][] userData()
	{
		
		return new Object[][]{
			
			{"Amira","Amin","amira3@gmail.com","123456"},
			
			{"Adel","Amin","adel1@gmail.com","123456"}
		};
	}

		
	@Test(priority=1,alwaysRun=true,dataProvider="testData")
	public void userRegisterSuccessfuly(String firstName,String lastName,String email,String Password) throws InterruptedException
	{
		Thread.sleep(1000);
		homeObj=new HomePage(driver);
		homeObj.openRegisterationPage();
		Thread.sleep(6000);
		userRegisterObj=new UserRegistrationPage(driver);
		userRegisterObj.userRegistration(firstName, lastName, email, Password);
		Assert.assertTrue(userRegisterObj.successmsg.getText().contains("Your registration completed"));
		Thread.sleep(1000);
		userRegisterObj.userLogout();
		Thread.sleep(1000);
		homeObj.openLoginPage();
		Thread.sleep(1000);
		userLoginObj=new LoginPage(driver);
		userLoginObj.userLogin(email, Password);
		assertTrue(userRegisterObj.logoutlink.getText().equals("Log out"));
		Thread.sleep(1000);
		userRegisterObj.userLogout();
		Thread.sleep(1000);

	}





	
		
	
	

	
	
	
	

}






