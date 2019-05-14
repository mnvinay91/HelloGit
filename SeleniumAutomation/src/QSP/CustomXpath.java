package QSP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CustomXpath
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
       
       //driver.findElement(By.xpath("//input[@class = 'gh-tb ui-autocomplete-input']")).sendKeys("java");
       
       driver.findElement(By.xpath("//input[contains(@class,'gh-tb ui-autocomplete-input')]")).sendKeys("java");
       
       //dynamic id's(if id's are changing): It can be handled by using contains method.
       // driver.findElement(By.xpath("//input[contains(@id,'test_')]")).sendKeys("java");
       // driver.findElement(By.xpath("//input[starts-with(@id,'test_')]")).sendKeys("java");
       // driver.findElement(By.xpath("//input[ends-with(@id,'test_')]")).sendKeys("java");
       
       //for custom xpath:
       //all the links are represented by <a> html tag:
       driver.findElement(By.xpath("//a[contains(text(),'My eBay')]")).click();
       //customized xpath is unique, simple, fast 
       
       //customized xpath is very fast compared to absolute xpath {parent node to child node-it is not dynamic}
       // minimal changes should be made in the script.
       //reliable and robust xpath should be considered.so, absolute xpath is not recommended.
       //performance of the script varies by using absolute xpath.
     }
}
