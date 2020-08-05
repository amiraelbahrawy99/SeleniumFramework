package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id="small-searchterms")
	WebElement searchTxt;
	
	@FindBy(css="input.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	WebElement productTitle;
	
	@FindBy(id="ui-id-1")
	List<WebElement> productList;
	
	
	
	public void searchforProduct(String productName)
	{
		setElementText(searchTxt,productName);
		clickButton(searchBtn);
		
	}
	
	public void openProductDetailedpage() {
		clickButton(productTitle);
		
	}
	
	public void searchForProductWithAutoSuggest(String productName) throws InterruptedException
	{
		setElementText(searchTxt, productName);
		Thread.sleep(6000);
		productList.get(0).click();
		
	}
	

}
