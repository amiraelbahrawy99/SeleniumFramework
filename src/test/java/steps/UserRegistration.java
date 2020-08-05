package steps;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase{
	HomePage homeObj;
	UserRegistrationPage userRegisterObj; 
	String firstName="Amira";
	String lastName="Amin";
	String email="amex14ddfcgf@gmail.com";
	String Password="123456";

	@Given("^User is on HomePage$")
	public void user_is_on_HomePage() throws InterruptedException {
		Thread.sleep(2000);
		homeObj=new HomePage(driver);
		homeObj.openRegisterationPage();

	}

	@When("^User clicks on register Link$")
	public void user_clicks_on_register_Link() {

		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	
	@When("^User enters these data \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void user_enters_these_data(String firstName, String lastName, String email, String password) throws InterruptedException  {
	   
		Thread.sleep(2000);
		userRegisterObj=new UserRegistrationPage(driver);
		userRegisterObj.userRegistration(firstName, lastName, email, Password);
		
	}

/*	@When("^User enters his own data$")
	public void user_enters_his_own_data() throws InterruptedException {
		Thread.sleep(2000);
		userRegisterObj=new UserRegistrationPage(driver);
		userRegisterObj.userRegistration(firstName, lastName, email, Password);
	}*/

	@Then("^Registration page is displayed successfully$")
	public void registration_page_is_displayed_successfully() {
		userRegisterObj=new UserRegistrationPage(driver);
		userRegisterObj.userLogout();

	}




}
