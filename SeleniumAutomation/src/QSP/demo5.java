package QSP;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

public class demo5 
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
	}
	
	public static void main(String[] args) throws InterruptedException
	{
     WebDriver driver = null;
     
     System.out.println("enter browser name");
     
     Scanner scan =  new Scanner(System.in);
     
     String browser = scan.nextLine();
     
     if 
     (browser.equals("Chrome"))
     {
    	 driver = new ChromeDriver();	
     }
     else if(browser.equals("firefox"))
     {
    	 driver = new FirefoxDriver();	
     }
     Thread.sleep(2000);
     driver.close();
	}

}
