package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ProductsDetailedPage;
import pages.SearchPage;

public class SearchProductWithAutoSuggestionTest extends TestBase {
	
	SearchPage searchObj;
	ProductsDetailedPage productsDetailedObj;
	
	String productName="Apple MacBook Pro 13-inch";
	
	
	@Test
	public void userCanSearchWithAutoSuggest() 
	{
		
		try {
			Thread.sleep(4000);
			searchObj=new SearchPage(driver);
			searchObj.searchForProductWithAutoSuggest("macb");
			Thread.sleep(4000);
			productsDetailedObj=new ProductsDetailedPage(driver);
			assertTrue(productsDetailedObj.currentItem.getText().equalsIgnoreCase("Apple MacBook Pro 13-inch"));
			
		} catch (InterruptedException e) {
			System.out.print("Error Occurred "+e.getMessage());
		}
		
		
	}
	
	
	
	
	

}
