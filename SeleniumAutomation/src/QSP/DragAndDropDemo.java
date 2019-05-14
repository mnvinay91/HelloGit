package QSP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemo {

	public static void main(String[] args) throws InterruptedException
	{
       System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		
       WebDriver driver = new FirefoxDriver();
       
       driver.manage().window().maximize();
       
       driver.manage().deleteAllCookies();
       
       driver.get("https://jqueryui.com/droppable/");
       
       driver.switchTo().frame(0);
       
       Actions action = new Actions(driver);
       
       action.clickAndHold(driver.findElement(By.xpath("//*[@id = 'draggable']")))   //source
       .moveToElement(driver.findElement(By.xpath("//*[@id = 'droppable']")))         //destination
       .release()
       .build()
       .perform();;
	}
}