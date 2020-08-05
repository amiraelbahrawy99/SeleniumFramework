package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddReviewPage extends PageBase {

	public AddReviewPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(id="AddProductReview_Title")
	WebElement reviewTitleTxt;
	
	@FindBy(id="AddProductReview_ReviewText")
	WebElement reviewTextTxt;
	
	@FindBy(id="addproductrating_2")
	WebElement ratingRadioBtn;
	
	@FindBy(css="input.button-1.write-product-review-button")
	WebElement submitReviewBtn;

	@FindBy(css="div.result")
	public WebElement reviewResult;
	
	
	public void submitProductReview(String reviewTitle,String reviewText)
	{
		setElementText(reviewTitleTxt, reviewTitle);
		setElementText(reviewTextTxt, reviewText);
		clickButton(ratingRadioBtn);
		clickButton(submitReviewBtn);
		
	}
}
