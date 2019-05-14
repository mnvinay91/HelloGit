package QSP;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PopupDemo1 
{
	public static void main(String[] args) throws InterruptedException
	{
       System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		
       WebDriver driver = new FirefoxDriver();
       
       driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
       
       driver.findElement(By.name("proceed")).click();
       Thread.sleep(2000);
       
       Alert alert = driver.switchTo().alert();
       
       System.out.println(alert.getText());
       
       String text = alert.getText();
       if(text.equals("Please enter a valid user name"))
       {
    	   System.out.println("correct alert msg");
       }
    	   else
    	   {
    		   System.out.println("in-correct alert msg");
       }
       
       alert.accept(); //to click on OK button
       
      // alert.dismiss();
       
	}
}