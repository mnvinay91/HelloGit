package QSP;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropFile 
{
	static WebDriver driver;
	public static void main(String[] args) throws IOException 
	{
	Properties prop = new Properties();
	
	// file input stream will connect to the below property. 
	//it creates an input stream between java code and config.properties class. 
	FileInputStream ip = new FileInputStream("E:\\java programs\\java\\SeleniumAutomation\\src\\QSP\\config.properties");
	
	// used to load that config.properties file
	prop.load(ip);
	
	System.out.println(prop.getProperty("name"));
	
	System.out.println(prop.getProperty("age"));
	
	String url = prop.getProperty("url");
	System.out.println(url);
	
	String browserName = prop.getProperty("browser");
	System.out.println(browserName);
	
	if (browserName.equals("chrome"))
	   {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		}
	
	else if(browserName.equals("firefox"))
		
	   {
	    System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
	   driver = new FirefoxDriver();
	   }
	
	   driver.get(url);
	   
	   driver.findElement(By.xpath(prop.getProperty("firstName_xpath"))).sendKeys(prop.getProperty("firstName"));
	   
	   driver.findElement(By.xpath(prop.getProperty("lastName_xpath"))).sendKeys(prop.getProperty("lastName"));
	   
	   driver.findElement(By.xpath(prop.getProperty("city_xpath"))).sendKeys(prop.getProperty("city"));
	
	

	}

}
