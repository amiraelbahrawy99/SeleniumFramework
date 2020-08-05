package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AddToCartPage;
import pages.CheckoutPage;
import pages.ProductsDetailedPage;
import pages.SearchPage;
import pages.orderDetailsPage;

public class GuestCheckoutTest extends TestBase {
	
	SearchPage searchObj;
	ProductsDetailedPage productsDetailedObj;
	AddToCartPage addToCartObj;
	CheckoutPage checkoutObj;
	orderDetailsPage orderDetailsObj;
	String countryName ="Egypt";
	String city = "Damietta";
	String address ="Medan Sorour";
	String postalCode="56984";
	String phoneNumber="01054896212";
	String firstName="Adel";
	String lastName="Amin";
	String email="adel123@gmail.com";
	
	@Test(priority=1)
	public void userCanSearchWithAutoSuggest() throws InterruptedException 
	{
		Thread.sleep(2000);
		searchObj=new SearchPage(driver);
		productsDetailedObj=new ProductsDetailedPage(driver);
		searchObj.searchForProductWithAutoSuggest("macb");
		Thread.sleep(2000);
		assertTrue(productsDetailedObj.currentItem.getText().equalsIgnoreCase("Apple MacBook Pro 13-inch"));

	}

	@Test(priority=2)
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

	
	@Test(priority=3)
	public void guestCanCheckout() throws InterruptedException 
	{
		addToCartObj=new AddToCartPage(driver);
		addToCartObj.openCheckoutPage();
		Thread.sleep(3000);
		checkoutObj=new CheckoutPage(driver);
		checkoutObj.guestCheckoutProduct(firstName,lastName,email,countryName,city, address, postalCode, phoneNumber);
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

}
