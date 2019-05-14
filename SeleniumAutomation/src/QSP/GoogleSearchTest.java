package QSP;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	public static void main(String[] args) throws InterruptedException, IOException
	{
       //System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
       System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
      // WebDriver driver = new FirefoxDriver();
       WebDriver driver = new ChromeDriver();
       
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       
       driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);   //dynamic wait
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);    //dynamic wait-wait for another 30sec to fully load the page
       
   	   driver.get("https://www.google.co.in");
   	   
   	   driver.findElement(By.name("q")).sendKeys("testing");
   	   
   	  List <WebElement> list = driver.findElements(By.xpath("//ul[@role ='listbox']//li/descendant::div[@class='sbl1']")); //dynamic customized xpath
   	  //descendant will provide hierarchy from parent level to child level.
   	  
   	  System.out.println("total number of suggessions in search box:"+list.size());
   	   
   	  for(int i=0;i<list.size();i++)
   	  {
   		  System.out.println(list.get(i).getText());
   		  if(list.get(i).getText().contains("testing tools"))
   		  {
   			  list.get(i).click();
   			  break;
   		  }
   		  
   	  }
   	   
   	   
	}

}
