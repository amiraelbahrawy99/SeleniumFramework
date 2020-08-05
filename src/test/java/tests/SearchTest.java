package tests;


import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ProductsDetailedPage;
import pages.SearchPage;

public class SearchTest extends TestBase{
	
	SearchPage searchObj;
	ProductsDetailedPage productsDetailedObj;
	
	
	String productName="Apple MacBook Pro 13-inch";
	
	@Test
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
		
	}
	
	
	
	
	
	
	
	

}
