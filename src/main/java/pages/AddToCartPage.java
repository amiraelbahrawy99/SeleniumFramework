package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends PageBase {

	public AddToCartPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(name="removefromcart")
	WebElement removeFromCartCheck;
	
	@FindBy(css="a.product-name")
	public WebElement productNameCell;
	
	@FindBy(css="input.qty-input")
	WebElement QtyTxt;
	
	@FindBy(css="input.button-2.update-cart-button")
	WebElement updateCartBtn;
	
	@FindBy(css="span.product-subtotal")
	public WebElement totalPriceLbl;
	
	@FindBy(css="div.no-data")
	public WebElement emptyCartMsg;
	
	
	@FindBy(id="termsofservice")
	WebElement termsOfServiceCheckBtn;
	
	@FindBy(id="checkout")
	WebElement CheckoutBtn;
	
	
	
	public void removeProductFromCart()
	{
		clickButton(removeFromCartCheck);
		clickButton(updateCartBtn);
		
	}
	
	
	public void updateQty(String Qty)
	{
		clearText(QtyTxt);
		setElementText(QtyTxt,Qty);
		clickButton(updateCartBtn);
	}
	
	
	public void openCheckoutPage()
	{
		
		clickButton(termsOfServiceCheckBtn);
		clickButton(CheckoutBtn);
		
	}
	
	
	

}
