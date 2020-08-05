package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(css="input.email")
	WebElement emailtxt;
	
	@FindBy(css="input.password")
	WebElement passwordtxt;
	
	@FindBy(css="input.button-1.login-button")
	WebElement loginbtn;
	
	public void userLogin(String email,String password) throws InterruptedException
	{
		Thread.sleep(3000);
		setElementText(emailtxt, email);
		setElementText(passwordtxt, password);
		clickButton(loginbtn);
		
	}

}
