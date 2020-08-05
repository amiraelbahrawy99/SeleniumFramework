package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductsDetailedPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {
	
	HomePage homeObj;
	SearchPage searchObj;
	ProductsDetailedPage productsDetailedObj;
	String productName="Apple MacBook Pro 13-inch";

	
	
	@Test(priority=1)
	public void userCanChangeCurrency()
	{
		homeObj=new HomePage(driver);
		homeObj.changeCUrrency();
	}
	
	
	@Test(priority=2)
	public void userCanSearchForProducts() throws InterruptedException
	{
		Thread.sleep(6000);
		searchObj=new SearchPage(driver);
		searchObj.searchforProduct(productName);
		Thread.sleep(4000);
		searchObj.openProductDetailedpage();
		Thread.sleep(6000);
		productsDetailedObj=new ProductsDetailedPage(driver);
		assertTrue(productsDetailedObj.currentItem.getText().equalsIgnoreCase("Apple MacBook Pro 13-inch"));
		assertTrue(productsDetailedObj.productPriceSign.getText().contains("Ђ"));
		System.out.println(productsDetailedObj.productPriceSign.getText());
		
	}
	

}
