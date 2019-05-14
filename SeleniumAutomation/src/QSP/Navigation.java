package QSP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Navigation 
{
	public static void main(String[] args) throws InterruptedException
	{
       System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		
       WebDriver driver = new FirefoxDriver();
       
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       
       driver.get("https://www.google.co.in/");
       
       driver.navigate().to("https://www.amazon.in/");
       
       //back and forward button simulation
       driver.navigate().back();
       Thread.sleep(5000);
       
       driver.navigate().forward();
       Thread.sleep(5000);
       
       driver.navigate().back();
       
       driver.navigate().refresh();
       

	}

}
