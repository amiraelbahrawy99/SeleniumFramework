package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	
	protected WebDriver driver;
	public JavascriptExecutor jse;
	public Actions action;
		
	//to be shared between classes
	public Select select;
	
	//Create Constructor to initialize elements using PageFactory
	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	protected static void clickButton(WebElement btn)
	{
		btn.click();
	}
	
	protected static void setElementText(WebElement txtElemnt,String text)
	{
		
		txtElemnt.sendKeys(text);
	}
	
	protected static void clearText(WebElement element)
	{
		element.clear();
	}
	
	
	public void scrollToBottom()
	{
	jse.executeScript("scrollBy(0,2500)"); //scroll to the bottom

		
		
	}
}
