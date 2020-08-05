package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	
	//Method to take screenshots in case of test case fails
	
	public static void captureScreenshots(WebDriver driver,String screenShotname)
	{
		
		Path destination =Paths.get("./screenshots/",screenShotname+".png");
		
		try {
			Files.createDirectories(destination.getParent());
			FileOutputStream out=new FileOutputStream(destination.toString());
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		}
		catch (IOException e) {
			System.out.print("Exception while taking screenshot"+e.getMessage());
		}
		
		
	}

}
