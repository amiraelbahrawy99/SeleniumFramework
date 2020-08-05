package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="h1")
	public WebElement wishlistHeader;
	
	@FindBy(css="td.product")
	public WebElement productCell;
	
	@FindBy(name="removefromcart")
	public WebElement removeFromCartCheck;
	
	@FindBy(name="updatecart")
	public WebElement updateCartBtn;
	
	
	@FindBy(css="div.no-data")
	public WebElement wishListEmptyMsg;
	
	
	public void removeProductFromCart()
	{
		clickButton(removeFromCartCheck);
		clickButton(updateCartBtn);
		
	}
	
	
	
	
	

}
