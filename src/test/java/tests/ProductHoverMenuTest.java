package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase{
	
	HomePage homeObj;
	
	@Test
	public void userCanSelectSubCategoryFromMenu() throws InterruptedException
	{
		homeObj=new HomePage(driver);
		homeObj.selectNoteBooksMenu();
		Thread.sleep(6000);
		assertTrue(driver.getCurrentUrl().contains("notebooks"));
		System.out.println(driver.getCurrentUrl());
		
	}
	
	
	
	
	
	

}
