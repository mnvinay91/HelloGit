package QSP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleFileUploadDemo1 
{
	public static void main(String[] args) throws InterruptedException
	{
		 System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			
	       WebDriver driver = new FirefoxDriver();
	       
	       driver.get("https://html.com/input-type-file/");
	       
	       driver.findElement(By.xpath("//*[@id='fileupload']")).sendKeys("C:\\Users\\Vinay\\Downloads\\Resignation.Docx");
			Thread.sleep(2000);     

	}

}
