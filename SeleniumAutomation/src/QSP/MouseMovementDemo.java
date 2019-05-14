package QSP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementDemo 
{
	public static void main(String[] args) throws InterruptedException
	{
       System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		
       WebDriver driver = new FirefoxDriver();
       
      // driver.get("https://www.spicejet.com/");
       driver.get("http://www.sietk.org/");
       
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       
       driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);   //dynamic wait
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);    //dynamic wait-wait for another 30sec to fully load the page

       Actions action = new Actions(driver);
       
      // action.moveToElement(driver.findElement(By.linkText("ADD-ONS"))).build().perform();
       action.moveToElement(driver.findElement(By.linkText("Exam Cell"))).build().perform();
       Thread.sleep(3000);
       
       //driver.findElement(By.linkText("SpiceMax")).click();
       
       driver.findElement(By.linkText("Syllabus")).click();
           
          }
}