package QSP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicWebTableHandling {

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
		
		driver.get("https://www.crmpro.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("mnvinay91");
		Thread.sleep(5000);
		
		driver.findElement(By.name("password")).sendKeys("dirtyFELLOW7@");
		Thread.sleep(5000);
		
		//driver.findElement(By.xpath("//input[@type ='submit']")).click();
		
		driver.findElement(By.xpath("//input[@value ='Login']")).click();
		Thread.sleep(5000);
		
		driver.switchTo().frame("mainpanel");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		driver.findElement(By.xpath("//input[@type='checkbox' and @name='contact_id' and @value='52674057']")).click();
		//a[text()='NANDA BULLOCKS']//parent::td[@class ='datalistrow']//preceeding-sibling::td[@class ='datalistrow']//input[@name ='contact_id']

		//html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/form/form/table/tbody/tr[4]/td[2]/a
		//html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/form/form/table/tbody/tr[5]/td[2]/a
		//html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/form/form/table/tbody/tr[6]/td[2]/a
		//html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/form/form/table/tbody/tr[7]/td[2]/a
		
		//1.method -I:
//		String before_xpath = "//html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/form/form/table/tbody/tr[";
//		String after_xpath = "]/td[2]/a";
		
//		for(int i =4; i<=7; i++)
//		{
//			String name = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
//			System.out.println(name);
//			if(name.contains("kodanda ramaiah")) //select the name of the row 
//			{
//			driver.findElement(By.xpath("//html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/form/form/table/tbody/tr["+i+"]/td[1]/input")).click();
//			//html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/form/form/table/tbody/tr[5]/td[1]/input
//			}
//		}
		
		//2.method -II: avoids using for loop
		driver.findElement(By.xpath("//a[contains(text(),'NANDA BULLOCKS')]/parent::td//preceeding-sibling::td//input[@name='contact_id']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'kodanda ramaiah')]/parent::td//preceeding-sibling::td//input[@name='contact_id']")).click();
		//a[contains(text(),'NANDA BULLOCKS')]/parent::td//preceeding-sibling::td//input[@name='contact_id']

	}
}

