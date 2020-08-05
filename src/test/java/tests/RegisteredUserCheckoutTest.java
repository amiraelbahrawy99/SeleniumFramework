package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddToCartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductsDetailedPage;
import pages.SearchPage;
import pages.UserRegistrationPage;
import pages.orderDetailsPage;

public class RegisteredUserCheckoutTest extends TestBase {

	HomePage homeObj;
	UserRegistrationPage userRegisterObj;
	SearchPage searchObj;
	ProductsDetailedPage productsDetailedObj;
	AddToCartPage addToCartObj;
	CheckoutPage checkoutObj;
	orderDetailsPage orderDetailsObj;

	String productName="Apple MacBook Pro 13-inch";
	String firstName="Amira";
	String lastName="Amin";
	String email="ar2iu34@gmail.com";
	String Password="123456";
	String countryName ="Egypt";
	String city = "Damietta";
	String address ="Medan Sorour";
	String postalCode="56984";
	String phoneNumber="01054896212";


	@Test(priority=1,enabled=false)
	public void userRegisterSuccessfuly() throws InterruptedException
	{
		homeObj=new HomePage(driver);
		homeObj.openRegisterationPage();
		Thread.sleep(6000);
		userRegisterObj=new UserRegistrationPage(driver);
		userRegisterObj.userRegistration(firstName, lastName, email, Password);
		Assert.assertTrue(userRegisterObj.successmsg.getText().contains("Your registration completed"));

	}


	@Test(priority=2)
	public void userCanSearchWithAutoSuggest() throws InterruptedException 
	{
		Thread.sleep(2000);
		searchObj=new SearchPage(driver);
		productsDetailedObj=new ProductsDetailedPage(driver);
		searchObj.searchForProductWithAutoSuggest("macb");
		Thread.sleep(2000);
		assertTrue(productsDetailedObj.currentItem.getText().equalsIgnoreCase("Apple MacBook Pro 13-inch"));

	}

	@Test(priority=3)
	public void userCanAddProductToCart() throws InterruptedException 
	{
		productsDetailedObj=new ProductsDetailedPage(driver);
		addToCartObj=new AddToCartPage(driver);
		productsDetailedObj.addProductToCart();
		Thread.sleep(3000);
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		Thread.sleep(4000);
		assertTrue(addToCartObj.productNameCell.getText().equals("Apple MacBook Pro 13-inch"));
		assertTrue(addToCartObj.totalPriceLbl.getText().equals("$3,600.00"));

	}

	@Test(priority=4)
	public void userCanCheckout() throws InterruptedException 
	{
		addToCartObj=new AddToCartPage(driver);
		addToCartObj.openCheckoutPage();
		Thread.sleep(3000);
		checkoutObj=new CheckoutPage(driver);
		checkoutObj.registeredUserCheckoutProduct(countryName,city, address, postalCode, phoneNumber);
		assertTrue(checkoutObj.productName.isDisplayed());
		assertTrue(checkoutObj.productName.getText().equals("Apple MacBook Pro 13-inch"));
		
		checkoutObj.confirmOrder();
		Thread.sleep(3000);
		assertTrue(checkoutObj.thankYouLbl.isDisplayed());
		assertTrue(checkoutObj.successMsg.getText().equals("Your order has been successfully processed!"));
		checkoutObj.viewOrderDetails();
		Thread.sleep(3000);
		assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderDetailsObj=new orderDetailsPage(driver);
		orderDetailsObj.downloadPdfInvoice();
		Thread.sleep(6000);
		//orderDetailsObj.printOrderDetails();
		//Thread.sleep(2000);
		//assertTrue(driver.getCurrentUrl().contains("print"));

		

	}


	@Test(priority=5)
	public void registerdUserCanLogout() throws InterruptedException
	{
		Thread.sleep(3000);
		userRegisterObj=new UserRegistrationPage(driver);
		userRegisterObj.userLogout();

	}






}
