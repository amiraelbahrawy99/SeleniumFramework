package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(id="BillingNewAddress_FirstName")
	WebElement firstNameTxt;

	@FindBy(id="BillingNewAddress_LastName")
	WebElement lastNameTxt;

	@FindBy(id="BillingNewAddress_Email")
	WebElement emaiTxt;

	@FindBy(id="BillingNewAddress_CountryId")
	WebElement countryList;

	@FindBy(id="BillingNewAddress_City")
	WebElement cityTxt;

	@FindBy(id="BillingNewAddress_Address1")
	WebElement address1Txt;

	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement postalCodeTxt;

	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phoneTxt;

	@FindBy(css="input.button-1.new-address-next-step-button")
	WebElement continueBtn;

	@FindBy(id="shippingoption_1")
	WebElement shippingMethodRd;

	@FindBy(css="input.button-1.shipping-method-next-step-button")
	WebElement continueShippingBtn;

	@FindBy(css="input.button-1.payment-method-next-step-button")
	WebElement continuePaymentBtn;

	@FindBy(css="input.button-1.payment-info-next-step-button")
	WebElement continueInfoBtn;

	@FindBy(css="a.product-name")
	public WebElement productName;


	@FindBy(css="input.button-1.confirm-order-next-step-button")
	WebElement confirmBtn;

	@FindBy(css="h1")
	public WebElement thankYouLbl;

	@FindBy(css="div.title")
	public WebElement successMsg;
	//Your order has been successfully processed!

	@FindBy(css="div.details-link")
	WebElement orderDetailsLink;

	@FindBy(css="input.button-1.checkout-as-guest-button")
	WebElement checkoutAsGuestBtn;
	
	
	

	public void registeredUserCheckoutProduct(String countryName,String city,String address,String postalCode,String phoneNumber)throws InterruptedException
	{
		select=new Select(countryList);
		select.selectByVisibleText(countryName);
		setElementText(cityTxt, city);
		setElementText(address1Txt, address);
		setElementText(postalCodeTxt, postalCode);
		setElementText(phoneTxt, phoneNumber);
		clickButton(continueBtn);
		Thread.sleep(3000);
		clickButton(shippingMethodRd);
		clickButton(continueShippingBtn);
		Thread.sleep(3000);
		clickButton(continuePaymentBtn);
		Thread.sleep(3000);
		clickButton(continueInfoBtn);

	}
	
	public void guestCheckoutProduct(String firstname,String lastName,String email,String countryName,String city,String address,String postalCode,String phoneNumber)throws InterruptedException
	{
		clickButton(checkoutAsGuestBtn);
		Thread.sleep(3000);
		setElementText(firstNameTxt,firstname);
		setElementText(lastNameTxt, lastName);
		setElementText(emaiTxt, email);
		select=new Select(countryList);
		select.selectByVisibleText(countryName);
		setElementText(cityTxt, city);
		setElementText(address1Txt, address);
		setElementText(postalCodeTxt, postalCode);
		setElementText(phoneTxt, phoneNumber);
		clickButton(continueBtn);
		Thread.sleep(3000);
		clickButton(shippingMethodRd);
		clickButton(continueShippingBtn);
		Thread.sleep(3000);
		clickButton(continuePaymentBtn);
		Thread.sleep(3000);
		clickButton(continueInfoBtn);

	}
	
	public void confirmOrder()
	{
		clickButton(confirmBtn);
	}
	
	
	public void viewOrderDetails()
	{
		
		clickButton(orderDetailsLink);
	}








}
