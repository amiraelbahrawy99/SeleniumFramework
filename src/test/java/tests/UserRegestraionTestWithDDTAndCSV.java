package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegestraionTestWithDDTAndCSV extends TestBase{

	HomePage homeObj;
	UserRegistrationPage userRegisterObj;
	LoginPage userLoginObj;

	CSVReader reader;


	@Test(priority=1,alwaysRun=true)
	public void userRegisterSuccessfuly() throws InterruptedException, CsvValidationException, IOException
	{
		String CSVPath=System.getProperty("user.dir")+"\\src\\test\\java\\data\\registerData.csv";
		reader=new CSVReader(new FileReader(CSVPath));
		String[] csvCell;
		
		while((csvCell=reader.readNext())!=null)
		{
			String Fname=csvCell[0];
			String Lname=csvCell[1];
			String email=csvCell[2];
			String password=csvCell[3];
			
			Thread.sleep(3000);
			homeObj=new HomePage(driver);
			homeObj.openRegisterationPage();
			Thread.sleep(4000);
			userRegisterObj=new UserRegistrationPage(driver);
			userRegisterObj.userRegistration(Fname, Lname, email, password);
			Assert.assertTrue(userRegisterObj.successmsg.getText().contains("Your registration completed"));
			Thread.sleep(4000);
			userRegisterObj=new UserRegistrationPage(driver);
			userRegisterObj.userLogout();
			Thread.sleep(6000);
			homeObj.openLoginPage();
			userLoginObj=new LoginPage(driver);
			userLoginObj.userLogin(email, password);
			assertTrue(userRegisterObj.logoutlink.getText().equals("Log out"));
			Thread.sleep(6000);
			userRegisterObj.userLogout();
			Thread.sleep(4000);
			
		}
		
		
		
	

	}





}
