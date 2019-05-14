package QSP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo6 
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
		WebElement button = driver.findElement(By.id("ff"));
		button.click();
		Thread.sleep(5000);
		driver.close();
	}
		
	}


