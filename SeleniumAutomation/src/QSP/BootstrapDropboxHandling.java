package QSP;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BootstrapDropboxHandling 
{
		public static void main(String[] args) throws InterruptedException 
		{
			//System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			
			//WebDriver driver = new FirefoxDriver();
			
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.manage().deleteAllCookies();
			
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
			
			driver.findElement(By.xpath("//button[contains(@class,'multiselect dropdown-toggle btn btn-default')]")).click();
			
			List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//li//a//label"));
			
			System.out.println(list.size());
			
			//for selecting all the check boxes
			for(int i=0; i<list.size();i++)
			{
			System.out.println(list.get(i).getText());
				list.get(i).click();

			}
				}
			
		//for selecting individual check boxes
//			for(int i=0; i<list.size();i++)
//			{
//			System.out.println(list.get(i).getText());
//			if(list.get(i).getText().contains("Angular"))
//		{
//				list.get(i).click();
//				break;
		}
				
			
			


