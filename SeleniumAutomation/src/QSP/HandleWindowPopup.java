package QSP;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleWindowPopup {

	public static void main(String[] args) throws InterruptedException
	{
       System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		
       WebDriver driver = new FirefoxDriver();
       
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       
       driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);   //dynamic wait
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);    //dynamic wait-wait for another 30sec to fully load the page
       
       driver.get("http://www.popuptest.com/goodpopups.html");
       
       driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[3]")).click();
       
       Thread.sleep(2000);
       
      Set<String> handler = driver.getWindowHandles();
      
      Iterator<String> it = handler.iterator();
      
      String parentWindowId = it.next();
      System.out.println("parent window id:"+parentWindowId);
      
      String ChildWindowId = it.next();
      System.out.println("Child Window Id:"+ChildWindowId);
      
      driver.switchTo().window(ChildWindowId);
      
      Thread.sleep(2000);
      System.out.println("Child Window Pop Up title:"+driver.getTitle());
      
      driver.close();
      
      driver.switchTo().window(parentWindowId);
      Thread.sleep(2000);
      
      System.out.println("parent window title:"+driver.getTitle());
      
       
       
	}

}
