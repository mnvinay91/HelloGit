package QSP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessChromeTest {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("window-size=140,800");
	     options.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(options);
		
         driver.get("https://www.crmpro.com/index.html");
         
         System.out.println("home page title=:"+driver.getTitle());
		
		//driver.findElement(By.name("username")).sendKeys("mnvinay91");
		Thread.sleep(5000);
		
		//driver.findElement(By.name("password")).sendKeys("dirtyFELLOW7@");
		//Thread.sleep(5000);
		
		//driver.findElement(By.xpath("//input[@type ='submit']")).click();
		
		//driver.findElement(By.xpath("//input[@value ='Login']")).click();
		//Thread.sleep(5000);
		
		//System.out.println("login home page title =:"+driver.getTitle());


	}

}
