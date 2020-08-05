package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsDetailedPage extends PageBase {

	public ProductsDetailedPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(css="strong.current-item")
	public WebElement currentItem;

	@FindBy(css="div.email-a-friend")
	WebElement emailFriendLink;

	@FindBy(id="price-value-4")
	public WebElement productPriceSign;

	@FindBy(linkText="Add your review")
	WebElement addReviewLink;

	//@FindBy(id="add-to-wishlist-button-4")
	@FindBy(css="input.button-2.add-to-wishlist-button.valid")
	WebElement addToWishlistBtn;
	
	@FindBy(linkText="wishlist")
	WebElement wishListLink;

	@FindBy(css="div.compare-products")
	WebElement addTOCompareBtn;
	

	@FindBy(id="add-to-cart-button-4")
	WebElement addToCartBtn;
	
	
	public void openEmailFriendPage()
	{

		clickButton(emailFriendLink);		
	}


	public void openAddReviewPage()
	{

		clickButton(addReviewLink);
	}

	public void addProductToWishList()
	{
		clickButton(addToWishlistBtn);
		
	}
	public void openWishListPage()
	{
		clickButton(wishListLink);
		
	}
	
	public void addProductToCompareList()
	{
		clickButton(addTOCompareBtn);
		
	}
	
	
	public void addProductToCart()
	{
		clickButton(addToCartBtn);
		
	}
	
	

}
