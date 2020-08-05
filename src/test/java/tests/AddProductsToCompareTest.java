package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.CompareProductsPage;
import pages.ProductsDetailedPage;
import pages.SearchPage;

public class AddProductsToCompareTest extends TestBase {

	SearchPage searchObj;
	ProductsDetailedPage productsDetailedObj;
	CompareProductsPage compareObj;

	String firstProduct="Apple MacBook Pro 13-inch";
	String secondProduct="Asus N551JK-XO076H Laptop";


	@Test(priority=1)
	public void userCanCompareProducts() throws InterruptedException
	{
		searchObj=new SearchPage(driver);
		productsDetailedObj=new ProductsDetailedPage(driver);
		compareObj=new CompareProductsPage(driver);

		// 1- Search for product number 1  & Add to compare
		Thread.sleep(3000);
		searchObj.searchForProductWithAutoSuggest(firstProduct);
		Thread.sleep(2000);
		productsDetailedObj.addProductToCompareList();
		Thread.sleep(2000);

		// 2- Search for product number 2
		searchObj.searchForProductWithAutoSuggest(secondProduct);
		Thread.sleep(2000);
		productsDetailedObj.addProductToCompareList();
		Thread.sleep(2000);
		driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
		Thread.sleep(3000);
		assertTrue(compareObj.firstProductName.getText().equals("Apple MacBook Pro 13-inch"));
		assertTrue(compareObj.secondProductName.getText().equals("Asus N551JK-XO076H Laptop"));
		Thread.sleep(3000);
		compareObj.compareProducts();

	}

	@Test(priority=2)

	public void userCanClearCompareList() throws InterruptedException
	{
		compareObj=new CompareProductsPage(driver);
		compareObj.clearCompareList();
		Thread.sleep(2000);
		assertTrue(compareObj.emptyCompareListMsg.getText().equals("You have no items to compare."));

	}










}
