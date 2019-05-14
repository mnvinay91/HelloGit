package QSP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitlyWait
{

	public static void main(String[] args) throws InterruptedException
	{
       System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		
       WebDriver driver = new FirefoxDriver();
       
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       
       driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);   //dynamic wait
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);    //dynamic wait-wait for another 30sec to fully load the page
       
       driver.get("https://www.facebook.com/");
       clickOn(driver, driver.findElement(By.xpath("//*[@value='Log In']")), 20);
       clickOn(driver, driver.findElement(By.xpath("//*[@id='reg-link']")), 20);

	}
	
	public static void clickOn(WebDriver driver, WebElement Locator, int timeout)
	{
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(Locator));
		Locator.click();
	}

}
