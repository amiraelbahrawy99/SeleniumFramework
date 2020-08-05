package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText="Change password")
	WebElement changepasslink;
	
	@FindBy(id="OldPassword")
	WebElement oldPasswordTxt;
	
	@FindBy(id="NewPassword")
	WebElement newPasswordTxt;
	
	@FindBy(id="ConfirmNewPassword")
	WebElement confirmPasswordTxt;
	
	@FindBy(css="input.button-1.change-password-button")
	WebElement changepasswordBtn;
	
	@FindBy(css="div.result")
	public WebElement successPasswordChangedMsg;
	
	public void openChangePasswordPage()
	{
		
		clickButton(changepasslink);	
	}
	
	
	public void changepassword(String oldPassword,String newPassword)
	{
		
		setElementText(oldPasswordTxt, oldPassword);
		setElementText(newPasswordTxt, newPassword);
		setElementText(confirmPasswordTxt, newPassword);
		clickButton(changepasswordBtn);
		
	}
	
	
	
	

}
