package QSP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Xpathdemo2 
{
	public static void main(String[] args) throws InterruptedException
	{
       System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		
       WebDriver driver = new FirefoxDriver();
		
       driver.get("https://www.facebook.com");
		
		driver.findElement(By.className("inputtext")).sendKeys("vinaymuralidhar91@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@name='pass']")).sendKeys("muralivinay");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@value='Log In']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='userNavigationLabel']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='u_1q_5']")).click();
		Thread.sleep(2000);
		
		//driver.close();
		
	}
}
