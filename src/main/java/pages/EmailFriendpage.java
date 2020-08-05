package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendpage extends PageBase {

	public EmailFriendpage(WebDriver driver) {
		super(driver);
	}

  @FindBy(id="FriendEmail")
  WebElement friendEmailTxt;
  
  @FindBy(id="PersonalMessage")
  WebElement personalMsgTxt;
  
  @FindBy(css="input.button-1.send-email-a-friend-button")
  WebElement sendEmailBtn;
  
  @FindBy(css="div.result")
  public WebElement successEmailMsg;
  
  public void emailAFriend(String friendEmail,String personalMsg)
  {
	  
	  setElementText(friendEmailTxt, friendEmail);
	  setElementText(personalMsgTxt, personalMsg);
	  clickButton(sendEmailBtn);
  }
	
	
	
	
}
