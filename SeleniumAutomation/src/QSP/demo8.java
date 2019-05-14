package QSP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class demo8
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		
		driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=29438ru=");
		
		//1.xpath -- 2nd priority
		//absolute xpath should not be used.
		//only relative xpath should be used.
		//driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys("jerry");
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys("tom");
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("6-65/18, mahadevapura");
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id='address2']")).sendKeys("KR puram");
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id='city']")).sendKeys("Bengaluru");
		//Thread.sleep(2000);

		//2.id-- 1st priority
		driver.findElement(By.id("firstname")).sendKeys("tom");
		Thread.sleep(2000);
		driver.findElement(By.id("lastname")).sendKeys("jerry");
		Thread.sleep(2000);
		
		//3.name -- 3rd priority
		//driver.findElement(By.name("firstname")).sendKeys("tom");
		//Thread.sleep(2000);
		//driver.findElement(By.name("lastname")).sendKeys("jerry");
		//Thread.sleep(2000);
		
		//4.link text -- applicable only for links 
		//driver.findElement(By.linkText("Sign in")).click();
		
		//5.partial link text -- not recommended
		//driver.findElement(By.partialLinkText("How to pick")).click();
		
		//6.CSS selector --- most useful since id is used to find elements
		// if id is there --- #{id}
		//if class is there and id is not there then -- .{class}
		//driver.findElement(By.cssSelector("#address1")).sendKeys("6-65/18, Mahadevapura");
		
        //7.class name: can be same for different elements---so, not recommended
		//driver.findElement(By.className("ancAsb")).click();
		
		//8.tag name
		//driver.findElement(By.tagName("a")).sendKeys("tom");
		
		//9.drop down list--Even we can use id and xpath also instead of By.id..
		Select select = new Select(driver.findElement(By.id("state")));
		select.selectByVisibleText("California"); // -- method to select element from drop down list
	}
	
}
