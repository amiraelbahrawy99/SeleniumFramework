package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTestInParallel extends TestBasePararell{
	HomePage homeObj;
	ContactUsPage contactUsObj;
	String name="Amira";
	String email="amira@gmail.com";
	String enquiry="I need to buy just one macBook why you don't accept less than 2";
	
	
	@Test
	public void usercanUseContactUs() throws InterruptedException
	{
		Thread.sleep(6000);
		homeObj=new HomePage(getDriver());
		homeObj.openContactUsPage();
		contactUsObj=new ContactUsPage(getDriver());
		Thread.sleep(6000);
		contactUsObj.contactUs(name, email, enquiry);
		Thread.sleep(6000);
		assertTrue(contactUsObj.successMsg.getText().contains("Your enquiry has been successfully"));
		
	}

}
