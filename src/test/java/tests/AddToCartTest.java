package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AddToCartPage;
import pages.ProductsDetailedPage;
import pages.SearchPage;

public class AddToCartTest extends TestBase {


	SearchPage searchObj;
	ProductsDetailedPage productsDetailedObj;
	AddToCartPage addToCartObj;

	String productName="Apple MacBook Pro 13-inch";

	//I need to make it true to run separately
	@Test(priority=1,enabled=false)
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
	public void userCanChangeProductQty() throws InterruptedException 
	{
		addToCartObj=new AddToCartPage(driver);
		addToCartObj.updateQty("5");
		Thread.sleep(3000);
		assertTrue(addToCartObj.totalPriceLbl.getText().equals("$9,000.00"));
	}
	
	@Test(priority=4)
	public void userCanremoveProductFromCart() throws InterruptedException 
	{
		addToCartObj=new AddToCartPage(driver);
		addToCartObj.removeProductFromCart();
		Thread.sleep(3000);
		assertTrue(addToCartObj.emptyCartMsg.getText().equals("Your Shopping Cart is empty!"));
	}


}
