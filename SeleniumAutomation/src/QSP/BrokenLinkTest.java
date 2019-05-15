/*
 * @author vinay
 * 
 */


package QSP;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrokenLinkTest {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		//System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		
		//WebDriver driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.crmpro.com/index.html");
		
		//driver.findElement(By.name("username")).sendKeys("mnvinay91");
		//Thread.sleep(5000);
		
		//driver.findElement(By.name("password")).sendKeys("dirtyFELLOW7@");
		//Thread.sleep(5000);
		
		//driver.findElement(By.xpath("//input[@type ='submit']")).click();
		
		//driver.findElement(By.xpath("//input[@value ='Login']")).click();
		//Thread.sleep(5000);
		
		//driver.switchTo().frame("mainpanel");
		
		//links - //a href<http://www.google.com>
		//images - //img href<http://www.test.com>
		
		//1.get the list of all the links and images:
		List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		linkslist.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("size of full links and images:"+linkslist.size());
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		//2. iterate linklist -  exclude all the links/images - which doesnt have any href attribute
		for(int i=0; i<linkslist.size();i++)
		{
			System.out.println(linkslist.get(i).getAttribute("href"));
			if(linkslist.get(i).getAttribute("href")!= null && (!linkslist.get(i).getAttribute("href").contains("javascript")))
			{
		 	activeLinks.add(linkslist.get(i));
				
			}
		}
		
		//3.get the size of active link list:
		System.out.println("size of active links and images:"+activeLinks.size());
		
		//4.check the href,url, with the httpconnection api:
		for(int j=0; j<activeLinks.size();j++)
		{
			HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href") + "---->" + response);
		}
	}
	
}

		




