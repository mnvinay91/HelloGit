package QSP;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindElementsDemo 
{

	public static void main(String[] args) throws InterruptedException
	{
       System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		
       WebDriver driver = new FirefoxDriver();
       
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       
       driver.get("https://in.ebay.com/");
       
       driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);   //dynamic wait
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);    //dynamic wait-wait for another 30sec to fully load the page
       
       //1. get the total count of links on the page
       //2. get the text of each link on the page
       
       // all the links are represented by <a> html tag:
       
       //List <WebElement> linklist =   driver.findElements(By.tagName("input")); // input - represents no of input fields - 4
      List <WebElement> linklist =   driver.findElements(By.tagName("a"));  // a represents html tag - 327
       //List <WebElement> linklist =   driver.findElements(By.tagName("button")); // represents no of button fields - 16
     
     //to get size of linklist:
     System.out.println(linklist.size()); // //displays no of linklist in console
     
     for(int i = 0; i<linklist.size();i++)
     {
    	 String linkText = linklist.get(i).getText();
    	 System.out.println(linkText); //displays list of linktext in console
    	 //there are some links which are not visible.
     }
     
    }
}