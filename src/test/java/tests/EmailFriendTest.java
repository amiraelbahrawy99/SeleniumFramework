package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendpage;
import pages.HomePage;
import pages.ProductsDetailedPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase{

	HomePage homeObj;
	UserRegistrationPage userRegisterObj;
	SearchPage searchObj;
	ProductsDetailedPage productsDetailedObj;
	EmailFriendpage emailFriendObj;

	String firstName="Amira";
	String lastName="Amin";
	String email="amdafdds8@gmail.com";
	String Password="123456";
	String productName="Apple MacBook Pro 13-inch";
	String friendEmail="Noora@yahoo.com";
	String personalMsg="Have a look ,you may like it";		

	@Test(priority=1)
	public void userRegisterSuccessfuly() throws InterruptedException
	{
		homeObj=new HomePage(driver);
		homeObj.openRegisterationPage();
		Thread.sleep(4000);
		userRegisterObj=new UserRegistrationPage(driver);
		userRegisterObj.userRegistration(firstName, lastName, email, Password);
		Assert.assertTrue(userRegisterObj.successmsg.getText().contains("Your registration completed"));
		System.out.println(userRegisterObj.successmsg.getText());

	}


	@Test(priority=2)
	public void userCanSearchWithAutoSuggest() throws InterruptedException 
	{

			Thread.sleep(4000);
			searchObj=new SearchPage(driver);
			searchObj.searchForProductWithAutoSuggest("macb");
			Thread.sleep(8000);
			productsDetailedObj=new ProductsDetailedPage(driver);
			assertTrue(productsDetailedObj.currentItem.getText().equalsIgnoreCase("Apple MacBook Pro 13-inch"));
			System.out.println(productsDetailedObj.currentItem.getText());

}


	@Test(priority=3)
	public void registeredUserCanEmailFriendWithProduct() throws InterruptedException
	{
		Thread.sleep(4000);
		productsDetailedObj=new ProductsDetailedPage(driver);
		productsDetailedObj.openEmailFriendPage();
		Thread.sleep(4000);
		emailFriendObj=new EmailFriendpage(driver);
		emailFriendObj.emailAFriend(friendEmail, personalMsg);
		Thread.sleep(4000);
		assertTrue(emailFriendObj.successEmailMsg.getText().equals("Your message has been sent."));
		System.out.println(emailFriendObj.successEmailMsg.getText());

	}

	
	@Test(priority=4)
	public void registerdUserCanLogout() throws InterruptedException
	{
		Thread.sleep(4000);
		userRegisterObj=new UserRegistrationPage(driver);
		userRegisterObj.userLogout();

	}





}
