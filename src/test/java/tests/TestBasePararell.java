package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBasePararell {
	
	public String baseURL="https://demo.nopcommerce.com/";
	
	public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<>();

	
	@BeforeClass
	@Parameters({"browser"})
	public void setUp(@Optional("chrome") String browser) throws MalformedURLException{
		
		driver =new ThreadLocal<>();
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("browserName",browser );
		driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
		getDriver().navigate().to(baseURL);
	}
	
	
	public WebDriver getDriver()
	{
	return driver.get();
	}
	
	
	@AfterClass
	public void stopDriver()
	{
		getDriver().quit();
		driver.remove();
		
	}

	
	
	

}
