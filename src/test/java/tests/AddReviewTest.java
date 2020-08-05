package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddReviewPage;
import pages.HomePage;
import pages.ProductsDetailedPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class AddReviewTest extends TestBase{
	
	HomePage homeObj;
	UserRegistrationPage userRegisterObj;
	SearchPage searchObj;
	ProductsDetailedPage productsDetailedObj;
	AddReviewPage addReviewObj;
	
	String firstName="Amira";
	String lastName="Amin";
	String email="amd123@gmail.com";
	String Password="123456";
	String reviewTitle="Bad Product";
	String reviewText="This product has low quality,I didn't recommend it at all";
	
	
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
			Thread.sleep(6000);
			productsDetailedObj=new ProductsDetailedPage(driver);
			assertTrue(productsDetailedObj.currentItem.getText().equalsIgnoreCase("Apple MacBook Pro 13-inch"));
			System.out.println(productsDetailedObj.currentItem.getText());
}
	
	@Test(priority=3)
	public void registeredUserCanAddReview() throws InterruptedException {		
		productsDetailedObj=new ProductsDetailedPage(driver);
		productsDetailedObj.openAddReviewPage();
		Thread.sleep(4000);
		addReviewObj=new AddReviewPage(driver);
		addReviewObj.submitProductReview(reviewTitle, reviewText);
		Thread.sleep(4000);
		assertTrue(addReviewObj.reviewResult.getText().contains("Product review is"));
		System.out.println(addReviewObj.reviewResult.getText());

	}
	
	@Test(priority=4)
	public void registerdUserCanLogout() throws InterruptedException
	{
		Thread.sleep(4000);
		userRegisterObj=new UserRegistrationPage(driver);
		userRegisterObj.userLogout();

	}
	
	
	
	
	

}
