package QSP;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo3 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.get("https://www.facebook.com"); 
		
		Dimension d = new Dimension(50,150);
		driver.manage().window().setSize(d);
	    Thread.sleep(2000);
		
		Point p = new Point(100,200);
		driver.manage().window().setPosition(p);
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.manage().window().fullscreen();
		Thread.sleep(2000);
		
	   ((Options) driver.manage().window()).deleteAllCookies();
		Thread.sleep(2000);
		
		driver.close();
	}

}
