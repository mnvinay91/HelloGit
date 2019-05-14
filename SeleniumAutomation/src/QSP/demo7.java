package QSP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo7 
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	}
		public static void main(String[] args) throws InterruptedException
		{
			WebDriver driver = new ChromeDriver();
			driver.get("file:///C:/Users/Vinay/Desktop/facebook.html");
			Thread.sleep(2000);
			
			//by using ID
			WebElement button = driver.findElement(By.id("f"));
			button.click();
			Thread.sleep(2000);
			driver.navigate().back();
			
			//by using name
			driver.findElement(By.name("fb")).click();
			Thread.sleep(2000);
			driver.navigate().back();
			
			//by using class name
			driver.findElement(By.className("fb1")).click();
			Thread.sleep(2000);
			driver.navigate().back();
			
			//by using tag name
			driver.findElement(By.tagName("a")).click();
			Thread.sleep(2000);
			driver.navigate().back();
			
			//by using link text
			driver.findElement(By.linkText("fb1")).click();
	}

}
