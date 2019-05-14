package QSP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverConcept 
{
		public static void main(String[] args) throws InterruptedException
		{
	       System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			
	       //WebDriver driver = new FirefoxDriver();
	     
	       //advantages: 1. testing is happening behind the scene-no browser is launched.
	                   //2.execution of test cases is very fast.
	                   //3.improves performance of the script.
	                   //4.not suitable for action class, mouse movement, drag and drop.
	                   //5.ghost driver - headless driver.
	                   //6.sanity and smoke testing point of view, it is very useful.
	       WebDriver driver = new HtmlUnitDriver();
	     
	       driver.manage().window().maximize();
	       driver.manage().deleteAllCookies();
	       
	       driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);   //dynamic wait
	       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);    //dynamic wait-wait for another 30sec to fully load the page
	       
	       driver.get("https://www.crmpro.com/index.html");
	       
	       System.out.println("Before login, title is:===" + driver.getTitle());
			
			driver.findElement(By.name("Username")).sendKeys("mnvinay91");
			
			driver.findElement(By.name("Password")).sendKeys("dirtyFELLOW7@");
			
			driver.findElement(By.xpath("//input[@type ='submit']")).click();
			
			System.out.println("After login, title is:==="+ driver.getTitle());
		

	}

}
