package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jse=(JavascriptExecutor)driver;
		action=new Actions(driver);
	}

	@FindBy(linkText="Register")
	WebElement registerlink;

	@FindBy(css="a.ico-login")
	WebElement loginLink;

	@FindBy(linkText="Contact us")
	WebElement contactUsLink;
	
	@FindBy(id="customerCurrency")
	WebElement cstCurrencyList;
	
	@FindBy(linkText="Computers")
	WebElement computersMenu;
	
	
	@FindBy(linkText="Notebooks")
	WebElement noteBooksMenu;
	
	
	
	public void openRegisterationPage()
	{

		clickButton(registerlink);
	}


	public void openLoginPage()
	{

		clickButton(loginLink);
	}

	
	public void openContactUsPage()
	
	{
		scrollToBottom();
		clickButton(contactUsLink);
	}
	
	
	public void changeCUrrency()
	{
		select=new Select(cstCurrencyList);
		select.selectByVisibleText("Euro");
	}
	

	public void selectNoteBooksMenu()
	{
		action.moveToElement(computersMenu).perform();
		action.moveToElement(noteBooksMenu).click().perform();
		
	}
	
	
	
}
