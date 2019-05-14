package QSP;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptExecutorConcept 
{
	public static void main(String[] args) throws InterruptedException, IOException
	{
       //System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
       System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
      // WebDriver driver = new FirefoxDriver();
       WebDriver driver = new ChromeDriver();
       
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       
       driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);   //dynamic wait
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);    //dynamic wait-wait for another 30sec to fully load the page
       
   	   driver.get("https://www.crmpro.com/index.html");
   	   
       driver.findElement(By.name("username")).sendKeys("mnvinay91");
	
	   driver.findElement(By.name("password")).sendKeys("dirtyFELLOW7@");
	
	   driver.findElement(By.xpath("//input[@value ='Login']")).click();
	   
	  WebElement loginBtn = driver.findElement(By.xpath("//input[@value ='Login']"));
	   
	  flash(loginBtn, driver); // highlights the element with green color.
	   
	  drawBorder(loginBtn, driver); // highlights the element with a border.
	
	  //take screenshot and store it as a file format
       File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    // copy the screenshot to deired location using copy file method.
       FileUtils.copyFile(src, new File("\\java programs\\java\\SeleniumAutomation\\src\\QSP\\CRM.png"));

   
	//generate alert
	 generateAlert(driver, "there is an issue with login button on login page");
    
    //Click on any element by using JS executor.
      clickElementByJS(loginBtn, driver);
	
	//refresh browser by selenium.
	  driver.navigate().refresh();
	
	//refresh browser by JS.
	  refreshBrowserByJS(driver);
	
	//get the title of the page by JS 
	  System.out.println(getTitleByJS(driver));
	
	//get the inner text of the page by JS 
	  System.out.println(getInnerPageTextByJS(driver));
	
	//Scroll page down
	   scrollPageDownByJS(driver);
	   
	 //Scroll into view
	   WebElement forgotPwdLink = driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?']"));
	   scrollIntoViewByJS(forgotPwdLink, driver);
}
		
  //**************************************************************************************************//    

	// java script executor is a class and we have to cast our driver into java script executor
	// execute script method is used to execute java script code.
	
	public static void flash(WebElement element,WebDriver driver)
     {
	JavascriptExecutor js = ((JavascriptExecutor) driver);
	String bgcolor = element.getCssValue("backgroungColor");
	 for (int i=0;i<100;i++) //this loop will call the change color method
	 {
		 changeColor("rgb(0,200,0)", element, driver);
		 changeColor(bgcolor, element, driver);
	 }	 
	 }
	
	//method for highlighting the web element with blinking color
	public static void changeColor(String color, WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element);
		}
	
	// method for drawing border for highlighted element
	public static void drawBorder(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border = '3px solid red'", element);
	     }
		
	//method for generating alert
	public static void generateAlert(WebDriver driver, String message)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+message+"')");
        }
		
	//method for clicking on login button using java script
	public static void clickElementByJS(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();",element);
        }
		
	//method for refreshing page using java script
	public static void refreshBrowserByJS(WebDriver driver)
	{
		  JavascriptExecutor js = ((JavascriptExecutor) driver);
		  js.executeScript("hisory.go(0)");
		}
		
	//method for getting page title
	public static String getTitleByJS(WebDriver driver)
	{
		 JavascriptExecutor js = ((JavascriptExecutor) driver);
		 String title = js.executeScript("return document.title;").toString();
		 return title;			
        }
	
	//method for getting inner page text
	public static String getInnerPageTextByJS(WebDriver driver)
	{
		  JavascriptExecutor js = ((JavascriptExecutor) driver);
		  String pageText = js.executeScript("return document.documentElement.innerTEXT;").toString();
	      return pageText;
}
	//method for scrolling page 
	public static void scrollPageDownByJS(WebDriver driver)
	{
		 JavascriptExecutor js = ((JavascriptExecutor) driver);
		 js.executeScript("window.scrollTo(0,document.body.scrollHieght)");
	}
	
	//method for scrolling into view
	//method for scrolling page 
		public static void scrollIntoViewByJS(WebElement element, WebDriver driver)
		{
			 JavascriptExecutor js = ((JavascriptExecutor) driver);
			 js.executeScript("arguments[0].scrollIntoView(true);" , element);
		}
}
