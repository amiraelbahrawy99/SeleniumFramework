package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareProductsPage extends PageBase{

	public CompareProductsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="a.clear-list")
	WebElement clearListBtn;
	
	@FindBy(css="table.compare-products-table")
	WebElement compareTable;
	
	@FindBy(tagName="tr")
	List<WebElement> allRows ;
	
	@FindBy(tagName="td")
	List<WebElement> allCoulmns;
	
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	public WebElement firstProductName;
	
	@FindBy(linkText="Asus N551JK-XO076H Laptop")
	public WebElement secondProductName;
	
	@FindBy(css="div.no-data")
	public WebElement emptyCompareListMsg;
	
	
	
	
	public void clearCompareList()
	{
		clickButton(clearListBtn);
	}
	
	
	public void compareProducts()
	{
		//Get all Rows
		System.out.println(allRows.size());
		
		//Get data from each Row
		
		for(WebElement row :allRows)
		{
			System.out.println(row.getText()+"\t");
			for(WebElement col :allCoulmns)
			{
				System.out.println(col.getText()+"\t");
			}
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
