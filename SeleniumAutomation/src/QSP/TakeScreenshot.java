package QSP;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TakeScreenshot 
{
	public static void main(String[] args) throws InterruptedException, IOException
	{
       System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		
       WebDriver driver = new FirefoxDriver();
       
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       
       driver.get("https://www.google.co.in/");
       
       //take screenshot and store it as a file format
       File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       // copy the screenshot to deired location using copy file method.
       FileUtils.copyFile(src, new File("\\java programs\\java\\SeleniumAutomation\\src\\QSP\\google.png"));
      
       //TakesScreenshot ts = (TakesScreenshot).driver;
       //File src = ts.getScreenshotAs(OutputType.FILE);
       //File dest = new File("./demo.png");
       //FileUtils.copyFile(src,dest);
       Thread.sleep(5000);
       
      

}
}
