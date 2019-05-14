package QSP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Xpathdemo1 
{
	public static void main(String[] args) throws InterruptedException
	{
       System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		
       WebDriver driver = new FirefoxDriver();
		
       driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("vinaymuralidhar91@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.className("RveJvd")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.className("whsOnd")).sendKeys("dirtyFELLOW");
		Thread.sleep(2000);
		
		driver.findElement(By.className("CwaK9")).click();
		Thread.sleep(2000);
		
		//driver.close();
		
	}
}
