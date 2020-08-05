package tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests {

	public static WebDriver driver;
	public static String downloadPath=System.getProperty("user.dir")+"\\downloads";
	
	//For download in the folder we need		
	public static ChromeOptions chromeOption()
	{
		ChromeOptions options=new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
		
	}
		
	//For download in Silent Mode as Chrome
	public static FirefoxOptions firefoxOption() {
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		option.addPreference("pdfjs.disabled", true);
		return option;
	}

	
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName) throws InterruptedException
	{
		if (browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver=new ChromeDriver(chromeOption());
		}
		
		
		else if (browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver=new FirefoxDriver(firefoxOption());
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");
		Thread.sleep(4000);

	}

	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
	}

	//Take screenshot if test case fails and add it to screenshot folder

	@AfterMethod
	public void screenshotOnFailure(ITestResult result)
	{
		
		if (result.getStatus()==ITestResult.FAILURE) {
			System.out.println("Failed");
			System.out.println("Taking Screenshot....");
			Helper.captureScreenshots(driver, result.getName());

		}
		
	}



}
