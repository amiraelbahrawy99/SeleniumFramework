package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ProductsDetailedPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductsToWishListTest extends TestBase {
	
	SearchPage searchObj;
	ProductsDetailedPage productsDetailedObj;
	WishListPage wishListObj;
	
	String productName="Apple MacBook Pro 13-inch";
	
	
	@Test(priority=1)
	public void userCanSearchWithAutoSuggest() throws InterruptedException 
	{

		Thread.sleep(4000);
		searchObj=new SearchPage(driver);
		searchObj.searchForProductWithAutoSuggest("macb");
		Thread.sleep(4000);
		productsDetailedObj=new ProductsDetailedPage(driver);
		assertTrue(productsDetailedObj.currentItem.getText().equalsIgnoreCase("Apple MacBook Pro 13-inch"));
		

}
	
	@Test(priority=2)
	public void userCanAddProductsToWishList() throws InterruptedException
	{
		Thread.sleep(6000);
		productsDetailedObj=new ProductsDetailedPage(driver);
		productsDetailedObj.addProductToWishList();
		Thread.sleep(4000);
		productsDetailedObj.openWishListPage();
		Thread.sleep(4000);
		wishListObj=new WishListPage(driver);
		assertTrue(wishListObj.wishlistHeader.isDisplayed());
		assertTrue(wishListObj.productCell.getText().contains(productName));

	}
	
	@Test(priority=3)
	public void userCanRemoveProductFromWishList() throws InterruptedException
	{
		Thread.sleep(4000);
		wishListObj=new WishListPage(driver);
		wishListObj.removeProductFromCart();
		Thread.sleep(4000);
		assertTrue(wishListObj.wishListEmptyMsg.getText().contains("The wishlist is empty"));
		System.out.println(wishListObj.wishListEmptyMsg.getText());

	}
	
	

}
