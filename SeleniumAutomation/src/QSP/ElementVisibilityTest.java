package QSP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTest 
{
	public static void main(String[] args) throws InterruptedException
	{
      System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
      WebDriver driver = new ChromeDriver();
       
       driver.get("https://www.crmpro.com/register/");
       
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       
       driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);   //dynamic wait
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);    //dynamic wait-wait for another 30sec to fully load the page
       
       //1.isDisplayed(): method applicable for all elements
       boolean b1 = driver.findElement(By.id("submitButton")).isDisplayed();
       System.out.println(b1);//true
       
       //2.isEnabled(): method applicable for all elements
       boolean b2 = driver.findElement(By.id("submitButton")).isEnabled();
       System.out.println(b2);//false
       
       //select i agree checkbox
       driver.findElement(By.name("agreeTerms")).click();
       boolean b3 = driver.findElement(By.id("submitButton")).isEnabled();
       System.out.println(b3); //true
       
       //3.isSelected(): method applicable for radio buttons, checkbox, dropdown
       driver.findElement(By.name("agreeTerms")).click();
       boolean b4 = driver.findElement(By.id("submitButton")).isSelected();
       System.out.println(b4);//true
       
       //deSelect the check box
       driver.findElement(By.name("agreeTerms")).click();
       boolean b5 = driver.findElement(By.id("submitButton")).isSelected();
       System.out.println(b5);//false
       
	}

}
