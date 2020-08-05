package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase{

	public UserRegistrationPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id="gender-female")
	WebElement genderBtn;

	@FindBy(id="FirstName")
	WebElement firstnametxt;

	@FindBy(id="LastName")
	WebElement lastNametxt;

	@FindBy(id="Email")
	WebElement emailtxt;

	@FindBy(id="Password")
	WebElement passwordtxt;

	@FindBy(id="ConfirmPassword")
	WebElement confirmPasstxt;

	@FindBy(id="register-button")
	WebElement registerBtn;

	@FindBy(css="div.result")
	public WebElement successmsg;

	@FindBy(linkText="Log out")
	public WebElement logoutlink;
	
	@FindBy(linkText="My account")
	WebElement myaccountlink;

	public void userRegistration(String firstName,String lastName,String email,String password)
	{
		clickButton(genderBtn);
		setElementText(firstnametxt, firstName);
		setElementText(lastNametxt, lastName);
		setElementText(emailtxt, email);
		setElementText(passwordtxt, password);
		setElementText(confirmPasstxt, password);
		clickButton(registerBtn);
	}

	public void userLogout()
	{

		clickButton(logoutlink);
	}

	public void openMyAccountPage()
	{
		
		clickButton(myaccountlink);
	}


}
