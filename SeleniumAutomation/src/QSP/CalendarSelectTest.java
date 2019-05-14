package QSP;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarSelectTest {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		//System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		//WebDriver driver = new ChromeDriver();
		
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
		
		String date = "11-May-2017";
		
		String dateArr[] = date.split("-");
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];
		
		Select select = new Select(driver.findElement(By.name("slctMonth")));
		select.selectByVisibleText(month);
		
		Select select1 = new Select(driver.findElement(By.name("slctYear")));
		select.selectByVisibleText(year);
		
		//html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/div/table/tbody/tr/td[2]/div/div[1]/div[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
		//html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/div/table/tbody/tr/td[2]/div/div[1]/div[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[3]
		//html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/div/table/tbody/tr/td[2]/div/div[1]/div[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[6]
		
		String beforeXpath = "//html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/div/table/tbody/tr/td[2]/div/div[1]/div[2]/table/tbody/tr[2]/td/table/tbody/tr[";
		
		 String afterXpath = "]/td[";
		 
		 final int totalWeekDays = 7;
		 
		//2-1  2-2  2-3  2-4  2-5  2-6  2-7
		//3-1  3-2  3-3  3-4  3-5  3-6  3-7
		 boolean flag = false;
		 String dayVal = null;
		 for(int rowNum=2; rowNum<=7;rowNum++)
		 {
			 for(int colNum=2; colNum<=totalWeekDays; colNum++)
			 {
				 try
				 {
			  dayVal = driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).getText();
				 } 
				 catch (NoSuchElementException e) 
				 {
                 System.out.println("please enter a correct date value");
                 flag = false;
                 break;
				 }
			  System.out.println(dayVal);
			  if(dayVal.equals(day))
			  {
				  driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).click();
				  flag = true;
				  break;   
			  }
		 }
			 if(flag)
			 {
				 break;
			 }
		 
	}

}
}
